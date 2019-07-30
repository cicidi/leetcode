package tree;

import model.TreeNode;

import java.util.LinkedList;

/**
 * @author cicidi on 5/27/19
 * Lintcode 1101. Maximum Width of Binary Tree
 * url https://www.lintcode.com/problem/maximum-width-of-binary-tree/description
这道题目只需要对二叉树进行一次遍历即可. (DFS/BFS都可以)

首先你要明确距离的定义, 是这一层两端的节点在对应的满二叉树中的距离. 我们可以在遍历的过程中维护每个节点在满二叉树的这一层中的下标:

如果一个节点的下标是 idx, 那么它的左子节点的下标就是 idx * 2, 它的右子节点的下标就是 idx * 2 + 1.

我们记录下每一层出现的最大的和最小的下标即可得到这一层的宽度, 然后在所有层的宽度中取最大值即可.

(这道题目节点的 val 属性是没有用的)

样例1的树:

1
/   \
3     2
/ \     \
5   3     9
对应的满二叉树(以下标代替 val):

0
/   \
0     1
/ \   / \
0   1 2   3
以下标代替 val :

0
/   \
0     1
/ \     \
0   1     3
最宽的是第3层, 0 和 3 之间的长度为 4

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
