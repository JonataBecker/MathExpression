package br.com.jonatabecker.mathexpression.operation;

/**
 * Class responsible for sum operations
 * 
 * @author Jonata Becker
 */
public class SumOperation implements Operation {

    /**
     * Performs the calculation
     *
     * @param valor1
     * @param valor2
     * @return double
     */
    @Override
    public double calc(double  valor1, double  valor2) {
        return valor1 + valor2;
    }
    
}
