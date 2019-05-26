package algorithm.tree;


import algorithm.model.TreeNode;

public class IsBalanceTree {

    public boolean isBalanceTreeDepth(TreeNode node) {

        return helper(node).isBalance;

    }

    public ResultType helper(TreeNode node) {

        if (node == null) {
            return new ResultType(true, 0);
        }
        ResultType left = helper(node.left);
        ResultType right = helper(node.right);

        if (!left.isBalance || !right.isBalance) {
            return new ResultType(false, -1);
        }

        if (Math.abs(left.depth - right.depth) > 1) {
            return new ResultType(false, -1);
        }

        return new ResultType(true, Math.max(left.depth, right.depth) + 1);

    }

}

class ResultType {
    public boolean isBalance;
    public int depth;

    public ResultType(boolean isBalance, int depth) {

        this.isBalance = isBalance;
        this.depth = depth;

    }
}

