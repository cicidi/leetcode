package array.regret;

/*
 * important
 * notice
 * green
 * url
 * leetcode
 * tag: 后悔算法
 *
 *
282. Expression Add Operators
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"]
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExpressionAddOperators {

    public static void main(String[] args) {
        Solution s = new Solution();

        List<String> result = s.addOperators("105", 5);
        System.out.println(Arrays.toString(result.toArray()));
    }

    static class Solution {
        public List<String> addOperators(String num, int target) {
            if (num == null || num.length() == 0) {
                return new ArrayList<>();
            }

            List<String> list = insertOperator(num);
            System.out.println(Arrays.toString(list.toArray()));
            return filter(list, target);
        }

        public List<String> insertOperator(String num) {
            List<String> list = new ArrayList<>();
            if (num.length() == 1) {
                list.add(num);
                return list;
            }
            insertOperator(num, 0, new StringBuilder(), list);
            return list;
        }

        String[] operator = {"", "+", "-", "*"};

        public void insertOperator(String num, int current, StringBuilder sb, List<String> list) {

//            if (current == num.length()) {
//
//            }
            sb.append(num.charAt(current));
            if (current == num.length() - 1) {
                list.add(sb.toString());
                return;
            } else {
                for (int i = 0; i < 4; i++) {
                    sb.append(operator[i]);
                    insertOperator(num, current + 1, sb, list);
                    sb.deleteCharAt(sb.length() - 1);
                    if (i != 0)
                        sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

        public List<String> filter(List<String> input, int target) {
            List<String> result = new ArrayList<>();
            for (String str : input) {
                if (calculate(str, target)) {
                    result.add(str);
                }
            }
            return result;

        }

        public boolean calculate(String str, int target) {

            Stack<Integer> stack = new Stack<>();
            int value = 0;
            char op = '+';
            int num = 0;

            // important  这里还有一个问题没有解决
            //important [105, 10+5, 10-5, 10*5, 1+05, 1+0+5, 1+0-5, 1+0*5, 1-05, 1-0+5, 1-0-5, 1-0*5, 1*05, 1*0+5, 1*0-5, 1*0*5]
            //important [10-5, 1*05, 1*0+5] 第二个不 valid
            for (int i = 0; i < str.toCharArray().length; i++) {
                char c = str.charAt(i);
                if (Character.isDigit(c)) {
                    num = num * 10 + c - '0';
                }
                //important 这句话写了几次都错了
                //notice 让当前num 和之前的数值进行整合计算要满足几个条件
                //notice 1 这时候num 已经完全可以代表两个符号之间的数了->
                //          orange 当前已经不在是数字了
                //          orange 已经到了最后一位了，那么肯定也不会有数字了
                //notice 2 空格不考虑
                if (!Character.isDigit(c) && c != ' ' || i == str.length() - 1) {
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
                        if (num != '0') {
                            stack.add(stack.pop() / num);
                        } else {
                            return false;
                        }
                    }
                    op = c;
                    num = 0;
                }
            }
            while (!stack.isEmpty()) {
                value += stack.pop();
            }
            return value == target;
        }
    }
}
