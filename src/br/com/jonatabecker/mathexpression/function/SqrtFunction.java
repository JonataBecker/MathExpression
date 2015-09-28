package br.com.jonatabecker.mathexpression.function;

/**
 * Classe responsible for sqrt function
 *
 * @author Jonata Becker
 */
public class SqrtFunction implements Function {

    /**
     * Performs the sqrt function
     *
     * @param value
     * @return double
     */
    @Override
    public double calc(double value) {
        return Math.sqrt(value);
    }

}
