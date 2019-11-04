package com.cdhenren.fetch.tools.poi;

/**
 * @author Baopz
 * @date 2018/05/03
 */
public class NotSupportedFileType extends Exception {
    public NotSupportedFileType() {
    }

    public NotSupportedFileType(String message) {
        super(message);
    }

    public NotSupportedFileType(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSupportedFileType(Throwable cause) {
        super(cause);
    }
}
