package br.com.jonatabecker.mathexpression;

import br.com.jonatabecker.mathexpression.function.Function;
import br.com.jonatabecker.mathexpression.function.SqrtFunction;
import br.com.jonatabecker.mathexpression.operation.DivisonOperation;
import br.com.jonatabecker.mathexpression.operation.MultiplicationOperation;
import br.com.jonatabecker.mathexpression.operation.SumOperation;
import br.com.jonatabecker.mathexpression.operation.SubtractionOperation;
import br.com.jonatabecker.mathexpression.operation.Operation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class responsible for calculating mathematical expression
 * 
 * @author Jonata Becker
 */
public class MathExpression {

    /** List of pryority */
    private final List<Map<String, Operation>> priority;
    /** List of functions */
    private final Map<Pattern, Function> functions;
    /** Patter to validade expression */
    private static final Pattern EXP = Pattern.compile("^(sqrt\\([0-9]+\\)|(sqrt\\([0-9]+\\)|([0-9])+)+( [+-/\\\\*]( (sqrt\\([0-9]+\\)|([0-9]+))))+)$");
    
    public MathExpression() {
        this.priority = new ArrayList<>();
        // Define functions
        this.functions = new HashMap<>();
        this.functions.put(Pattern.compile("sqrt\\([0-9]+\\)"), new SqrtFunction());
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
     * Execute calculation of mathematical expressions
     * 
     * @param expression
     * @return double 
     * @throws InvalidExpressionException Invalida expression
     */
    public double calc(String expression) throws InvalidExpressionException {
        if (!isValid(expression)) {
            throw new InvalidExpressionException(expression);
        }
        return calcRecursive(calcFunction(expression));
    }

    /**
     * Execute calculation of mathematical expressions
     * 
     * @param expression
     * @return double 
     */    
    private double calcRecursive(String expression) {
        String[] expArr = expression.split(" ");
        if (expArr.length == 1) {
            return Double.parseDouble(expArr[0]);
        }
        TokenOperator token = nextToken(expArr);
        double val1 = Double.parseDouble(expArr[token.getPos() - 1]);
        double val2 = Double.parseDouble(expArr[token.getPos() + 1]);
        String v = expArr[token.getPos() - 1] + " " + expArr[token.getPos()] + " " + expArr[token.getPos() + 1];
        double result = token.getOperation().calc(val1, val2);
        return calcRecursive(expression.replace(v, String.valueOf(result)));        
    }
    
    /**
     * Execute calculation of mathematical functions
     * 
     * @param expression
     * @return String
     */
    private String calcFunction(String expression) {
        for (Map.Entry<Pattern, Function> entry : functions.entrySet()) {
            Matcher matcher = entry.getKey().matcher(expression);
            // If find one function
            if (matcher.find()) {
                String group = matcher.group();
                double number = Double.valueOf(group.substring(group.indexOf('(') + 1, group.indexOf(')')));
                double value = entry.getValue().calc(number);
                return calcFunction(expression.replace(group, String.valueOf(value)));
            }           
        }
        return expression;
    }
    
    /**
     * Returns true if the expression informed is valid
     * 
     * @param expression
     * @return boolean
     */
    public boolean isValid(String expression) {
        return EXP.matcher(expression).find();
    }

    /**
     * Return true if token is a operation token
     * 
     * @param token
     * @return boolean 
     */
    public boolean isTokenOperation(String token) {
        for (Map<String, Operation> mapPriority : priority) {
            if (mapPriority.get(token) != null) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Search next token in the caracter list expression
     * 
     * @param expArr
     * @return TokenOperator
     */
    private TokenOperator nextToken(String[] expArr) {
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
