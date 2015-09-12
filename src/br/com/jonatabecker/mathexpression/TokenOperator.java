package br.com.jonatabecker.mathexpression;

import br.com.jonatabecker.mathexpression.operation.Operation;

/**
 * Class responsible for operator token informations
 *
 * @author Jonata Becker
 */
public class TokenOperator {

    /** Token */
    private final String token;
    /** Position of token */
    private final int pos;
    /** Operations */
    private final Operation operation;

    public TokenOperator(String token, int pos, Operation operation) {
        this.token = token;
        this.pos = pos;
        this.operation = operation;
    }

    /**
     * Return the token
     *
     * @return String
     */
    public String getToken() {
        return token;
    }

    /**
     * Return the position of token
     *
     * @return int
     */
    public int getPos() {
        return pos;
    }

    /**
     * Return the operator
     *
     * @return Operation
     */
    public Operation getOperation() {
        return operation;
    }

}
