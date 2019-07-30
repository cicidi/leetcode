package subset;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cicidi on 5/26/19
 */

// yellow permutation 是把1，2，3  的所有排列组合全部找出来，那么就需要有 visited
//  Subset 是子集 会后就好了，不用visited 但是subset 里面一个for loop 里面用了两次dfs
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
            visited[i] = true; //important this is the key point, 如果没有这个 ， 那么会 1，1，1，1，1，1.....一直加下去
            list.add(nums[i]);
            dfs(nums, visited, size + 1, list, result);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
