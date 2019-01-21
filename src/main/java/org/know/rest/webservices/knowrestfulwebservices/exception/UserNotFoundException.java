package org.know.rest.webservices.knowrestfulwebservices.exception;

/**
 *
 * @author KnowGroup
 */
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }
}
