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
        RapterKernelRuntime rapterKernelRuntime = new RapterKernelRuntime();
        KernelConfiguration kernelConfiguration = rapterKernelRuntime.getConfiguration();
        Properties properties = kernelConfiguration.getProperties();
        TwitterSearchData twitterSearchData = new TwitterSearchData(properties);
        List<Status> relatedTweets =  twitterSearchData.searchTweetsByKeyword("SriLanka");
        SentimentAnalyzerEngine sentimentAnalyzer = new SentimentAnalyzerEngine();
        sentimentAnalyzer.init();

        for (Status status : relatedTweets){
            ResultUnit resultUnit = sentimentAnalyzer.processSentiment(status.getText(), properties);
            System.out.println(resultUnit.toString());
        }
    }
}
