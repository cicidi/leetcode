package stack;

import java.util.Stack;

/**
 * @author cicidi on 5/26/19
 */

/*
  * tag
  * lintcode 40. Implement Queue by Two Stacks
  * https://www.lintcode.com/problem/implement-queue-by-two-stacks/description
  */

public class ImplementQueuebyTwoStacks {
    public ImplementQueuebyTwoStacks() {
        // do intialization if necessary
    }

    /*
     * @param element: An integer
     * @return: nothing
     */

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int element) {
        // write your code here
        s2.push(element);

    }

    public void stack2To1() {
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        while (s1.isEmpty()) {
            stack2To1();
        }
        return s1.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        while (s1.isEmpty()) {
            stack2To1();
        }
        return s1.peek();
    }
}
