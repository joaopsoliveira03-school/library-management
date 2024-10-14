package Factory;

import Entity.ISBN;

public class ISBNFactory {

    public static ISBN createISBN(String isbn) {
        return new ISBN(isbn);
    }
}