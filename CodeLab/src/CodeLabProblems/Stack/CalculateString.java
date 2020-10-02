package CodeLabProblems.Stack;

import java.util.List;

public class CalculateString {
    public static void main(String[] args) {

    }

    public static int calculate(String s) {
        /*
        * Implement a basic calculator to evaluate a simple expression string.
        *
        * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -,
        * non-negative integers and empty spaces .
        *
        * White board:
        *   - has spaces -> trim string
        *   - expression always valid
        *
        * Stack:
        *   - use a stack to keep track of ordering
        * Recursion:
        *   - method that returns an integer, takes in 2 expressions and compute the result
        *   - base: if 2 expressions are not operands or spaces
        *       convert string to char to int and add them up
        *   - recursive: one of the expressions is not just integer
        *       do recursion until base case
        *
        * TODO: review this problem
        * */

        return 0;

    }

    private static int evaluate (String e1, String e2, String op, boolean flip) {
        e1 = e1.trim();
        e2 = e2.trim();
        if (isNumber(e1) && isNumber(e2)) {
            return evaluate(Integer.parseInt(e1), Integer.parseInt(e2), op, flip);
        } else {
            int val1 = 0;
            int opIndex = 0;
            if (!isNumber(e1)) {
                if (e1.contains("(")) {
                    int bracketStart = 0;
                    int bracketEnd = e1.indexOf(")");
                    for (int i = 0; i < bracketEnd; i++) {
                        if (e1.charAt(i) == '(') {
                            bracketStart = i;
                        }
                    }
                    op = e1.split(")")[1].trim().substring(0, 1);

                }

                if (e1.indexOf('+') > 0) {
                    opIndex = e1.indexOf('+');
                } else {
                    opIndex = e1.indexOf('-');
                    flip = true;
                }
                String op1 = e1.substring(opIndex, opIndex + 1);
                val1 = evaluate(e1.split(op1)[0], e1.split(op1)[1], op1, flip);
            } else {
                val1 = Integer.parseInt(e1);
            }
            return val1;
        }
    }

    private static boolean isNumber(String expression) {
        return expression.indexOf('+') < 0 &&
                expression.indexOf('-') < 0 &&
                expression.indexOf('(') < 0 &&
                expression.indexOf(')') < 0;
    }

    private static int evaluate(int a, int b, String op, boolean flip) {
        if (op.equals("+")) {
            if (flip) {
                return a - b;
            }
            return a + b;
        }
        if (op.equals("-")) {
            if (flip) {
                return a + b;
            }
            return a - b;
        }
        return 0;
    }
}
