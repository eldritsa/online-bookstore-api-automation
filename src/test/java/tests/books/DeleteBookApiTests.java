package tests.books;

import client.BooksApiClient;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class DeleteBookApiTests {

    private BooksApiClient booksApiClient;

    @BeforeEach
    void setUp() {
        booksApiClient = new BooksApiClient();
    }

    @Test
     void deleteBookSuccessfully() {

        int bookId = 101;
        Response response = booksApiClient.deleteBook(bookId);

        response.then()
                .statusCode(200);
    }

    @Test
    void deleteInvalidBookId_returns200() {

        int invalidBookId = -10 ;
        Response response = booksApiClient.deleteBook(invalidBookId);

        response.then()
                .statusCode(200);

    }

    @Test
    void deleteNonExistingBook_returns200() {

        int noExistingBookId = 999999;

        Response response = booksApiClient.deleteBook(noExistingBookId);

        response.then()
                .statusCode(200);
    }
}