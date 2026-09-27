package config;

/**
 * Provides configuration values used by the API automation framework.
 */

public class Config {

    public static final String BASE_URL =
            System.getProperty(
                    "baseUrl",
                    "https://fakerestapi.azurewebsites.net"
            );

    private Config() {
    }
}