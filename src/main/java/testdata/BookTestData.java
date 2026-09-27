package testdata;

import model.Book;

/**
 * Provides reusable test data for Book API tests.
 */
public class BookTestData {

    public static Book createValidBook() {

        return new Book(
                1001 ,
                "API Automation Book" ,
                "My First Book" ,
                200 ,
                "My exercise" ,
                "2026-09-26T00:00:00Z");
    }

    public static Book createUpdatedBook() {

        return new Book(
                1 ,
                "Updated API Automation Book" ,
                "Updated Book" ,
                300 ,
                "Updated excerpt" ,
                "2026-09-30T00:00:00Z"
        );
    }

    private BookTestData() {
    }
}