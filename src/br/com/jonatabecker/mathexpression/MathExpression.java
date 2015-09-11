package br.com.jonatabecker.mathexpression;

import br.com.jonatabecker.mathexpression.operation.DivisonOperation;
import br.com.jonatabecker.mathexpression.operation.MultiplicationOperation;
import br.com.jonatabecker.mathexpression.operation.SumOperation;
import br.com.jonatabecker.mathexpression.operation.SubtractionOperation;
import br.com.jonatabecker.mathexpression.operation.Operation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Jonata Becker
 */
public class MathExpression {

    private final List<Map<String, Operation>> priority;

    public MathExpression() {
        this.priority = new ArrayList<>();
        // Define second priority
        Map<String, Operation> secondPriority = new TreeMap<>();
        secondPriority.put("*", new MultiplicationOperation());
        secondPriority.put("/", new DivisonOperation());
        priority.add(secondPriority);
        // Define third priority
        Map<String, Operation> thirdPriority = new TreeMap<>();
        thirdPriority.put("+", new SumOperation());
        thirdPriority.put("-", new SubtractionOperation());
        priority.add(thirdPriority);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // 5 + 5 * 9 + 5 * 9
        // 5 + (5 + 6)
        String exp = "10 + 5 * 5 + 5 * 5 + 10 / 5";

        MathExpression mathExpression = new MathExpression();

        System.out.println(mathExpression.calc(exp));

    }

    public double calc(String expression) {
        String[] expArr = expression.split(" ");
        if (expArr.length == 1) {
            return Double.parseDouble(expArr[0]);
        }
        TokenOperator token = nextToken(expArr);
        double val1 = Double.parseDouble(expArr[token.getPos() - 1]);
        double val2 = Double.parseDouble(expArr[token.getPos() + 1]);
        String v = expArr[token.getPos() - 1] + " " + expArr[token.getPos()] + " " + expArr[token.getPos() + 1];
        double result = token.getOperation().calc(val1, val2);
        return calc(expression.replace(v, String.valueOf(result)));
    }

    public TokenOperator nextToken(String[] expArr) {
        for (Map<String, Operation> map : priority) {
            for (int i = 0; i < expArr.length; i++) {
                Operation op = map.get(expArr[i]);
                if (op != null) {
                    return new TokenOperator(expArr[i], i, op);
                }
            }
        }
        return null;
    }

}
