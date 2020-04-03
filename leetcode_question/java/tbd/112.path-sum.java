/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
 *
 * https://leetcode.com/problems/path-sum/description/
 *
 * algorithms
 * Easy (38.81%)
 * Total Accepted:    377.7K
 * Total Submissions: 962.4K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,null,1]\n22'
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \      \
 * 7    2      1
 * 
 * 
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
       return dfs(root, sum); 
    }
    // wrong solution
    public static boolean dfs(TreeNode root, int diff){
     if (root == null){
        if (diff == 0){
             return true;
        }else{
            return false;
        }
     }else{
        int diff = diff - root.value
        if (diff < 0) {
            return false;
        }else{
            //notice  这个做法有一个问题，就是没有考虑到 有可能一个node 只有一个left 和一个right，
            // 但是这个时候如果刚好又传了一个diff = 0，就构成了 null + 0 的组合
            return dfs(root.left, diff) || dfs(root.right, diff); 
       }

     }
    }
}
