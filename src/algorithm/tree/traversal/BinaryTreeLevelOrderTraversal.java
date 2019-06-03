package algorithm.tree.traversal;

import algorithm.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cicidi on 5/26/19
 */

/*
  * tag
  * lintcode 69. Binary Tree Level Order Traversal
  * https://www.lintcode.com/problem/binary-tree-level-order-traversal/description
  */
public class BinaryTreeLevelOrderTraversal {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        if (root == null)
            return null;

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> tmp = new ArrayList<TreeNode>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                tmp.add(node);
            }
            List<Integer> valueList = new ArrayList<>();
            for (TreeNode node : tmp) {
                valueList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(valueList);
        }
        return result;
    }
}
