package Factory;

import Aggregate.Loan;
import Entity.Book;
import Entity.Member;

public class LoanFactory {
    public static Loan createLoan(Book book, Member member) {
        return new Loan(LoanIdFactory.createLoanId(), book, member);
    }
}
