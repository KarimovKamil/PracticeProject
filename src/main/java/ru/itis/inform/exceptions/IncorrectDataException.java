package ru.itis.inform.exceptions;

/**
 * Created by artur on 12.07.2017.
 */
public class IncorrectDataException extends RuntimeException {
    public IncorrectDataException(String string){
        super(string);
    }
}
