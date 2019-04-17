public class IsBalanceTree {

	public boolean isBalanceTreeDepth (TreeNode node){

		return helper(node).isBalanced;

	}

	public ResultType helper(TreeNode node){

		if (node==null){
			return new Result(true,0);
		}
		ResultType left=helper(node.left);
		ResultType right=helper(node.right);

		if (!left.isBalance ||! right.isBalance){
			return new Result(false,-1);
		}

		if (Math.abs(left.depth-right.depath)>1){
			return new Result (fasle,-1)
		}

		return new Result(true,Math.max(left.depth,right.depth)+1);

	}


}

public class ResultType {
	public boolean isBalance;
	public int depth;

	public ResultType( boolean isBalance, int depth){

		this.isBalancer=isBalance;
		this.depth = depth;

	}
}
