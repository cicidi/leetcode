package algorithm.tree;

import algorithm.model.TreeNode;

import java.util.LinkedList;

/**
 * @author cicidi on 5/27/19
 * Lintcode 1101. Maximum Width of Binary Tree
 * url https://www.lintcode.com/problem/maximum-width-of-binary-tree/description
 */
public class MaximumWidthOfBinaryTree {
    /**
     * @param root: the root
     * @return: the maximum width of the given tree
     */
    public int widthOfBinaryTree(TreeNode root) {
        // Write your code here

        if (root == null) {
            return 1;
        }
        int max = 1;
        root.val = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);


        // TreeNode current=null;
        while (!queue.isEmpty()) {
            max = Math.max(max, (queue.peekLast().val - queue.peekFirst().val) + 1);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (root.left != null) {
                    root.left.val = root.val * 2;
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    root.right.val = root.val * 2 + 1;
                    queue.offer(root.right);
                }
            }
        }
        return max;
    }
}
