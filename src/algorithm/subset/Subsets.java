package algorithm.subset;

import java.util.*;

/*
  * tag
  * lintcode
  * leetcode
  * url
  */

public class Subsets {


    public List<List<Integer>> subsets(int[] nums) {
        // write your code here

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(nums, 0, tmp, result);
        return result;
    }

    public void dfs(int[] nums, int level, List<Integer> list, List<List<Integer>> result) {
        if (level >= nums.length) {
            result.add(list);
            return;
        }
        //	dfs[nums,level,list]
        List<Integer> tmp = new ArrayList<>();
        for (int i = level; i < nums.length; i++) {
            tmp.add(nums[level]);
            dfs(nums, level + 1, tmp, result);
            tmp.remove(tmp.size() - 1);
            dfs(nums, level + 1, tmp, result);
        }
    }
}
