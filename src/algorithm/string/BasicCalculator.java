package algorithm.string;

import java.util.Stack;

/**
 * @author cicidi on 5/26/19
 * Lintcode 978. Basic Calculator
 * url https://www.lintcode.com/problem/basic-calculator/description
 */
// notice  1+2-(34*56+18-12)  每一个括外之前的全部计算掉，然后和括号里面的一起在合并,合并之前要先看看看正负数
// notice  1+2-(34*56+(18+2)*3-12)  每一个左侧括号要做4件事情 1，把之前的result 放到stack 里面， 2，把正负号记录到stack 里面，3，把result 清零， 4，正负号清零
//  每一个右侧括号代表一个括号的结束，要做2件事情，第一第二 看正负数，第三 合并之前stack 里面的东西，第四清零当前number
public class BasicCalculator {
    /**
     * @param s: the given expression
     * @return: the result of expression
     */
    public int calculate(String s) {
        // Write your code here

        int result = 0;
        int num = 0;
        int sign = 1; // 因为有括号 记录括号每一个+ - 的情况， 然后括号括死的时候计算正负
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // green 计算当前的数值
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
            } else if (c == '(') { //notice 括号发生以前，把之前的result 用stack 记录下来
                stack.add(result);
                stack.add(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') { // notice 括号结束以后， 把括号括死前的最后一个数计算了，然后再和在stack 里面的result 合并， 合并之前要先看看看正负数
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
