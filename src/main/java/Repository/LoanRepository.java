package Repository;

import Aggregate.Loan;
import Entity.LoanId;
import Entity.Member;

import java.util.List;
import java.util.Optional;

public class LoanRepository implements ILoanRepository {
    @Override
    public void save(Loan loan) {

    }

    @Override
    public Optional<Loan> findById(LoanId id) {
        return Optional.empty();
    }

    @Override
    public List<Loan> findAll() {
        return List.of();
    }

    @Override
    public List<Loan> findActiveLoansByMember(Member member) {
        return List.of();
    }

    @Override
    public void delete(Loan loan) {

    }
}
