package com.codecool.fusy_qs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//@Component
public class PSQLconnection {

    @Value("${db.URL}")
    private String URL;
    @Value("${db.USER}")
    private String USER;
    @Value("${db.PASSWORD}")
    private String PASSWORD;

    public PSQLconnection() {
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
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

//    private Properties readPropertiesFile(String fileName) {
//        FileInputStream fis = null;
//        Properties prop = null;
//        try {
//            fis = new FileInputStream(fileName);
//            prop = new Properties();
//            prop.load(fis);
//        } catch (FileNotFoundException fnfe) {
//            fnfe.printStackTrace();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        } finally {
//            try {
//                fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return prop;
//    }
}
