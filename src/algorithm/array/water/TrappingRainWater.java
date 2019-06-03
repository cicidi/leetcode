package algorithm.array.water;

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
            if (leftHeight < rightHeight) { //notice 从两边移动 谁小移动谁
                left++;
                if (leftHeight > heights[left]) {
                    sum += leftHeight - heights[left];  //左边蓄的水进入到总数
                } else {
                    leftHeight = heights[left];
                }
            } else {
                right--;
                if (rightHeight > heights[right]) {
                    sum += rightHeight - heights[right];//右边虚的水进入到总数
                } else {
                    rightHeight = heights[right];
                }
            }
        }
        return sum;
    }
}
