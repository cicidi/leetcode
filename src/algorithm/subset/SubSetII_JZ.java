package algorithm.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cicidi on 2019-06-21
 * Lintcode
 * url
 * <p>
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
/*
notice
两道题的区别是一个Subset2 又重复， subset1 没有重复
所以2 这里面要做一件事请是 important 去重复
                        通过先sort 然后看前一个和下一个是不是一样来去重复
剩下的 Subset 1 和subset 2 是一样的
*/
public class SubSetII_JZ {
    static class Solution {
        /**
         * @param nums: A set of numbers.
         * @return: A list of lists. All valid subsets.
         */
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            // write your code here
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null) return result;

            if (nums.length == 0) {
                result.add(new ArrayList<>());
                return result;
            }
            Arrays.sort(nums);

            List<Integer> subset = new ArrayList<>();
            helper(nums, 0, subset, result);
//            dfs(nums, 0, -1, subset, result);

            return result;


        }

        public void helper(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results) {
            results.add(new ArrayList<>(subset));
            for (int i = startIndex; i < nums.length; i++) {
                if (i != startIndex && nums[i] == nums[i - 1]) {
                    continue;
                }
                subset.add(nums[i]);
                helper(nums, i + 1, subset, results);
                subset.remove(subset.size() - 1);
            }
        }

        // 这个第2 种方案  在subset 1 和2 有比较大的不同
        private void dfs(int[] nums, int index, int lastSelectedIndex, List<Integer> subset, List<List<Integer>> result) {
            if (index == nums.length) {
                result.add(new ArrayList<>(subset));
                return;
            }
            dfs(nums, index + 1, lastSelectedIndex, subset, result);
            if (index > 0 && nums[index] == nums[index - 1] && index - 1 != lastSelectedIndex) { //没看懂这句话什么意思
                // important 这里是subset1 和2 不同的地方，
                return;
            }
            subset.add(nums[index]);

            dfs(nums, index + 1, index, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}
