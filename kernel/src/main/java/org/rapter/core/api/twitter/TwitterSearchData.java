package org.rapter.core.api.twitter;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * Created by Pubudu Dissanayake on 12/8/15.
 * Project : sentiment-engine
 */
public class TwitterSearchData {

    private Properties properties = null;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public TwitterSearchData( Properties properties) {
        this.properties = properties;
    }

    public List<Status> searchTweetsByKeyword(String keyword){
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true).setOAuthConsumerKey(properties.getProperty("TWITTER_OAUTH_CONSUMER_KEY")).
                setOAuthConsumerSecret(properties.getProperty("TWITTER_OAUTH_CONSUMER_SECRET")).
                        setOAuthAccessToken(properties.getProperty("TWITTER_OAUTH_ACCESS_TOKEN")).
                        setOAuthAccessTokenSecret(properties.getProperty("TWITTER_OAUTH_ACCESS_TOKEN_SECRET"));
        TwitterFactory twitterFactory = new TwitterFactory(configurationBuilder.build());
        Twitter twitter = twitterFactory.getInstance();
        Query query = new Query(keyword + " -filter:retweets -filter:links -filter:replies -filter:images");
        query.setCount(20);
        query.setLocale("en");
        query.setLang("en");
        try {
            QueryResult queryResult = twitter.search(query);
            return queryResult.getTweets();
        }catch (TwitterException e){
            //Logger
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}
