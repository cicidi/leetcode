/*
 *Description
中文
English
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

This problem is the extention of House Robber and House Robber II

Have you met this question in a real interview?  
Example
Example1

Input:  {3,2,3,#,3,#,1}
Output: 7
Explanation:
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
  3
 / \
2   3
 \   \ 
  3   1
Example2

Input:  {3,4,5,1,3,#,1}
Output: 9
Explanation:
Maximum amount of money the thief can rob = 4 + 5 = 9.
    3
   / \
  4   5
 / \   \ 
1   3   1
 * */

class HouseRobberIII{
    public int rob(TreeNode root){
     return helper(root, false);
    }


    public static void main(String[] args){
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(4);
        TreeNode root3 = new TreeNode(5);
        TreeNode root4 = new TreeNode(1);
        TreeNode root5 = new TreeNode(3);
        TreeNode root6 = new TreeNode(1);
      
        root1.left = root2;
        root1.right = root3;

        root2.left= root4;
        root2.right = root5;

        root3.right = root6;
        
        HouseRobberIII hs = new HouseRobberIII();
        System.out.println(hs.rob(root1));
    }
    // 要把 picked 改一下， 改成canPickRoot  这道题就清晰了， lastPick并不能决定是否能够pickRoot
    public int helper(TreeNode root, boolean picked){
        if (root == null){
            return 0;
        }

        int result = 0;
        if (!picked){
            result = Math.max(root.value + helper(root.left, true) + helper(root.right, true),
              helper(root.left, false) + helper(root.right, false));
        }else{
            result = Math.max(helper(root.left,false), helper(root.left, true)) + Math.max(
              helper(root.right,false), helper(root.right,true));
        }
       return result; 
    }
}

class TreeNode{
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}
