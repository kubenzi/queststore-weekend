package com.codecool.fusy_qs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PSQLconnection {

    private final String URL;
    private final String USER;
    private final String PASSWORD;

    public PSQLconnection() {
        String properties_file = "database.properties";
        Properties props = readPropertiesFile("./src/main/resources/" + properties_file);
        this.URL = props.getProperty("db.URL");
        this.USER = props.getProperty("db.USER");
        this.PASSWORD = props.getProperty("db.PASSWORD");
    }

    public String getUrl() {
        return URL;
    }

    public String getUsername() {
        return USER;
    }

    public String getPassword() {
        return PASSWORD;
    }

    private Properties readPropertiesFile(String fileName) {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop;
    }
}
