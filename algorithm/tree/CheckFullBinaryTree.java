package tree;

import model.TreeNode;

/**
 * @author cicidi on 5/26/19
 * Lintcode 726. Check Full Binary Tree
 * url https://www.lintcode.com/problem/check-full-binary-tree/description
 */
public class CheckFullBinaryTree {
    /**
     * @param root: the given tree
     * @return: Whether it is a full tree
     */
    public boolean isFullTree(TreeNode root) {
        // write your code here

        if (root == null) {
            return true;
        }
        if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
            return false;
        }
        return isFullTree(root.left) && isFullTree(root.right);
    }
}
