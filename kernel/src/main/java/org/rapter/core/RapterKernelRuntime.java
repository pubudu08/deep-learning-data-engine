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
        List<Status> relatedTweets =  twitterSearchData.searchTweetsByKeyword("Manchester United");

        for (Status status : relatedTweets){
            System.out.println(status.getText());
            System.out.println("@"+status.getUser().getScreenName());
            System.out.println(status.getCreatedAt());
            System.out.println("");
        }


    }
}
