package org.rapter.core;

/**
 * Created by Pubudu Dissanayake on 1/22/16.
 * Project : sentiment-engine
 */
public class VaderResultUnit {
    private String positive;
    private String negative;
    private String sentence;
    private String neutral;
    private String compound;

    public String getPositive() {
        return positive;
    }

    public void setPositive(String positive) {
        this.positive = positive;
    }

    public String getNegative() {
        return negative;
    }

    public void setNegative(String negative) {
        this.negative = negative;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getNeutral() {
        return neutral;
    }

    public void setNeutral(String neutral) {
        this.neutral = neutral;
    }

    public String getCompound() {
        return compound;
    }

    public void setCompound(String compound) {
        this.compound = compound;
    }
}
