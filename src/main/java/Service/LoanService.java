package Service;

import Aggregate.Loan;
import Event.EventBus;
import Event.LoanedBookEvent;
import Entity.*;
import Exceptions.BusinessException;
import Exceptions.EntityNotFoundException;
import Factory.LoanFactory;
import Repository.IBookRepository;
import Repository.ILoanRepository;
import Repository.IMemberRepository;
import Specification.AndSpecification;
import Specification.MemberHasNotReachedMaxLoansSpecification;
import Specification.MemberIsNotSuspendedSpecification;
import Specification.Specification;

public class LoanService {
    private final IBookRepository IBookRepository;
    private final IMemberRepository IMemberRepository;
    private final ILoanRepository ILoanRepository;

    public LoanService(IBookRepository IBookRepository,
                       IMemberRepository IMemberRepository,
                       ILoanRepository ILoanRepository) {
        this.IBookRepository = IBookRepository;
        this.IMemberRepository = IMemberRepository;
        this.ILoanRepository = ILoanRepository;
    }

    public Loan createLoan(ISBN isbn, MemberId memberId) {
        Book book = IBookRepository.findByISBN(isbn)
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));
        Member member = IMemberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));

        Specification<Member> loanEligibilitySpec = new AndSpecification<Member>(
                new MemberIsNotSuspendedSpecification(),
                new MemberHasNotReachedMaxLoansSpecification(ILoanRepository)
        );

        if (!loanEligibilitySpec.isSatisfiedBy(member)) {
            throw new BusinessException("Member is not eligible for a loan");
        }

        Loan loan = LoanFactory.createLoan(book, member);
        ILoanRepository.save(loan);

        EventBus.getInstance().publish(new LoanedBookEvent(loan.getBook().getIsbn().getValue(), loan.getMember().getId().getValue()));

        return loan;
    }

    public Loan returnLoan(LoanId loanId) {
        Loan loan = ILoanRepository.findById(loanId)
                .orElseThrow(() -> new EntityNotFoundException("Loan not found"));

        loan.returnBook();

        //ILoanRepository.save(loan);

        return loan;
    }
}