package algorithm.subset;

import java.util.*;

/*
 * tag
 * lintcode
 * leetcode
 * url
 *
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */

public class Subsets {


    public List<List<Integer>> subsets(int[] nums) {
        // write your code here

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;

        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        List<Integer> tmp = new ArrayList<>();
//        helper(nums, 0, tmp, result);
        dfs(nums, 0, tmp, result);
        return result;
    }

    // helper 的第2种写法
    private void helper(int[] nums,
                        int startIndex, List<Integer> subset, List<List<Integer>> result) {
        // 2. 递归的拆解
        // deep copy
        // results.add(subset);
        result.add(new ArrayList<>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            // [1] -> [1,2]
            subset.add(nums[i]);
            // 寻找所有以 [1,2] 开头的集合，并扔到 results
            helper(nums, i + 1, subset, result);
            // [1,2] -> [1]  回溯
            subset.remove(subset.size() - 1);
        }

        // 3. 递归的出口
        // return;
    }

    // helper 的第一种写法
    private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> result) {
        // 3. 递归的出口
        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        // 2. 递归的拆解
        // (如何进入下一层)

        // 选了 nums[index]
        dfs(nums, index + 1, subset, result);
        subset.add(nums[index]);

        // 不选 nums[index]
        dfs(nums, index + 1, subset, result);
        subset.remove(subset.size() - 1);
    }


}
