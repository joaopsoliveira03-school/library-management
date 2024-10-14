package Factory;

import Entity.LoanId;

public class LoanIdFactory {
    public static LoanId createLoanId(String id) {
        return new LoanId(id);
    }
}