public class Solution{

	public ArrayList<Integer> preorderTraversal (TreeNode node){
		ArrayList<Integer> result=new ArrayList<Integer>();
		traversal(node, result);
		return result;
	}	

	public void traversal (TreeNode root, ArrayList<Integer> result){
	
		if (root==null){
			return; 
		} else{
			result.add (root.value);
			traversal(root.left, result);
			traversal(root.left, result);
		}
	}
}

public class Solution {
	public ArrayList<Integer> preorderTraversal (TreeNode node){
		return  traversal(TreeNode node);
	}

	public List<ArrayList> traversal(TreeNode root){

		// 把这句话放在这里，因为上一层会用list.addAll 的方式加子树的result ，空值不会被加进去
		// 而且 如果是null 的话就报错了
		ArrayList<Integer> result = new ArrayList<>();
		if (root == null ){
			return result; 
		}else{
			ArrayList<Integer> left= traversal(root.left); 
			ArrayList<Integer> right= traversal(root.right); 
			result.add(root.value);
		       	result.addAll(left);
			result.addAll(right);
		
			return result;

		}

	}
}
