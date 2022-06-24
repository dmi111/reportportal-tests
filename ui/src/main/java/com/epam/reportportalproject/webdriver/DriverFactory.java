package com.epam.reportportalproject.webdriver;

import static com.codeborne.selenide.Selenide.open;
import com.epam.reportportalproject.config.GlobalConfig;
import java.io.IOException;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DriverFactory {
    public static void configure(String baseUrl) throws IOException {
        WebDriverConfiguration configuration = new WebDriverConfiguration();
                configureLocalDriver(configuration);
        configuration
                .setStartMaximized(true)
                .setBaseUrl(baseUrl);
        open(baseUrl);
    }

    private static void configureLocalDriver(WebDriverConfiguration configuration) throws IOException {
        String browserName = GlobalConfig.getGlobalConfig().getBrowserName();
        log.info("Configuring local WebDriver: {}", browserName);
        configuration.initLocalDriver(browserName);
    }
}
