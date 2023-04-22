package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private String URL;

    public Configuration() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            URL = property.getProperty("URL");

        } catch (IOException e) {
            System.err.println("Error: Файл свойств отсуствует!");
        }

    }

    public String getUrl() {
        return URL;
    }
}