package cn.edu.hbnu.studyseat.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * Minimal application configuration loaded from a properties stream.
 */
public final class AppConfig {

    private static final String APPLICATION_NAME_KEY = "app.name";

    private final String applicationName;

    private AppConfig(String applicationName) {
        this.applicationName = applicationName;
    }

    public String applicationName() {
        return applicationName;
    }

    public static AppConfig load(InputStream input) throws IOException {
        Objects.requireNonNull(input, "input");

        Properties properties = new Properties();
        properties.load(input);

        String applicationName = properties.getProperty(APPLICATION_NAME_KEY);
        if (applicationName == null || applicationName.isBlank()) {
            throw new IllegalArgumentException(
                    APPLICATION_NAME_KEY + " must not be blank"
            );
        }

        return new AppConfig(applicationName.trim());
    }
}
