package algorithm.tree;

import model.TreeNode;

import java.util.*;
/*
  * tag
  * lintcode 300. Longest Increasing Subsequence
  * https://leetcode.com/problems/longest-increasing-subsequence/
  */

public class BinaryTreePreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode node) {
        return traversal(node);
    }

    public List<Integer> traversal(TreeNode root) {
        // 把这句话放在这里，因为上一层会用list.addAll 的方式加子树的result ，空值不会被加进去
        // 而且 如果是null 的话就报错了
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        } else {
            List<Integer> left = traversal(root.left);
            List<Integer> right = traversal(root.right);
            result.add(root.val);
            result.addAll(left);
            result.addAll(right);
            return result;
        }
    }
}
