/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (41.23%)
 * Total Accepted:    179.7K
 * Total Submissions: 427.6K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * 
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 *
 *
 * analysis
 *
 * pre: convert array to map
 * inMap
 * postMap
 *
 * 1. find the root of the tree, the root is
 *      Iroot = postArr.length - 1)
 *      rootVal = postArr[Iroot];
 * 2. the post[Iroot - 1] if inorder value of post[Iroot - 1] > Iroot.indorder. this is the right node. otherwise it is left node.
 * 2. Inode = Iroot - 1
 *    nodeVal = postArr[Inode]
 *    if (inMap.get[nodeVal] > inMap.get[rootVal]  then this node is the right node
 *          and the first node which index is less than Iroot, is the left node
 *    from the Iroot , go look at left, find the firstNode who in inorder is on left side or  iRoot, is the left node.  and use dfs keep seach      
*                          
 * 
 * Return the following binary tree:
 * 
 *  9 , 3 ,20 
 *  9, 20 ,3
 *  3, 20
 *  20, 3
 *  
 * ⁠     3
 * ⁠  /    \
 * ⁠ 9      20
 * ⁠/  \    /  \
 * 6    8  15   7
 * 
 *  6   9 ,8   3 ,  15, 20, 7 
 *  6   8, 9,  15,  7,  20, 3
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> iMap = convert(inorder); 
        Map<Integer, Integer> pMap = convert(postorder);
        return find(inorder, postorder, iMap, pMap, 0, inorder.length - 1);
    }

    public TreeNode find(int[] iArr, int[] pArr, Map<Integer, Integer> iMap, Map<Integer, Integer> pMap, int i, int j){
       if (i == j){
            return new TreeNode(pArr[j]);
       }
       int rootVal = pArr[j];
       int prev = pArr[j - 1];
       TreeNode root = new TreeNode(rootVal);
       
       if (pMap.get(prev) < iMap.get(rootVal)){
            root.left = find(iArr, pArr, iMap, pMap, i ,j - 1);
       }else{
           int index = j - 1;
           while (i < index){
                if (pMap.get(prev[index]) < iMap.get(rootVal)){
                    root.left = find(iArr, pArr, iMap, pMap, i, index);
                    break;
                }else{
                    index -- ;
                }
           } 
           root.right= find(iArr, pArr, iMap, pMap, index + 1, j - 1);
       }
       return root;
    }

    public Map<Integer,Integer> convert(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            map.put(arr[i], i);
        }
        return map;
    }
}
