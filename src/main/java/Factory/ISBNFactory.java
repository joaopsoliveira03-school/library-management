package Factory;

import Entity.ISBN;

public class ISBNFactory {
    private static int isbnCounter = 0;

    public static ISBN createISBN() {
        return new ISBN(String.valueOf(isbnCounter++));
    }
}