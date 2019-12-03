package tree;/*
 * Input: "-4(2(3)(1))(6(5))"
 * Output: {-4,2,6,3,1,5}
 * *
 */


import java.util.HashSet;
import java.util.Set;

public class EqualTree {

    int hasZeroSum;

    Set<Integer> set = new HashSet<>();

    public boolean findEqual(TreeNode node) {

        int sum = dfs(node);

        if (sum % 2 != 0) {
            return false;
        }
        if (sum == 0) {
            return hasZeroSum > 0;
        }
        return set.contains(sum / 2);
    }


    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);
        set.add(left);
        set.add(right);
        int sum = left + right + node.val;

        if (sum == 0) {
            hasZeroSum++;
        }
        return sum;
    }
}
