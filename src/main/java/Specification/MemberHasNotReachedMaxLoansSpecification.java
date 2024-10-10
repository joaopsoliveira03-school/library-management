package Specification;

import Entity.Member;
import Repository.ILoanRepository;

public class MemberHasNotReachedMaxLoansSpecification implements Specification<Member> {
    private static final int MAX_LOANS = 3;
    private final ILoanRepository loanRepository;

    public MemberHasNotReachedMaxLoansSpecification(ILoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public boolean isSatisfiedBy(Member member) {
        return loanRepository.findActiveLoansByMember(member).size() < MAX_LOANS;
    }
}