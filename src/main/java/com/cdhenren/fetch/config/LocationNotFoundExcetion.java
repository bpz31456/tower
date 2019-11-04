package com.cdhenren.fetch.config;

/**
 * 地区没有被发现
 */
public class LocationNotFoundExcetion extends Exception {
    public LocationNotFoundExcetion() {
        super();
    }

    public LocationNotFoundExcetion(String message) {
        super(message);
    }

    public LocationNotFoundExcetion(String message, Throwable cause) {
        super(message, cause);
    }

    public LocationNotFoundExcetion(Throwable cause) {
        super(cause);
    }

    protected LocationNotFoundExcetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
