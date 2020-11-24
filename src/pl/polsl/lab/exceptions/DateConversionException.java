package pl.polsl.lab.exceptions;

import java.text.ParseException;

/**
 * The type Date conversion exception.
 */
public class DateConversionException extends ParseException {
    /**
     * Instantiates a new Date conversion exception.
     *
     * @param errorMessage the error message
     * @param errorOffset  the error offset
     */
    public DateConversionException(String errorMessage, int errorOffset){
        super(errorMessage, errorOffset);
    }
}
