package org.rapter.core.api.twitter;

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
}
