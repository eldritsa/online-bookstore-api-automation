package tests.books;

import client.BooksApiClient;
import io.restassured.response.Response;
import model.Book;
import testdata.BookTestData;
import spec.ResponseSpecs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;


public class CreateBookApiTests {

    private BooksApiClient booksApiClient;

    @BeforeEach
    void setUp() {
        booksApiClient = new BooksApiClient();
    }

  @Test
    void createBookSuccessfully() {
      Book book = BookTestData.createValidBook();

       Response response = booksApiClient.createBook(book);

       response.then()
               .spec(ResponseSpecs.successfulResponse())
               .body("id" , equalTo(book.getId()))
               .body("title" , equalTo(book.getTitle()))
               .body("description" , equalTo(book.getDescription()))
               .body("pageCount" , equalTo(book.getPageCount()))
               .body("excerpt" , equalTo(book.getExcerpt()))
               .body("publishDate" , equalTo(book.getPublishDate()));

  }

  @Test
    void createBookWithInvalidData_returns200() {
        Book book = BookTestData.createValidBook();
        book.setId(-1);
        book.setPageCount(-10);

        Response response = booksApiClient.createBook(book);

        response.then()
                .spec(ResponseSpecs.successfulResponse())
                .body("id" , equalTo(-1))
                .body("pageCount" , equalTo(-10));

  }

}