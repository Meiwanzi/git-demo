package cn.edu.hbnu.studyseat;

import cn.edu.hbnu.studyseat.config.AppConfig;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoApplicationTest {

    @Test
    void buildsStartupMessageFromApplicationName() throws Exception {
        String properties = "app.name=demo-skeleton";

        try (InputStream input = new ByteArrayInputStream(
                properties.getBytes(StandardCharsets.UTF_8))) {
            AppConfig config = AppConfig.load(input);

            assertEquals(
                    "Demo application started: demo-skeleton",
                    DemoApplication.startupMessage(config)
            );
        }
    }
}
