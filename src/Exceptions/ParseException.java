package Exceptions;

import share.JSON;

public class ParseException extends Exception{
    public ParseException(String message){
        super(message);
    }
    @Override
    public String getMessage(){
        return JSON.genStandardJSON("error", super.getMessage(), String.valueOf(0));
    }
}
