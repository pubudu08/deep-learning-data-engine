package org.rapter.core;

/**
 * Created by Pubudu Dissanayake on 12/8/15.
 * Project : sentiment-engine
 */
public class ResultUnit {
    private String sentiment;
    private String sentimentLevel;

    public ResultUnit(String sentiment, String sentimentLevel) {
        this.sentiment = sentiment;
        this.sentimentLevel = sentimentLevel;
    }

    public String getSentiment() {
        return sentiment;
    }

    public String getSentimentLevel() {
        return sentimentLevel;
    }

    @Override
    public String toString() {
        return "ResultObject [sentiment= " + getSentiment() + ", sentimentLevel= " + getSentimentLevel() + "]";
    }
}
