package com.epam.reportportalproject;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.reportportal.junit5.ReportPortalExtension;
import com.epam.reportportalproject.config.GlobalConfig;
import com.epam.reportportalproject.reporter.ReportPortalLogger;
import com.epam.reportportalproject.webdriver.DriverFactory;
import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(ReportPortalExtension.class)
public class BaseTest {

    @BeforeEach()
    public void setUp() throws IOException {
        DriverFactory.configure(GlobalConfig.getGlobalConfig().getBaseUrl());
    }

    @AfterEach()
    public void tearDown() {
        //Not used temporary
        //ReportPortalLogger.logFailedTest();
        WebDriverRunner.getWebDriver().quit();
    }
}
