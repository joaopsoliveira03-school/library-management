package Repository;

import Aggregate.Loan;
import Entity.LoanId;
import Entity.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryLoanRepository implements ILoanRepository {
    private final List<Loan> loans = new ArrayList<>();

    @Override
    public void save(Loan loan) {
        loans.add(loan);
    }

    @Override
    public Optional<Loan> findById(LoanId id) {
        return loans.stream()
                    .filter(loan -> loan.getId().equals(id))
                    .findFirst();
    }

    @Override
    public List<Loan> findAll() {
        return loans;
    }

    @Override
    public List<Loan> findActiveLoansByMember(Member member) {
        return loans.stream()
                    .filter(loan -> loan.getMember().equals(member))
                    .toList();
    }

    @Override
    public void delete(Loan loan) {
        loans.remove(loan);
    }
}
