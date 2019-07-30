package algorithm.string;

import java.util.Stack;

/**
 * @author cicidi on 5/26/19
 * Lintcode 980. Basic Calculator II
 * url https://www.lintcode.com/problem/basic-calculator-ii/description
 */
public class BasicCalculatorII {
    /**
     * @param s: the given expression
     * @return: the result of expression
     */
    public int calculate(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        int num = 0;
        int length = s.length();
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            System.out.println(c);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) && ' ' != c || i == length - 1) {
                if (op == '+') {
                    stack.add(num);
                }
                if (op == '-') {
                    stack.add(-num);
                }
                if (op == '*') {
                    stack.add(stack.pop() * num);
                }
                if (op == '/') {
                    stack.add(stack.pop() / num);
                }
                op = c;
                num = 0;
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            // System.out.println(stack.peek());
            sum += stack.pop();
        }

        return sum;
    }
}
