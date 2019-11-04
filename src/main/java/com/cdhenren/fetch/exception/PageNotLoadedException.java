package com.cdhenren.fetch.exception;

/**
 * 页面没有正确加载
 * 主要在页面在等待一定时长后，页面依然未显示出来
 * @author baopz
 * @since 1.1.0
 */
public class PageNotLoadedException extends Exception {
    public PageNotLoadedException() {
        super();
    }

    public PageNotLoadedException(String message) {
        super(message);
    }

    public PageNotLoadedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PageNotLoadedException(Throwable cause) {
        super(cause);
    }

    protected PageNotLoadedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
