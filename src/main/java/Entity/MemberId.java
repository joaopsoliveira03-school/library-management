package Entity;

public class MemberId {
    private final String value;

    public MemberId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberId memberId = (MemberId) o;

        return value.equals(memberId.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
