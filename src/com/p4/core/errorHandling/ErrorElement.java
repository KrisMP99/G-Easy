package com.p4.core.errorHandling;

public class ErrorElement {
    ErrorType errorType;
    String message;
    int lineNumber;

    public ErrorElement(ErrorType errorType, String message, int lineNumber) {
        this.errorType = errorType;
        this.message = message;
        this.lineNumber = lineNumber;
    }
}
