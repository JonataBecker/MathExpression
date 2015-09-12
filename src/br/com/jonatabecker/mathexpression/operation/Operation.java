package br.com.jonatabecker.mathexpression.operation;

/**
 * Class responsible for operations
 * 
 * @author Jonata Becker
 */
public interface Operation {

    /**
     * Performs the calculation
     * 
     * @param valor1
     * @param valor2
     * @return double
     */
    public double calc(double valor1, double valor2);
}
