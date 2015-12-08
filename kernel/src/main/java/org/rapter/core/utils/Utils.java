package org.rapter.core.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Pubudu Dissanayake on 12/8/15.
 * Project : sentiment-engine
 */
public class Utils {
    private Properties properties = new Properties();
    private InputStream inputStream = null;

    public Properties init() {
        // separate all the resource files and load individually
        String fileName = "api_config.properties";
        try {
            inputStream =  Utils.class.getClassLoader().getResourceAsStream(fileName);
            if(inputStream==null){
                System.out.println("Sorry, unable to find " + fileName);
                return null;
            }
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }
}
