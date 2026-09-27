package client;

import io.restassured.response.Response;
import model.Book;

/**
 * Client for interacting with the Books API endpoints.
 * Provides methods for retrieving, creating, updating, and deleting books.
 */

public class BooksApiClient extends BaseApiClient {

    private static final String BOOKS_ENDPOINT = "/api/v1/Books";

    public Response getAllBooks() {
         return request()
                 .when()
                 .get(BOOKS_ENDPOINT);

    }

    public Response getBookById(int id) {
        return request()
                .pathParam("id", id)
                .when()
                .get(BOOKS_ENDPOINT + "/{id}");
    }

    public Response createBook(Book book) {
        return request()
                .body(book)
                .when()
                .post(BOOKS_ENDPOINT);
    }

    public Response updateBook(int id , Book book) {
        return request()
                .pathParam("id" , id)
                .body(book)
                .when()
                .put(BOOKS_ENDPOINT + "/{id}");
    }

    public Response deleteBook(int id) {
        return request()
                .pathParam("id", id)
                .when()
                .delete(BOOKS_ENDPOINT + "/{id}");
    }
}