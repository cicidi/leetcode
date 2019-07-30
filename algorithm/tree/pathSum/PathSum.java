package algorithm.tree.pathSum;

import algorithm.model.TreeNode;

public class PathSum {

    // public boolean hasPathSum(TreeNode root, int sum){


    // 	if (root==null){
    // 		return false;
    // 	}

    // 	int total=root.val;
    // 	return helper(root.left,  total,  sum) || helper(root.right, total, sum);
    // }

    // public boolean helper(TreeNode root, int total , int sum){

    // 	if (root == null ){
    // 		return false ;
    // 	}
    // 	total += root.val;
    // 	if (total == sum){
    // 		return true;
    // 	}
    // 	return helper (root.left, total, sum) ||  helper (root.right,total,sum);
    // }

    // this guys works. the above doesnt work
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {

            return sum == root.val;
        }
        sum -= root.val;
        System.out.println(sum);
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);

    }

}
