package CompaniesInterview.karat.basiccalculator;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(calculatorWithBrackets("(1+2)-3"));
    }

    static int calculator(String expression) {
        if (expression == null || expression.length() == 0) return 0;
        var result = 0;

        // define the sign here
        var sign = 1;
        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                var num = expression.charAt(i);
                var sb = new StringBuilder();
                sb.append(num);
                while (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                    i++;
                    sb.append(expression.charAt(i));
                }

                var number = Integer.parseInt(sb.toString());
                result += number * sign;
            } else if (expression.charAt(i) == '+') {
                sign = 1;
            } else if (expression.charAt(i) == '-') {
                sign = -1;
            }
        }
        return result;
    }

    static int calculatorWithBrackets(String expression) {
        if (expression == null || expression.length() == 0) return 0;
        var result = 0;
        int sign = 1;
        var stack = new Stack<Integer>();
        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                var num = expression.charAt(i);
                var sb = new StringBuilder();
                sb.append(num);
                while (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                    i++;
                    sb.append(expression.charAt(i));
                }

                var number = Integer.parseInt(sb.toString());
                result += number * sign;
            } else if (expression.charAt(i) == '+') {
                sign = 1;
            } else if (expression.charAt(i) == '-') {
                sign = -1;
            } else if (expression.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (expression.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }
}
