// comment
//
//             1
//          0     1
//        0  1   2  3
//      0 1 2 3 4 5 6 7
package tree;
import java.util.*;


public class MaximumWidthOfBinaryTree {

    public static void main(String []args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        // n3.right = n6;
        System.out.println(max(n1));
    } 
    public static int max(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int index = 0;
            int start = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                    start = Math.min(start, index);
                    max = Math.max(max, index - start + 1);
                }
                index++;
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                    start = Math.min(start, index);
                    max = Math.max(max, index - start + 1);
                }
                index++;
            }
        }
        return max;
    }
        
}

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
