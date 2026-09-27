package client;

import config.Config;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

/**
 * Base client that provides common configuration for API requests.
 * Defines the base URL, content type, accepted response type, and request logging.
 */

public class BaseApiClient {

    protected RequestSpecification request() {

        return given()
                .baseUri(Config.BASE_URL)
                .contentType("application/json")
                .accept("application/json")
                .log().ifValidationFails();
    }
}