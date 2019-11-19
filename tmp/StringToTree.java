/*
 * Input: "-4(2(3)(1))(6(5))"
 * Output: {-4,2,6,3,1,5}
 * *
*/


public class EqualTree{

	int hasZeroSum;

	Set<Integer> set = new HashSet<>();
	public void findEqual(){

		int sum = dfs(node);

		if (sum % 2 !=0){
			return false;
		}
		if (sum == 0){
			return hasSum> 0 ;
		}
		return set.has(sum/2);
	}


	public int dfs(TreeNode node){
		if (node == null ){
			return 0;
		}

		int left = dfs(node.left);
		int right = dfs(node.right);
		set.add(left);
		set.add(rigjt);
		int sum = left.val + right.val + node.val;

		if (sum == 0){
			hasZeroSum ++;
		}
		return sum;
	}	
}
