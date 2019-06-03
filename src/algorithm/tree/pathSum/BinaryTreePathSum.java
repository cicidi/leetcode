package algorithm.tree.pathSum;

import algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cicidi on 5/26/19
 * Lintcode 376. Binary Tree Path Sum
 * url https://www.lintcode.com/problem/binary-tree-path-sum/description
 */
public class BinaryTreePathSum {
    /*
         * @param root: the root of binary tree
         * @param target: An integer
         * @return: all valid paths
         */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        scan(root, new ArrayList<Integer>(), 0, target, result);

        return result;
    }

    public void scan(TreeNode root, List<Integer> list, int sum, int target, List<List<Integer>> result) {
        list.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null && sum == target) {
            result.add(list);
        } else {
            if (root.left != null) {
                scan(root.left, new ArrayList<>(list), sum, target, result);
            }
            if (root.right != null) {
                scan(root.right, new ArrayList<>(list), sum, target, result);
            }
        }

    }
}
