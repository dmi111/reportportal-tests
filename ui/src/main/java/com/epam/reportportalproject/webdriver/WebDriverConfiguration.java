package com.epam.reportportalproject.webdriver;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;

public class WebDriverConfiguration {

    public void initLocalDriver(String browserName) {
        browser = browserName;
    }

    public WebDriverConfiguration setBaseUrl(String url) {
        baseUrl = url;
        return this;
    }

    public WebDriverConfiguration setStartMaximized(boolean startMaximized) {
        Configuration.startMaximized = startMaximized;
        return this;
    }

    public WebDriverConfiguration setRemote(String remote) {
        Configuration.remote = remote;
        return this;
    }
}
