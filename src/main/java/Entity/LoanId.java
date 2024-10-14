package Entity;

public class LoanId {
    private final String value;

    public LoanId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoanId loanId = (LoanId) o;

        return value.equals(loanId.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "LoanId{" +
                "value='" + value + '\'' +
                '}';
    }
}
