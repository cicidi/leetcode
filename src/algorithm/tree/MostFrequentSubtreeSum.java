package algorithm.tree;

import algorithm.model.TreeNode;

/**
 * @author cicidi on 5/27/19
 * Lintcode  1198. Most Frequent Subtree Sum
 * url https://www.lintcode.com/problem/most-frequent-subtree-sum/description
 * <p>
 * Description
 * 中文
 * English
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 * <p>
 * You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Example 1:
 * <p>
 * Input:
 * {5,2,-3}
 * Output:
 * [-3,2,4]
 * Explanation:
 * 5
 * /  \
 * 2   -3
 * since all the values happen only once, return all of them in any order.
 * Example 2:
 * <p>
 * Input:
 * {5,2,-5}
 * Output:
 * [2]
 * Explanation:
 * 5
 * /  \
 * 2   -5
 * since 2 happens twice, however -5 only occur once.
 */

import java.util.*;

public class MostFrequentSubtreeSum {
    /**
     * @param root: the root
     * @return: all the values with the highest frequency in any order
     */
    Map<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;

    public int[] findFrequentTreeSum(TreeNode root) {
        // Write your code here

        if (root == null) {
            return new int[0];
        }
        dfs(root);
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }
        System.out.printf("map size %d", map.size());
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        sum = root.val + dfs(root.left) + dfs(root.right);
        int cur = map.getOrDefault(sum, 0) + 1;
        max = Math.max(max, cur);
        map.put(sum, cur);
        return sum;
    }
}
