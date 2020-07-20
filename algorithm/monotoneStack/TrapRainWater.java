package monotoneStack;

import java.util.Stack;
import java.util.Arrays;

public class TrapRainWater {

    public static void main(String[] args) {
        int[] input = new int[]{0, 1, 0, 2, 1, 0, 0, 3, 2, 1, 2, 1};
        System.out.println(cal(input));
    }

    public static int cal(int[] input) {
        Stack<Integer> stack = new Stack<>();
        int total = 0;
        for (int i = 0; i < input.length; ) {
            if (stack.isEmpty() || input[stack.peek()] >= input[i]) {
                stack.add(i);
                i++;
            } else {
                System.out.println(Arrays.toString(stack.toArray()));
                int bot = stack.pop();
                if (stack.isEmpty()) {
                    continue;
                }
                int bar = Math.min(input[i], input[stack.peek()]);
                int wh = bar - input[bot];
                int dis = i - stack.peek() - 1;
                total += wh * dis;
                System.out.printf("bot: %d, bar: %d, wh: %d, dis: %d, total: %d  \n", input[bot], bar, wh, dis, total);
            }
        }
        return total;
    }
}


/*
 * index  height stack   lowBar   bottom          walter
 * 0      0                0                        0
 * 1      1       1        0                        0
 * 2      0       [1,0]    0                        0
 * 3      2       [3]      1       stack.pop->0     1   <- 3 - 1 - 1* (lowBar - bottom)
 *
 *
 * */
