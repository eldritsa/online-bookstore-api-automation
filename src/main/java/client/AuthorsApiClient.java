package client;

import io.restassured.response.Response;
import model.Author;
import model.Book;


/**
 * Client for interacting with the Authors API endpoints.
 * Provides methods for retrieving and creating authors.
 */

public class AuthorsApiClient extends BaseApiClient {

    private static final String AUTHORS_ENDPOINT = "/api/v1/Authors";

    public Response getAllAuthors() {
        return request()
                .when()
                .get(AUTHORS_ENDPOINT);
    }

    public Response getAuthorById(int id) {
        return request()
                .pathParam("id", id)
                .when()
                .get(AUTHORS_ENDPOINT + "/{id}");
    }

    public Response createAuthor(Author author) {
        return request()
                .body(author)
                .when()
                .post(AUTHORS_ENDPOINT);
    }

    public Response updateAuthor(int id , Book book) {
        return request()
                .pathParam("id" , id)
                .body(book)
                .when()
                .put(AUTHORS_ENDPOINT + "/{id}");
    }

    public Response deleteAuthor(int id) {
        return request()
                .pathParam("id", id)
                .when()
                .delete(AUTHORS_ENDPOINT + "/{id}");
    }

    public Response getAuthorsByBookId(int bookId) {
        return request()
                .pathParam("idBook", bookId)
                .when()
                .get(AUTHORS_ENDPOINT + "/authors/books/{idBook}");
    }
}