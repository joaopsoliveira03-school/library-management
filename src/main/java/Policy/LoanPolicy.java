package Policy;

import Aggregate.Loan;
import Entity.Member;
import Exceptions.BusinessException;
import Repository.ILoanRepository;

import java.util.List;

public class LoanPolicy {
    private static final int MAX_LOANS = 3;
    private final ILoanRepository loanRepository;

    public LoanPolicy(ILoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public void checkLoanEligibility(Member member) {
        List<Loan> activeLoans = loanRepository.findActiveLoansByMember(member);
        if (activeLoans.size() >= MAX_LOANS) {
            throw new BusinessException("Member has reached the maximum number of loans");
        }
    }
}