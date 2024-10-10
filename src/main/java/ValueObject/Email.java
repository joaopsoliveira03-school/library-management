package ValueObject;

public class Email {
    private final String address;

    public Email(String address) {
        if (!isValid(address)) {
            throw new IllegalArgumentException("Invalid ValueObject.Email");
        }
        this.address = address;
    }

    private boolean isValid(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        return address.equals(email.address);
    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }
}