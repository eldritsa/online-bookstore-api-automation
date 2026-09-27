package tests.books;

import client.BooksApiClient;
import io.restassured.response.Response;
import model.Book;
import spec.ResponseSpecs;
import testdata.BookTestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class UpdateBookApiTests {

    private BooksApiClient booksApiClient;

    @BeforeEach
    void setUp() {
        booksApiClient = new BooksApiClient();
    }

    @Test
     void updateBookSuccessfully() {

        Book updatedBook = BookTestData.createUpdatedBook();

        Response response = booksApiClient.updateBook(updatedBook.getId(), updatedBook);


        response.then()
                .spec(ResponseSpecs.successfulResponse())
                .body("id" , equalTo(updatedBook.getId()))
                .body("title" , equalTo(updatedBook.getTitle()))
                .body("description" , equalTo(updatedBook.getDescription()))
                .body("pageCount" , equalTo(updatedBook.getPageCount()))
                .body("excerpt" , equalTo(updatedBook.getExcerpt()))
                .body("publishDate" , equalTo(updatedBook.getPublishDate()));

    }

    @Test
    void updateNonExistingBook_returns200() {

        Book nonExistingBook = BookTestData.createUpdatedBook();

        nonExistingBook.setId(999999);
        nonExistingBook.setDescription("Update Non Existing Book");

        Response response = booksApiClient.updateBook(nonExistingBook.getId(),nonExistingBook);

        response.then()
                .spec(ResponseSpecs.successfulResponse())
                .body("id", equalTo(nonExistingBook.getId()))
                .body("description" , equalTo(nonExistingBook.getDescription()));

    }
}