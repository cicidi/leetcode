/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (48.42%)
 * Total Accepted:    262.2K
 * Total Submissions: 534.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the bottom-up level order traversal of its
 * nodes' values. (ie, from left to right, level by level from leaf to root).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its bottom-up level order traversal as:
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 * 
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

import java.util.*;
class BinaryTreeLevelOrderTraversalII{
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
       
     List<List<Integer>> result = new ArrayList<>();
     Stack<List<Integer>> s = new Stack<>();
     if (root == null){
        return result;  
     }

     Queue<TreeNode> q = new LinkedList<>();
     q.offer(root);
    List<Integer> tmp;   
     while(!q.isEmpty()){
        int size = q.size();
        tmp = new ArrayList<>();
        for (int i = 0; i < size; i++ ){
            TreeNode n = q.poll();
            tmp.add(n.val);
            if(n.left != null){
                q.offer(n.left);
            }
            if(n.right != null){
                q.offer(n.right);
            }
        }
        s.push(tmp);
     }

     while (!s.isEmpty()){
        result.add(s.pop());
      }      
    return result;
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        BinaryTreeLevelOrderTraversalII b = new BinaryTreeLevelOrderTraversalII();
        List<List<Integer>> result = b.levelOrderBottom(node1);
        for (List<Integer> list : result){
            for(Integer i : list){
                System.out.print(i + ",");
            }
            System.out.println();
        }
        System.out.println();
    }
}
