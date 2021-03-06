package string;

/**
 * @author cicidi on 5/27/19
 * Lintcode 1176. Optimal Division
 * url https://www.lintcode.com/problem/optimal-division/my-submissions
 * Description
 * 中文
 * English
 * Given a list of positive integers, the adjacent integers will perform the float division. For example, [2,3,4] -> 2 / 3 / 4.
 * <p>
 * However, you can add any number of parenthesis at any position to change the priority of operations. You should find out how to add parenthesis to get the maximum result, and return the corresponding expression in string format. Your expression should NOT contain redundant parenthesis.
 * <p>
 * 1.The length of the input array is [1, 10].
 * 2.Elements in the given array will be in range [2, 1000].
 * 3.There is only one optimal division for each test case.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Example 1:
 * <p>
 * Input: [1000,100,10,2]
 * Output: "1000/(100/10/2)"
 * Explanation:
 * 1000/(100/10/2) = 1000/((100/10)/2) = 200
 * However, the bold parenthesis in "1000/((100/10)/2)" are redundant,
 * since they don't influence the operation priority. So you should return "1000/(100/10/2)".
 * <p>
 * Other cases:
 * 1000/(100/10)/2 = 50
 * 1000/(100/(10/2)) = 50
 * 1000/100/10/2 = 0.5
 * 1000/100/(10/2) = 2
 */
public class OptimalDivision {
    /**
     * @param nums: an array
     * @return: the corresponding expression in string format
     */
    public String optimalDivision(int[] nums) { //important 让分母最小，也就是一直除呗
        // Write your code here
        if (nums == null || nums.length == 0) {
            return "";
        }
        if (nums.length == 1) {
            return nums[0] + "";
        }
        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder s = new StringBuilder();
        s.append(nums[0] + "/(" + nums[1]);
        for (int i = 2; i < nums.length; i++) {
            s.append("/");
            s.append(nums[i]);
        }
        s.append(")");
        return s.toString();
    }
}
