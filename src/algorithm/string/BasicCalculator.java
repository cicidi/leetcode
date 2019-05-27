package algorithm.string;

import java.util.Stack;

/**
 * @author cicidi on 5/26/19
 * Lintcode 978. Basic Calculator
 * url https://www.lintcode.com/problem/basic-calculator/description
 */
public class BasicCalculator {
    /**
     * @param s: the given expression
     * @return: the result of expression
     */
    public int calculate(String s) {
        // Write your code here

        int result = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+') {
                result += sign * num; // sign* num
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                stack.add(result);
                stack.add(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * num;
                result *= stack.pop();
                result += stack.pop();
                num = 0;
            }
        }
        if (num != 0) {
            result += sign * num;
        }
        return result;
    }
}
