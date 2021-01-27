package exceptions;

import enums.Browser;

public class InvalidBrowserException extends RuntimeException {

    public InvalidBrowserException(Browser browser) {
        super("Unrecognized Browser used: " + browser);
    }
}
