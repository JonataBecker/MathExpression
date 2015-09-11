package br.com.jonatabecker.mathexpression;

import static junit.framework.Assert.*;
import org.junit.Test;

/**
 *
 * @author Jonata Becker
 */
public class MathExpressionTest {
    
    @Test
    public void sum() {
        MathExpression mathExpression = new MathExpression();
        assertEquals(10.0, mathExpression.calc("5 + 5"));
        assertEquals(15.0, mathExpression.calc("5 + 5 + 5"));
        assertEquals(10.0, mathExpression.calc("5 + 5 + 0"));
    }

    @Test
    public void subtraction() {
        MathExpression mathExpression = new MathExpression();
        assertEquals(0.0, mathExpression.calc("5 - 5"));
        assertEquals(-5.0, mathExpression.calc("5 - 5 - 5"));
        assertEquals(0.0, mathExpression.calc("5 - 5 - 0"));
    }

    @Test
    public void multiplication() {
        MathExpression mathExpression = new MathExpression();
        assertEquals(25.0, mathExpression.calc("5 * 5"));
        assertEquals(125.0, mathExpression.calc("5 * 5 * 5"));
        assertEquals(0.0, mathExpression.calc("5 * 5 * 0"));
    }

    @Test
    public void division() {
        MathExpression mathExpression = new MathExpression();
        assertEquals(1.0, mathExpression.calc("5 / 5"));
        assertEquals(5.0, mathExpression.calc("10 / 2"));
    }

    @Test
    public void expression() {
        MathExpression mathExpression = new MathExpression();
        assertEquals(-25.0, mathExpression.calc("10 / 5 + 5 * 4 - 47"));
    }    
    
}
