package com.epam.reportportalproject.config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import lombok.Getter;

@Getter
public class GlobalConfig {
    private static final String PROPERTIES_PATH = "src/main/resources/configuration.properties";
    private final Properties properties;
    private final File propertyFile;
    private final String browserType;
    private final String browserName;
    private final String baseUrl;

    public GlobalConfig() throws IOException {
        propertyFile = new File(PROPERTIES_PATH);
        properties = new Properties();
        properties.load(new FileReader(propertyFile));
        browserType = properties.getProperty("browser.type");
        browserName = properties.getProperty("browser.name");
        baseUrl = properties.getProperty("base.url");
    }

    public static GlobalConfig getGlobalConfig() throws IOException {
        return new GlobalConfig();
    }
}
