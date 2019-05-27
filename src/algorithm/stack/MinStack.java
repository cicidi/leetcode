package algorithm.stack;

import java.util.Stack;
/*
  * tag
  * lintcode
  * url https://www.lintcode.com/problem/alien-dictionary/description
  * leetcode
  * url
  */


public class MinStack {
    public MinStack() {
        // do intialization if necessary
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int number) {
        // write your code here

        stack.add(number);
        if (!minStack.isEmpty()) {
            number = Math.min(number, minStack.peek()); //notice: use peek here
        }
        minStack.add(number);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        minStack.pop();
        return stack.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return minStack.peek();
    }
}