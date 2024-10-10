package Aggregate;

import Entity.Book;
import Entity.LoanId;
import Entity.Member;

import java.time.LocalDate;

public class Loan {
    private final LoanId id;
    private final Book book;
    private final Member member;
    private final LocalDate loanDate;
    private LocalDate loanExpectedReturnDate;
    private LocalDate loanReturnDate;

    public Loan(LoanId id, Book book, Member member) {
        this.id = id;
        this.book = book;
        this.member = member;
        this.loanDate = LocalDate.now();
        this.loanReturnDate = loanDate.plusDays(14);
    }

    public void extendReturnDate(int days) {
        if (loanReturnDate != null) {
            throw new IllegalStateException("Loan already returned");
        }
        this.loanExpectedReturnDate = this.loanExpectedReturnDate.plusDays(days);
    }

    public void returnBook() {
        this.loanReturnDate = LocalDate.now();
    }

    public boolean isLate() {
        return LocalDate.now().isAfter(loanExpectedReturnDate) && loanReturnDate == null;
    }

    public LoanId getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getLoanExpectedReturnDate() {
        return loanExpectedReturnDate;
    }

    public LocalDate getLoanReturnDate() {
        return loanReturnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loan loan = (Loan) o;

        return id.equals(loan.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}