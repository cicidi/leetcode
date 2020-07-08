package monotoneStack;
/*
 *
 * i
 * 单调栈主要回答这样的几种问题

    比当前元素更大的下一个元素
    比当前元素更大的前一个元素
    比当前元素更小的下一个元素
    比当前元素更小的前一个元素
 */

import java.util.*;

class MonoStack {

    /*
     *4,6,9,3,8,2,7
      4,6,3,

     * */
    public List<List<Integer>> ascStack(int[] input) {
        List<List<Integer>> life = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int value : input) {
            List<Integer> stage = new ArrayList<>();
            while (!stack.isEmpty() && stack.peek() > value) {
                stage.add(0, stack.pop());
            }
            stack.add(value);
            if (stage.size() != 0)
                life.add(stage);
        }
        List<Integer> stage = new ArrayList<>();
        while (!stack.isEmpty()) {
            stage.add(0, stack.pop());
        }
        life.add(stage);
        return life;
    }

    public static Stack<Integer> descStack(int[] input) {
        Stack<Integer> stack = new Stack<>();
        for (int num : input) {
            while (!stack.isEmpty() && stack.peek() < num) {
                stack.pop();
            }
            stack.add(num);
        }
        return stack;
    }
}
