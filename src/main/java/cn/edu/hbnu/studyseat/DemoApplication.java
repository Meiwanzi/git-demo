package cn.edu.hbnu.studyseat;

import cn.edu.hbnu.studyseat.config.AppConfig;

import java.io.InputStream;
import java.util.Objects;

/**
 * Minimal application entry point.
 */
public final class DemoApplication {

    private DemoApplication() {
    }

    public static void main(String[] args) throws Exception {
        try (InputStream input = DemoApplication.class.getResourceAsStream(
                "/application.properties")) {
            if (input == null) {
                throw new IllegalStateException(
                        "application.properties was not found on the classpath"
                );
            }

            AppConfig config = AppConfig.load(input);
            System.out.println(startupMessage(config));
        }
    }

    static String startupMessage(AppConfig config) {
        Objects.requireNonNull(config, "config");
        return "Demo application started: " + config.applicationName();
    }
}
