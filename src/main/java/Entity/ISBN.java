package Entity;

public class ISBN {
    private final String value;

    public ISBN(String value) {
        if (!isValid(value)) {
            throw new IllegalArgumentException("Invalid ISBN");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private boolean isValid(String isbn) {
        return isbn.matches("^(97([89]))?\\d{9}(\\d|X)$"); // example: 978-3-16-148410-0
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ISBN isbn = (ISBN) o;

        return value.equals(isbn.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}