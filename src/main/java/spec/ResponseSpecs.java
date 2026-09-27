package spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

/**
 * Provides reusable response specifications for API tests.
 * Defines common checks such as HTTP status codes and content types.
 */

public class ResponseSpecs {

    public static ResponseSpecification successfulResponse() {

        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .build();
    }

    public static ResponseSpecification notFoundResponse() {

        return new ResponseSpecBuilder()
                .expectStatusCode(404)
                .build();
    }

    private ResponseSpecs() {
    }
}