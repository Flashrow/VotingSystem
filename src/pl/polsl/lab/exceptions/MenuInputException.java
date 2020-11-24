package pl.polsl.lab.exceptions;

/**
 * The type Menu input exception.
 *
 * @author Lukasz Goleniec
 * @version 1.0
 */
public class MenuInputException extends Exception {
    /**
     * Instantiates a new Menu input exception.
     *
     * @param errorMessage the error message
     */
    public MenuInputException(String errorMessage){
        super(errorMessage);
    }
}
