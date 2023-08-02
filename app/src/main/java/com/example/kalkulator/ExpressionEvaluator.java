package com.example.kalkulator;

import java.util.Stack;

public class ExpressionEvaluator {

    public static double evaluateMathExpression(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                StringBuilder numStr = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numStr.append(expression.charAt(i));
                    i++;
                }
                i--; // Move back one step to reevaluate the current character
                double num = Double.parseDouble(numStr.toString());
                numbers.push(num);
            } else if (ch == '^' || ch == '*' || ch == '/' || ch == '+' || ch == '-') {
                while (!operators.isEmpty() && hasPrecedence(ch, operators.peek())) {
                    evaluateTopOperator(numbers, operators);
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            evaluateTopOperator(numbers, operators);
        }

        return numbers.pop();
    }

    private static boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        if (op2 == '(' || op2 == ')')
            return false;
        return true;
    }

    private static void evaluateTopOperator(Stack<Double> numbers, Stack<Character> operators) {
        char operator = operators.pop();
        double num2 = numbers.pop();
        double num1 = numbers.pop();
        double result = 0.0;

        switch (operator) {
            case '^':
                result = Math.pow(num1, num2);
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
        }

        numbers.push(result);
    }
}

