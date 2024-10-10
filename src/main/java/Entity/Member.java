package Entity;

import ValueObject.Email;

import java.time.LocalDate;

public class Member {
    private final MemberId id;
    private String name;
    private Email email;
    private LocalDate suspensionDate;

    public Member(MemberId id, String name, Email email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public boolean isSuspended() {
        return suspensionDate != null && suspensionDate.isAfter(LocalDate.now());
    }

    public void suspend(LocalDate endSuspensionDate) {
        this.suspensionDate = endSuspensionDate;
    }

    public void removeSuspension() {
        this.suspensionDate = null;
    }

    public MemberId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        return id.equals(member.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}