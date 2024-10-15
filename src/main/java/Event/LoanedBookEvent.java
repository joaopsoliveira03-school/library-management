package Event;

public record LoanedBookEvent(String bookId, String memberId) implements IEvent {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoanedBookEvent that = (LoanedBookEvent) o;

        if (!bookId.equals(that.bookId)) return false;
        return memberId.equals(that.memberId);
    }

    @Override
    public String toString() {
        return "LoanedBookEvent{" +
                "bookId='" + bookId + '\'' +
                ", memberId='" + memberId + '\'' +
                '}';
    }
}
