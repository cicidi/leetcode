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
        int leftIndex = 0;
        int rightIndex = heights.length - 1;
        int leftValue = heights[leftIndex];
        int rightValue = heights[rightIndex];
        int sum = 0;
        while (leftIndex < rightIndex) {
            if (leftValue < rightValue) { //notice 从两边移动 谁小移动谁
                leftIndex++;
                if (leftValue > heights[leftIndex]) {
                    sum += leftValue - heights[leftIndex];  //左边蓄的水进入到总数
                } else {
                    leftValue = heights[leftIndex];
                }
            } else {
                rightIndex--;
                if (rightValue > heights[rightIndex]) {
                    sum += rightValue - heights[rightIndex];//右边虚的水进入到总数
                } else {
                    rightValue = heights[rightIndex];
                }
            }
        }
        return sum;
    }
}
