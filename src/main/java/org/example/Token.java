package org.example;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Token {
    private String token;

    public Token() {
        try (InputStream fis = Token.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties property = new Properties();
            property.load(fis);
            token = property.getProperty("token");

        } catch (IOException e) {
            System.err.println("Error: Файл свойств отсуствует!");
        }
    }

        public String getToken() {return token;}
}