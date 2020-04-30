package array.twoPointer;

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







/*
 * the critail point in this question we need leftHighest and rightHighest, and whoever is small 
 * is going to move toward the toget
 *
 * */

      public int trap(int[] height) {
           
           int len = height.length;
           if (len < 3) {
               return 0;
           }
           int left = 1;
           int right = len - 2;
           int lh = height[0];  //left highest
           int rh = height[len - 1];  //right hightest
           
           int total = 0;
           // Wrong condition -> {left and right should have at least 1 gap} 
           // because there could be two bar next to each other, one is water, other is the fench
           // the condition should be left <= right
           while(left <= right){ 
               if (lh <= rh){
                   if (height[left] < lh){
                       total += lh - height[left];
                   }else{
                       lh = height[left];
                   }
                   left++;
               }else{
                   if (height[right] < rh){
                       total += rh - height[right];
                   }else{
                       rh = height[right];
                   }
                   right--;
               }
           }
           
           return total;
    }
}
