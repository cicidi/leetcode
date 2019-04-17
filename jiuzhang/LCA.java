public class LCA {

	public getLCA (TreeNode root, TreeNode A , TreeNode B){
	
		if(root== null ){
			return null;
		}
		
		//this is very important
		// only if root =A or B can keep some value, otherwise only returnn to upper level
		if (root == A || root ==b){
			return root;
		}

		TreeNode left = getLCA(root.left,TreeNode A, TreeNode B);
		TreeNode right = getLCA(root.right,TreeNode A, TreeNode B);

		if (left!=null && right !=null){
			return root;
		}

		if (left!=null){
		
			return left;
		}
		if (right!=null){
		
			return right;
		}
		// if left and right both null;  which mean is any of the branch 
		// does n't have A or B, clean this branch.
		return null;	
	}
}
