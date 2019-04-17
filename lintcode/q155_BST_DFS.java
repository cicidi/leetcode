public class q155_BST_DFS {

	public static void main (String []args){
	
	
	
	}


	public static void println(Object ... objList ){
	
		for (Object obj: objList) {
			System.out.println (obj);
		}
		System.out.println();
	}

	public getMin(TreeNode head){
	
		if (head == null ){
	              return 0;
		}

		return getMin(head);
	
	}
	public getMin(TreeNode head){
	
		// just for compare left right
		if (head == null ){
			return Integer.MAX_VALUE;
		
		}

		if (head.left == null && head.right== null) {
			return 1;
		}
	
		return Math.min(getMin(head.left) , getMin(head.right))+1;
	}

}
