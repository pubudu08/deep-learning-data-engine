package org.rapter.core.config;

import org.rapter.core.utils.Utils;

import java.util.Properties;

/**
 * Created by Pubudu Dissanayake on 12/8/15.
 * Project : sentiment-engine
 */
public class KernelConfiguration {
    private String id = "sentiment-kernel";
    private String name = "Rapter-Extractor";
    private String version = "1.0.0";
    private Properties properties = null;
    private Utils utils = new Utils();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public Properties getProperties() {
        this.properties = utils.init();
        return properties;
    }
}
