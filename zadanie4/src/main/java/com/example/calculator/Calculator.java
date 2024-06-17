package com.example.calculator;

import java.util.Stack;

public class Calculator {
    private Stack<Double> values = new Stack<>();
    private Stack<Character> operations = new Stack<>();

    public double evaluate(String expression) {
        values.clear();
        operations.clear();
        
        char[] tokens = expression.toCharArray();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue;

            if (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.') {
                StringBuilder sbuf = new StringBuilder();
                while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.'))
                    sbuf.append(tokens[i++]);
                values.push(Double.parseDouble(sbuf.toString()));
                i--;
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/' || tokens[i] == '^') {
                while (!operations.isEmpty() && hasPrecedence(tokens[i], operations.peek()))
                    values.push(applyOperation(operations.pop(), values.pop(), values.pop()));
                operations.push(tokens[i]);
            }
        }

        while (!operations.isEmpty())
            values.push(applyOperation(operations.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    public double power(double a, double b) {
        return Math.pow(a, b);
    }

    private boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    private double applyOperation(char op, double b, double a) {
        switch (op) {
            case '+':
                return add(a, b);
            case '-':
                return subtract(a, b);
            case '*':
                return multiply(a, b);
            case '/':
                return divide(a, b);
            case '^':
                return power(a, b);
        }
        return 0;
    }
}
