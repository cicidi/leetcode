package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BinaryTreeLevelOrder {
    public List<Integer> levelOrder(TreeNode node) {
        if (node == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        PriorityQueue<TreeNode> queue = new PriorityQueue<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            List<TreeNode> tmpList = new ArrayList<>();
            while (!queue.isEmpty()) {
                tmpList.add(queue.poll());
            }
            for (TreeNode treeNode : tmpList) {
                result.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }

        }
        return result;
    }

}
