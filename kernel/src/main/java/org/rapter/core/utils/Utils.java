package org.rapter.core.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Pubudu Dissanayake on 12/8/15.
 * Project : sentiment-engine
 */
public class Utils {
    private static Properties properties = new Properties();
    private static InputStream inputStream = null;
    private static List<String> propertyList = new ArrayList<String>();

    public static Properties initProperties() {
        // separate all the resource files and load individually
        propertyList.add("api_config.properties");
        propertyList.add("edu/stanford/nlp/pipeline/StanfordCoreNLP.properties");
        try {
            for (String fileName : propertyList) {
                inputStream = Utils.class.getClassLoader().getResourceAsStream(fileName);
                if (inputStream == null) {
                    System.out.println("Sorry, unable to find " + fileName);
                    return null;
                }
                properties.load(inputStream);
            }
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
