package org.rapter.core;

/**
 * Created by Pubudu Dissanayake on 12/8/15.
 * Project : sentiment-engine
 */
public final class Constants {
    public static final String KERNEL_DIR = "kernel.directory";

    /**
     * Remove default constructor and make it not available to initialize.
     */
    private Constants() {
        throw new AssertionError("Trying to a instantiate a constant class");
    }
}
