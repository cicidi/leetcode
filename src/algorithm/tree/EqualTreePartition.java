package algorithm.tree;

import algorithm.model.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cicidi on 5/26/19
 * Lintcode 864. Equal Tree Partition
 * url https://www.lintcode.com/problem/equal-tree-partition/description
 */
public class EqualTreePartition {
    /**
     * @param root: a TreeNode
     * @return: return a boolean
     */
    Set<Integer> set = new HashSet<>();
    int hasZeroSum = 0;

    public boolean checkEqualTree(TreeNode root) {
        // write your code here
        int sum = dfs(root);

        System.out.println(sum);
        if (sum % 2 != 0) {
            return false;
        }
        if (sum == 0) {
            return hasZeroSum > 1;
        }
        return set.contains(sum / 2);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        set.add(left);
        set.add(right);
        int sum = root.val + left + right;
        if (sum == 0) {
            hasZeroSum++;
        }
        return sum;
    }
}
