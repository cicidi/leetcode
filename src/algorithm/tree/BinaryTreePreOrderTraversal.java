package algorithm.tree;


import algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
  * tag
  * lintcode 144. Binary Tree Preorder Traversal
  * https://leetcode.com/problems/binary-tree-preorder-traversal/
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
