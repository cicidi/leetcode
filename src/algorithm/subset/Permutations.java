package algorithm.subset;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cicidi on 5/26/19
 */
public class Permutations {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        dfs(nums, new boolean[nums.length], 0, new ArrayList<>(), result);
        return result;
    }

    public void dfs(int[] nums, boolean[] visited, int size, List<Integer> list, List<List<Integer>> result) {
        if (size >= nums.length) {
            result.add(new ArrayList<>(list));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true; //notice this is the key point, 如果没有这个 ， 那么会 1，1，1，1，1，1.....一直加下去
            list.add(nums[i]);
            dfs(nums, visited, size + 1, list, result);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
