package org.rapter.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Pubudu Dissanayake on 12/8/15.
 * Project : sentiment-engine
 */
public class SentimentAnalyzer {
    Properties properties = new Properties();
    InputStream inputStream = null;

    public void init() {
        String fileName = "api_config.properties";
        try {
            inputStream =  SentimentAnalyzer.class.getClassLoader().getResourceAsStream(fileName);
            if(inputStream==null){
                System.out.println("Sorry, unable to find " + fileName);
                return;
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
    }

    public void printProperties(){
        System.out.println(properties.getProperty("TWITTER_OAUTH_ACCESS_TOKEN"));
        System.out.println(properties.getProperty("TWITTER_OAUTH_ACCESS_TOKEN_SECRET"));
        System.out.println(properties.getProperty("TWITTER_OAUTH_CONSUMER_KEY"));
        System.out.println(properties.getProperty("TWITTER_OAUTH_CONSUMER_SECRET"));
    }
    public static void main(String[] args) {
         SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
        sentimentAnalyzer.init();
        sentimentAnalyzer.printProperties();
    }
}
