package org.rapter.core;

import org.rapter.core.api.twitter.TwitterSearchData;
import org.rapter.core.config.KernelConfiguration;
import twitter4j.Status;

import java.util.List;
import java.util.Properties;

/**
 * Created by Pubudu Dissanayake on 12/8/15.
 * Project : sentiment-engine
 */
public class RapterKernelRuntime implements KernelRuntime {


    public KernelConfiguration getConfiguration() {
        return new KernelConfiguration();
    }

    public static void main(String[] args) {
        String twitterHandler = "loNE_wOLf_90";
        RapterKernelRuntime rapterKernelRuntime = new RapterKernelRuntime();
        KernelConfiguration kernelConfiguration = rapterKernelRuntime.getConfiguration();
        Properties properties = kernelConfiguration.getProperties();
        TwitterSearchData twitterSearchData = new TwitterSearchData(properties);
        List<Status> relatedTweets =  twitterSearchData.searchTweetsByKeyword("SriLanka");
        List<Status> userTimeline =  twitterSearchData.fetchMentions(twitterHandler, 709);

        SentimentAnalyzerEngine sentimentAnalyzer = new SentimentAnalyzerEngine();
        sentimentAnalyzer.init(properties);

/*        for (Status status : relatedTweets){
            ResultUnit resultUnit = sentimentAnalyzer.processSentiment(status.getText(), properties);
            //System.out.println(resultUnit.toString());
        }

        System.out.println("\nTotal "+ relatedTweets.size()+" sentiments were analysed\n" +
                "There were "+sentimentAnalyzer.getPositiveSentimentsCount() +" Positive Sentiments\n, " +
                 sentimentAnalyzer.getNeutralSentimentsCount() +" Neutral Sentiments\n, And  " +
                +sentimentAnalyzer.getNegativeSentimentsCount() +" Negative Sentiments");

        sentimentAnalyzer.cleanData();
        */
//        for (Status status : userTimeline){
//            ResultUnit resultUnit = sentimentAnalyzer.processSentiment(status.getText());
//            //System.out.println(resultUnit.toString());
//        }
//        System.out.println("@"+twitterHandler+"'s twitter analysis!");
//        System.out.println("\nTotal "+ userTimeline.size()+" sentiments were analysed\n" +
//                "There were "+sentimentAnalyzer.getPositiveSentimentsCount() +" Positive Sentiments\n, " +
//                sentimentAnalyzer.getNeutralSentimentsCount() +" Neutral Sentiments\n, And  " +
//                +sentimentAnalyzer.getNegativeSentimentsCount() +" Negative Sentiments");
        ResultUnit resultUnit = sentimentAnalyzer.processSentiment("XYZ is hardly interesting");
        System.out.println(resultUnit.toString());
    }
}
