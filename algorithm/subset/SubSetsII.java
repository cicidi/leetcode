/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (43.86%)
 * Total Accepted:    236.1K
 * Total Submissions: 531.1K
 * Testcase Example:  '[1,2,2]'
 *
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,2]
 * Output:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 * 
 */
import java.util.*;
class SubSetsII{
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       // sort first
       // dfs 
            // add to list
       // final list should be a set
       // 
       Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
       dfs(nums, 0, new ArrayList<>(), set);
        return new ArrayList<>(set);
    }
    public void dfs(int[] nums, int i, List<Integer> tmp, Set<List<Integer>> result){
        result.add(new ArrayList<>(tmp));
        if (i >= nums.length){
            return ;
            } 
     for (; i < nums.length; i++) {
            List<Integer> l = new ArrayList<>();
            l.addAll(tmp);
            l.add(nums[i]);
            dfs(nums, i + 1, l, result);
            l.remove(l.size() - 1);
       } 
    }
    
    public static void main(String[] args){
        SubSetsII s = new SubSetsII();
        //int[] arr = new int[]{1, 2, 3, 2};
        int[] arr = new int[]{1};
        System.out.println(s.subsetsWithDup(arr));
   }
}
