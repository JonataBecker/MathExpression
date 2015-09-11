package br.com.jonatabecker.mathexpression;

import br.com.jonatabecker.mathexpression.operation.Operation;

/**
 *
 * @author jonata-pc
 */
public class TokenOperator {

    private final String token;

    private final int pos;

    private final Operation operation;

    public TokenOperator(String token, int pos, Operation operation) {
        this.token = token;
        this.pos = pos;
        this.operation = operation;
    }

    public String getToken() {
        return token;
    }

    public int getPos() {
        return pos;
    }

    public Operation getOperation() {
        return operation;
    }

}
