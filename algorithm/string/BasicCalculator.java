package string;

import java.util.Stack;

/**
 * @author cicidi on 5/26/19
 * Lintcode 978. Basic Calculator
 * url https://www.lintcode.com/problem/basic-calculator/description
 */
/*
red 总结 + 的作用是   result += number * sign ，前面一个number 的终结， 把前面的 number 加入到result里面，然后把sign 变成 1
        - 的作用是    result += number * sign ，前面一个number 的终结， 把前面的 number 加入到result里面，但是是把sign 变成-1
        ( 的作用是， 因为前面一个肯定不是number 所以没有终结，但是要把之前的result 放到stack 里面， 2，把正负号记录到stack 里面，3，把result 清零， 4，正负号清零
        ） 的作用是   result += number * sign ， 前面一个number 的终结，看stack 最后一个的sign ，然后合并之前stack 里面的最后一个数

 */
// notice  1+2-(34*56+18-12)  每一个括外之前的全部计算掉，然后和括号里面的一起在合并,合并之前要先看看看正负数
// notice  1+2-(34*56+(18+2)*3-12)  每一个左侧括号要做4件事情 1，把之前的result 放到stack 里面， 2，把正负号记录到stack 里面，3，把result 清零， 4，正负号清零
//  每一个右侧括号代表一个括号的结束，要做2件事情，第一第二 看正负数，第三 合并之前stack 里面的东西，第四清零当前number

// I and II 是两种不同的思路， 1 因为有括号，所以每次括号开始以前记录之前的结果和括号前的sign， 当前的数一直要乘以
    //之前的sign 然后在累加到result 综述里面
    // II的 思路是先看当前数是谁，

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
        Stack<Integer> stack = new Stack<Integer>();// notice 这里要用stack 经常脑子乱用了Queue
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
                num = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if (num != 0) {
            result += sign * num;
        }
        return result;
    }
}
