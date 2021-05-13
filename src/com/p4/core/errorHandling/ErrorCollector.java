package com.p4.core.errorHandling;

import java.util.ArrayList;
import java.util.List;

public class ErrorCollector {
    private List<ErrorElement> errorList = new ArrayList<>();

    public void addErrorEntry(ErrorType errorType, String message, int lineNumber) {
        ErrorElement error = new ErrorElement(errorType, message, lineNumber);
        errorList.add(error);
    }

    public boolean hasErrors() {
        if(errorList.size() > 0) {
            return true;
        }

        return false;
    }

    public void displayErrors() {
        if(hasErrors()) {
            printErrors();
        } else {
            System.out.println("No errors detected.");
        }
    }

    private void printErrors() {
        // Go through all the errors
        for(ErrorElement error : errorList) {
            System.out.println(error.errorType + ": " + error.message + " on line: " + error.lineNumber);
        }
    }


}
