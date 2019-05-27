package algorithm.tree;

import algorithm.model.TreeNode;

/*
  * tag
  * lintcode
  * leetcode 114. Flatten Binary Tree to Linked List
  * url https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
  */
public class FlattenTreeNode {
    private TreeNode dummy = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        // 因为 最后结果右树在最下面，所以右边先走
        flatten(root.right);
        flatten(root.left);
        // 让右边等于那个dummy 也就是刚才在下一层里 调用的 dummy= root
        root.right = dummy;
        root.left = null;
        //
        // 一直到最后了，  把最右一个的有字数给一个null；
        dummy = root;
    }
}