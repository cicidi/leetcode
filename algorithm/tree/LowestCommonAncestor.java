package tree;

import model.TreeNode;

/*
 * tag
 * leetcode 236. Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {

    // notice 如果root 等于其中一个A， 或B 那么 root 就是那个祖先
    //  recurssion
    //  两边都不是null 那么return root 因为左右两边一个等于A，一个等于B
    //  其中一个是null 那么另一个就是他俩的公共祖先  因为其中一个A 或B 都没有来得及被遍历出来 recursion 就已经停止了
    public TreeNode getLCA(TreeNode root, TreeNode A, TreeNode B) {

        if (root == null) {
            return null;
        }

        //this is very important
        // only if root =A or B can keep some value, otherwise only return to upper level
        if (root == A || root == B) {
            return root;
        }

        TreeNode left = getLCA(root.left, A, B);
        TreeNode right = getLCA(root.right, A, B);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        // if left and right both null;  which mean is any of the branch
        // does n't have A or B, clean this branch.
        return null;
    }
}
