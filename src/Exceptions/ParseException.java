package Exceptions;

import share.JSON;

public class ParseException extends Exception{
    public ParseException(String message){
        super(message);
    }


    public String getMessageJson(){
        return JSON.genStandardJSON("error", super.getMessage(), String.valueOf(0));
    }
}
