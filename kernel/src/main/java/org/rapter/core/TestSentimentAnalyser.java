package org.rapter.core;

/**
 * Created by Pubudu Dissanayake on 12/8/15.
 * Project : sentiment-engine
 */
public class TestSentimentAnalyser {
    public static void main(String[] args) {
        SentimentAnalyzerEngine sentimentAnalyzer = new SentimentAnalyzerEngine();
        sentimentAnalyzer.init();
        String x = "I am a vegetarian who hates potatoes and I LOVE coco's paneer burger. Delicious :) loved every bit of it. I suggest everyone should try that coupled with Coco Mocha with cream";
        ResultUnit resultUnit = sentimentAnalyzer.processSentiment("Coco Mocha and/or Coco Caramel. Can never go wrong with these chocolate blends.");
        System.out.println(resultUnit.toString());

/*        for (String retval: Str.split("-")){
            System.out.println(retval);
        }*/
    }
}
