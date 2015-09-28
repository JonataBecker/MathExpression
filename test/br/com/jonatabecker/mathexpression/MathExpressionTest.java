package br.com.jonatabecker.mathexpression;

import static junit.framework.Assert.*;
import org.junit.Test;

/**
 * Units tests
 *
 * @author Jonata Becker
 */
public class MathExpressionTest {

    @Test
    public void sum() throws InvalidExpressionException {
        MathExpression mathExpression = new MathExpression();
        assertEquals(10.0, mathExpression.calc("5 + 5"));
        assertEquals(15.0, mathExpression.calc("5 + 5 + 5"));
        assertEquals(10.0, mathExpression.calc("5 + 5 + 0"));
    }

    @Test
    public void subtraction() throws InvalidExpressionException {
        MathExpression mathExpression = new MathExpression();
        assertEquals(0.0, mathExpression.calc("5 - 5"));
        assertEquals(-5.0, mathExpression.calc("5 - 5 - 5"));
        assertEquals(0.0, mathExpression.calc("5 - 5 - 0"));
    }

    @Test
    public void multiplication() throws InvalidExpressionException {
        MathExpression mathExpression = new MathExpression();
        assertEquals(25.0, mathExpression.calc("5 * 5"));
        assertEquals(125.0, mathExpression.calc("5 * 5 * 5"));
        assertEquals(0.0, mathExpression.calc("5 * 5 * 0"));
    }

    @Test
    public void division() throws InvalidExpressionException {
        MathExpression mathExpression = new MathExpression();
        assertEquals(1.0, mathExpression.calc("5 / 5"));
        assertEquals(5.0, mathExpression.calc("10 / 2"));
    }

    @Test
    public void expression() throws InvalidExpressionException {
        MathExpression mathExpression = new MathExpression();
        assertEquals(-25.0, mathExpression.calc("10 / 5 + 5 * 4 - 47"));
    }

    @Test(expected = InvalidExpressionException.class)
    public void expressionInalid() throws InvalidExpressionException {
        MathExpression mathExpression = new MathExpression();
        assertEquals(-25.0, mathExpression.calc("10 / 5 + 5 * 4 -"));
    }

    @Test
    public void sqrt() throws InvalidExpressionException {
        MathExpression mathExpression = new MathExpression();   
        assertEquals(12.0, mathExpression.calc("sqrt(64) + 4"));
        assertEquals(16.0, mathExpression.calc("sqrt(64) + sqrt(64)"));
        assertEquals(8.0, mathExpression.calc("sqrt(64)"));
    }    
    
}
