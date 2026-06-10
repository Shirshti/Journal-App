package com.shrii.journalApp.Exception;

public class JournalNotFoundException extends RuntimeException {
    public JournalNotFoundException(String message){
        super(message);
    }
}
