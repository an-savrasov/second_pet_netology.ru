package org.example;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Token {
    private String token;

    public Token() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            token = property.getProperty("token");

        } catch (IOException e) {
            System.err.println("Error: Файл свойств отсуствует!");
        }
    }

    public String getToken() {return token;}
}