package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private String URL;
    public Configuration() {
            try (InputStream fis = Configuration.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties property = new Properties();
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
