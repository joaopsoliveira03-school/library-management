package Factory;

import Entity.LoanId;

public class LoanIdFactory {
    private static int idCounter = 0;

    public static LoanId createLoanId() {
        return new LoanId(String.valueOf(idCounter++));
    }
}