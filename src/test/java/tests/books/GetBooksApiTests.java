package tests.books;

import client.BooksApiClient;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spec.ResponseSpecs;

import static org.hamcrest.Matchers.*;


public class GetBooksApiTests {

    private BooksApiClient booksApiClient;

    @BeforeEach
    void setUp() {
        booksApiClient = new BooksApiClient();
    }

  @Test
    void getAllBooksSuccessfully() {

       Response response = booksApiClient.getAllBooks();

     response.then()
             .spec(ResponseSpecs.successfulResponse())
             .body("$",not(empty()))
             .body("[0].id", greaterThan(0))
             .body("[0].title",notNullValue())
             .body("[0].pageCount", greaterThan(0));
  }


    @Test
    void getBookByIdSuccessfully() {

        int bookId =1;

        Response response = booksApiClient.getBookById(bookId);

        response.then()
                .spec(ResponseSpecs.successfulResponse())
                .body("id", equalTo(bookId))
                .body("title", notNullValue())
                .body("pageCount", greaterThan(0));
    }

    @Test
    void getNonExistingBook_returns404() {

        int notExistingBookId = 9999999;

        Response response = booksApiClient.getBookById(notExistingBookId);

        response.then()
                .spec(ResponseSpecs.notFoundResponse());

    }

    @Test
    void getBookWithInvalidId_returns404() {

        int invalidBookId = -1;

        Response response = booksApiClient.getBookById(invalidBookId);

        response.then()
                .spec(ResponseSpecs.notFoundResponse());
    }
}