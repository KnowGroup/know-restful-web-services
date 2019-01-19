package org.know.rest.webservices.knowrestfulwebservices.exception;

import java.time.LocalDate;

/**
 *
 * @author KnowGroup
 */
class ExceptionResponse {

    private final LocalDate now;
    private final String message;
    private final String description;

    ExceptionResponse(LocalDate now, String message, String description) {
        this.now = now;
        this.message = message;
        this.description = description;
    }

    public LocalDate getNow() {
        return now;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

}
