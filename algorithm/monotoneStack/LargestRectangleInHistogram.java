/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (34.29%)
 * Total Accepted:    248.3K
 * Total Submissions: 724K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * 
 * 
 * 
 * Above is a histogram where width of each bar is 1, given height =
 * [2,1,5,6,2,3].
 * 
 * 
 * 
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10
 * unit.
 * $
 * 
 * 
 * Example:
 * 
 * 
 * Input: [2,1,5,6,2,3]
 * Output: 10
 * 
 * 
 */


/*
 *       x
 *      xx
 *      xx
 *      xx x
 *    x xxxx
 *    xxxxxx
 *
 *
 * 1. for loop end at next == heights.length. 
 * 2. The height would be the height[stack.pop()]
 * 3. only when add stack move the next++
 * 4. use asc monotone stack, 
 * 5. There is a confusion when I work on this problem. I create stack 
 * height value -> [1,5,6]
 * but it should be [2,5,6], the value 2 should not be replace by 1. Monotone stack
 * means, if the value smaller, dont add to stack, not even replace.
 * 6. use the height[stack.peek] as the hight, not iterator using while loop one
 * by one.
 * 
 * * */
package monotoneStack;
import java.util.Stack;
import java.util.Arrays;

class LargestRectangleInHistorgram{
    
  public static void main(String[] args){
    int[] input = new int[]{2,1,5,6,2,3};
    LargestRectangleInHistorgram l = new  LargestRectangleInHistorgram();
    System.out.println(l.largestRectangleArea(input));

  }
  public int largestRectangleArea(int[] heights) {
      int max = 0;
      Stack<Integer> stack = new Stack<>();
      for(int next = 0; next <= heights.length;){
        int h = next == heights.length ? 0 : heights[next];
        if(stack.isEmpty() || heights[stack.peek()] <= h){
          System.out.printf("next: %d,\n", next);
          stack.push(next);
          next++;
        }else{
          System.out.println(Arrays.toString(stack.toArray()));
          int tp = stack.pop();
          int range = 0;
          if (stack.isEmpty()){
            range = next; // the `next` is the length or the rectangle
          }else{
            range = next - 1 - stack.peek(); // the last element is the index of the value, which is the left edge 
                                            // of the rectangle;
          }
          System.out.printf("range: %d, tp: %d, heights[tp]: %d max: %d \n", range, tp, heights[tp], max);
          max = Math.max(max, range * heights[tp]);
        }
      }    
    return max; 
    }
}
