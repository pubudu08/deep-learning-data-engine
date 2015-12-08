package org.rapter.core;

import org.rapter.core.config.KernelConfiguration;

/**
 * Created by Pubudu Dissanayake on 12/8/15.
 * Project : sentiment-engine
 */
public interface KernelRuntime {
    /**
     *  Returns KernelConfiguration instance. It holds all the static configuration items.
     * @return the Kernel Configuration
     */
    public KernelConfiguration getConfiguration();
}
