import Aggregate.Loan;
import Service.BookService;
import Service.LoanService;
import Service.MemberService;
import Entity.Book;
import Entity.ISBN;
import Entity.Member;
import Entity.MemberId;
import Factory.ISBNFactory;
import Factory.MemberIdFactory;
import Repository.*;
import ValueObject.Author;

public class Main {
    public static void main(String[] args) {
        // Initialize repositories
        IBookRepository bookRepository = new InMemoryBookRepository();
        IMemberRepository memberRepository = new InMemoryMemberRepository();
        ILoanRepository loanRepository = new InMemoryLoanRepository();

        // Initialize services
        BookService bookService = new BookService(bookRepository);
        LoanService loanService = new LoanService(bookRepository, memberRepository, loanRepository);
        MemberService memberService = new MemberService(memberRepository);

        // Add Authors (Value Object)
        Author author1 = new Author("Author 1", "Portugal");
        Author author2 = new Author("Author 2", "Brazil");

        // Add ISBNs (Entity)
        ISBN isbn1 = ISBNFactory.createISBN("9783161484100");
        ISBN isbn2 = ISBNFactory.createISBN("9783161484101");

        // Add Books (Entity)
        Book book1 = bookService.addBook(isbn1, "Book 1", author1);
        Book book2 = bookService.addBook(isbn2, "Book 2", author2);

        // Add Member IDs (Entity)
        MemberId memberId1 = MemberIdFactory.createMemberId("1");
        MemberId memberId2 = MemberIdFactory.createMemberId("2");

        // Register Members (Entity)
        Member member1 = memberService.registerMember(memberId1, "Member 1", "member1@example.com");
        Member member2 = memberService.registerMember(memberId2, "Member 2", "member2@example.com");

        // Create Loans (Aggregate)
        Loan loan1 = loanService.createLoan(book1.getIsbn(), member1.getId());
        Loan loan2 = loanService.createLoan(book2.getIsbn(), member2.getId());

        // Print Loans (testing purposes)
        System.out.println(loan1);
        System.out.println(loan2);

        // Return Loans (Aggregate)
        loanService.returnLoan(loan1.getId());
        loanService.returnLoan(loan2.getId());

        // Print Loans (testing purposes)
        System.out.println(loan1);
        System.out.println(loan2);
    }
}