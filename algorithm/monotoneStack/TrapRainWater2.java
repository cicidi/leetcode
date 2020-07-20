package monotoneStack;

import java.util.*;

public class TrapRainWater2 {
  public static void main(String[] args) {}

  public int getArea(int[] input) {
    int total = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < input.length; ) {
      if (stack.isEmpty() || stack.peek() >= input[i]) {
        stack.add(input[i]);
        i++;
      } else {
        int bot = stack.pop();
        if (stack.isEmpty()) {
          continue;
        }
        // wl is water level
        int wl = Math.min(input[stack.peek()], input[i]);
        int dis = i - stack.peek() - 1;
        total += dis * (wl - bot);
      }
    }
    return total;
  }
}
