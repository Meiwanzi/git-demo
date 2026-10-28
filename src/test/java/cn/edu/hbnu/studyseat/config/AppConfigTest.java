package cn.edu.hbnu.studyseat.config;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AppConfigTest {

    @Test
    void loadsApplicationNameFromProperties() throws Exception {
        String properties = "app.name=demo-skeleton";

        try (InputStream input = new ByteArrayInputStream(
                properties.getBytes(StandardCharsets.UTF_8))) {
            AppConfig config = AppConfig.load(input);

            assertEquals("demo-skeleton", config.applicationName());
        }
    }

    @Test
    void rejectsBlankApplicationName() {
        String properties = "app.name=   ";

        try (InputStream input = new ByteArrayInputStream(
                properties.getBytes(StandardCharsets.UTF_8))) {
            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> AppConfig.load(input)
            );

            assertEquals("app.name must not be blank", exception.getMessage());
        } catch (Exception exception) {
            throw new AssertionError("InputStream setup failed", exception);
        }
    }
}
