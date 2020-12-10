package org.itstep.exceptions;

public class DivideByZeroException extends Exception {
    //private String message;

    public DivideByZeroException(String message) {
        super(message);
        //this.message = message;
    }
}
