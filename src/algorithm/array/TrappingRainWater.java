package algorithm.array;

/**
 * @author cicidi on 5/26/19
 */

/*
  * tag
  * lintcode 363. Trapping Rain Water
  * https://www.lintcode.com/problem/trapping-rain-water/my-submissions
  */
public class TrappingRainWater {
    /**
     * @param heights: a list of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if (heights.length == 0) {
            return 0;
        }
        int left = 0;
        int right = heights.length - 1;
        int leftHeight = heights[left];
        int rightHeight = heights[right];
        int sum = 0;
        while (left < right) {
            if (leftHeight < rightHeight) {
                left++;
                if (leftHeight > heights[left]) {
                    sum += leftHeight - heights[left];
                } else {
                    leftHeight = heights[left];
                }
            } else {
                right--;
                if (rightHeight > heights[right]) {
                    sum += rightHeight - heights[right];
                } else {
                    rightHeight = heights[right];
                }
            }
        }
        return sum;
    }
}
