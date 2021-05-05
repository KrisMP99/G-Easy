package com.p4.core.errorHandling;

import java.util.ArrayList;
import java.util.List;

public class ErrorCollector {
    private List<ErrorElement> errorList = new ArrayList<>();

    public void addErrorEntry(ErrorType errorType, String message, int lineNumber) {
        ErrorElement error = new ErrorElement(errorType, message, lineNumber);
        errorList.add(error);
    }


    public void printErrors() {
        // Go through all the errors
        for(ErrorElement error : errorList) {
            System.out.println(error.errorType + ": " + error.message + " on line: " + error.lineNumber);
        }
    }


}
