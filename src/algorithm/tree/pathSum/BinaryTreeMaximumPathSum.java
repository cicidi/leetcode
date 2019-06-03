package algorithm.tree.pathSum;

import algorithm.model.TreeNode;

/**
 * @author cicidi on 5/26/19
 */

/*
  * tag
  * lintcode 94. Binary Tree Maximum Path Sum
  * https://www.lintcode.com/problem/binary-tree-maximum-path-sum/description
  */
public class BinaryTreeMaximumPathSum {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */

    public int maxPathSum(TreeNode root) {
        // write your code here
        ResultType result = helper(root);
        return result.maxPath;
    }

    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int singlePath = 0;
        singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);
        return new ResultType(singlePath, maxPath);
    }

    class ResultType {
        int singlePath;
        int maxPath;

        public ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
}


