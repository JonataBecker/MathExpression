package br.com.jonatabecker.mathexpression;

/**
 * Exception thrown with an invalid expression was informed 
 * 
 * @author Jonata Becker
 */
public class InvalidExpressionException extends Exception {

    public InvalidExpressionException(String message) {
        super(message);
    }
     
}
