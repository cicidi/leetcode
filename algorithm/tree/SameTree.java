package tree;

/*
 * important
 * notice
 * green
 * url
 * leetcode
 *
 * 分析
 * */

import model.TreeNode;

public class SameTree {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println();
    }

    static class Solution {
        /**
         * @param a, b, the root of binary trees.
         * @return true if they are identical, or false.
         */
        public boolean isIdentical(TreeNode a, TreeNode b) {
            // Write your code here
            if (a == null && b == null)
                return true;
            if (a != null && b != null) {
                return a.val == b.val && isIdentical(a.left, b.left)
                        && isIdentical(a.right, b.right);
            }
            return false;
        }
    }
}
