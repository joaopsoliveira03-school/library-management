package DomainEvent;

public class LoanedBookEvent {
    private final String bookId;
    private final String memberId;

    public LoanedBookEvent(String bookId, String memberId) {
        this.bookId = bookId;
        this.memberId = memberId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getMemberId() {
        return memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoanedBookEvent that = (LoanedBookEvent) o;

        if (!bookId.equals(that.bookId)) return false;
        return memberId.equals(that.memberId);
    }

    @Override
    public int hashCode() {
        int result = bookId.hashCode();
        result = 31 * result + memberId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LoanedBookEvent{" +
                "bookId='" + bookId + '\'' +
                ", memberId='" + memberId + '\'' +
                '}';
    }

    public void publish() {
        System.out.println(this);
    }
}
