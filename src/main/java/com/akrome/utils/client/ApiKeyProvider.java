package com.akrome.utils.client;

import org.glassfish.hk2.api.Factory;

import java.io.InputStream;
import java.util.Properties;

public class ApiKeyProvider {
    public final static String API_KEY_NAME = "api-key";
    public final static String CONFIG_FILE_NAME = "config.properties";

    public String provide() {
        Properties prop = new Properties();
        String propFileName = CONFIG_FILE_NAME;
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {
            prop.load(inputStream);
            return prop.getProperty(API_KEY_NAME);
        }
        catch(Exception e) {
            throw new NullPointerException("The config file is missing");
        }
    }
}
