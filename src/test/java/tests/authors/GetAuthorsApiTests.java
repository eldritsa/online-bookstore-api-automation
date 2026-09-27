package tests.authors;

import client.AuthorsApiClient;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spec.ResponseSpecs;

import static org.hamcrest.Matchers.*;


public class GetAuthorsApiTests {

    private AuthorsApiClient authorsApiClient;

    @BeforeEach
    void setUp() {
        authorsApiClient = new AuthorsApiClient();
    }

    @Test
    void getAllAuthorsSuccessfully() {

        Response response = authorsApiClient.getAllAuthors();

        response.then()
                .spec(ResponseSpecs.successfulResponse())
                .body("$" ,not(empty()))
                .body("[0].id" , greaterThan(0))
                .body("[0].idBook" , greaterThan(0))
                .body("[0].firstName" , notNullValue())
                .body("[0].lastName" , notNullValue());

    }

    @Test
    void getAuthorByIdSuccessfully() {

        int authorId = 1;

        Response response = authorsApiClient.getAuthorById(authorId);

        response.then()
                .spec(ResponseSpecs.successfulResponse())
                .body("id" , equalTo(authorId))
                .body("idBook" , greaterThan(0));

    }

    @Test
    void getAuthorsByBookIdSuccessfully() {

        int bookId = 1;

        Response response = authorsApiClient.getAuthorsByBookId(bookId);
        response.then()
                .spec(ResponseSpecs.successfulResponse())
                .body("$", not(empty()))
                .body("id", everyItem(greaterThan(0)))
                .body("idBook", everyItem(equalTo(bookId)))
                .body("firstName", everyItem(notNullValue()))
                .body("lastName", everyItem(notNullValue()));
    }
}