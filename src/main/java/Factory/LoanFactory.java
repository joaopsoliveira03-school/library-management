package Factory;

import Aggregate.Loan;
import Entity.Book;
import Entity.Member;

import java.util.UUID;

public class LoanFactory {
    public static Loan createLoan(Book book, Member member) {
        return new Loan(LoanIdFactory.createLoanId(UUID.randomUUID().toString()), book, member);
    }
}
