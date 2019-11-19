//import java.util.*;
//public class BinaryTreeMaximumPathSum {
//	public static void main (String[] args){
//
//	}
//
//	public ResultType helper(TreeNode treeNode){
//		if (treeNode == null){
//			return new ResultType(0,Integer.MIN_VALUE);
//		}
//
//		ResultType left = helper(treeNode.left);
//		ResultType right= helper(treeNode.right);
//
//		int singlePath = Math.max(left.singlePath, right.singlePath) + treeNode.val;
//		singlePath = Math.max(singlePath, 0);
//
//		int maxPath = Math.max(left.mixPath, right.mixPath)
//		iny mixPath = Math.max(left.singlePath + right.singlePath + treeNode.value, singlePath);
//		return new ResultType(singlePath, mixPath);
//	}
//}
//class ResultType {
//	int singlePath;
//	int mixPath;
//
//	public ResultType(int singlePath, int mixPath){
//		this.singlePath = singlePath;
//		this.mixPath = mixPath;
//	}
//}
//
//class TreeNode {
//    public int val;
//    public TreeNode left, right;
//
//    public TreeNode(int val) {
//        this.val = val;
//        this.left = this.right = null;
//    }
//}
