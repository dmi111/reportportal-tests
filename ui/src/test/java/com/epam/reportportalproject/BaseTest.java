package com.epam.reportportalproject;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import com.epam.reportportalproject.config.GlobalConfig;
import com.epam.reportportalproject.reporter.ReportPortalLogger;
import com.epam.reportportalproject.webdriver.DriverFactory;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({ReportPortalTestNGListener.class})
public class BaseTest {

    @BeforeMethod()
    public void setUp() throws IOException {
        DriverFactory.configure(GlobalConfig.getGlobalConfig().getBaseUrl());
    }

    @AfterMethod()
    public void tearDown() {
        //Not used temporary
        //ReportPortalLogger.logFailedTest();
    }
}
