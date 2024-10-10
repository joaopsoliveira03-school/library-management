package Repository;

import Aggregate.Loan;
import Entity.LoanId;
import Entity.Member;

import java.util.List;
import java.util.Optional;

public interface ILoanRepository {
    void save(Loan loan);
    Optional<Loan> findById(LoanId id);
    List<Loan> findAll();
    List<Loan> findActiveLoansByMember(Member member);
    void delete(Loan loan);
}