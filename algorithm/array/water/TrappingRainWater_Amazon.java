package array.water;

/**
 * @author cicidi on 2019-06-06
 * Lintcode
 * url
 */

// same question with trapping water 1  but need find largest  pool
public class TrappingRainWater_Amazon {
    /**
     * @param heights: a list of integers
     * @return: a integer
     */
    public int maxTrapRainWater(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        int leftIndex = 0;
        int rightIndex = heights.length - 1;
        int leftValue = heights[leftIndex];
        int rightValue = heights[rightIndex];

        int leftSum = 0;
        int rightSum = 0;
        int max = 0;

        while (leftIndex < rightIndex) {
            if (leftValue < rightValue) {
                leftIndex++;
                if (leftValue < heights[leftIndex]) {
                    leftSum += leftValue - heights[leftIndex];
                } else {
                    leftValue = heights[leftIndex];
                    max = Math.max(max, leftSum);
                    leftSum = 0;
                }

            } else {
                rightIndex--;
                if (rightValue > heights[rightIndex]) {
                    rightSum += rightValue - heights[rightIndex];
                } else {
                    rightValue = heights[rightIndex];
                    max = Math.max(max, rightSum);
                    rightSum = 0;
                }
            }

        }
        return max;
    }
}
