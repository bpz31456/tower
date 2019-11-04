package com.cdhenren.fetch.exception;

/**
 * @author baopz
 * @since 1.1.0
 * 登录失败异常，登录失败后，直接设置当前任务失效
 */
public class LoginException extends Exception{
    public LoginException() {
        super();
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException(Throwable cause) {
        super(cause);
    }

    protected LoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
