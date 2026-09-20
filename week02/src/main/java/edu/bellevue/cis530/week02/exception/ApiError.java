package edu.bellevue.cis530.week02.exception;

import java.time.LocalDateTime;

public class ApiError {

    private final String message;
    private final int status;
    private final LocalDateTime timestamp;

    public ApiError(String message, int status, LocalDateTime timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
