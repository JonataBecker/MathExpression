package br.com.jonatabecker.mathexpression.operation;

/**
 *
 * @author Jonata Becker
 */
public class SubtractionOperation implements Operation {

    @Override
    public double calc(double valor1, double valor2) {
        return valor1 - valor2;
    }
    
}
