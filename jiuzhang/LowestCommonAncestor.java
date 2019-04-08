public class LowestCommonAncestor ( TreeNode root, TreeNode node1, TreeNode node2 ){

	
	public TreeNode getAnchestor (TreeNode root, TreeNode node1, TreeNode node2{
		


		//whenn to stop or return ?

		// 1 if root alreay get to node1 or node 2 , then no need to keeo going should return 
		//root not exist so no anchestor
		if (root == null ){
			return null
		}

		// if the root is one or the node 1/ node 2, then return root.
		if (root == node1) {
			return node1;
		}
		if (root == node2)
			return node2;

		// ==== the above if condition can merge to one.
		
		// recursive get anchestor of each left and right 
		TreeNode leftAnchestor = getAnchestor (node.left,node1,node2)
		TreeNode rightAnchestor =getAnchestor(node.right ,node1,node2)


		//2 if left and right both not null , then root is the anchestor is root, 
		if (leftAnchestor !=null & rightAnchestor !=null )
			return root.		
		
		//3, this is backverse travel, and at some point,  if leftAnchestor is not null ,but rightAnchestor is null, which mean 
		//rightNode is null, so common node is the leftAnchestor
		//4, same to right Anchestor 
	
		if (leftAnchestor !=null && rightAnchestor==null){
			return leftAnchestor;
		}
		if (leftAnchestor == null && rightAnchestor!=null){
			return rightAnchestor;	
		}
		
		// leftAnchestor is null ,right Anchestor is null then return null
		return null;
	}
}
