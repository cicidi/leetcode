package main
/**
* @author cicidi on 5/26/19
*/


/*
* tag
* lintcode 73. Construct Binary Tree from Preorder and Inorder Traversal
* https://www.lintcode.com/problem/construct-binary-tree-from-preorder-and-inorder-traversal/description
*/

import "fmt"

func buildTree (preorder []int, inorder []int) *TreeNode {
	// write your code her
	if (len(preorder)!=len(inorder) || (len(preorder)==1 &&preorder[0]==0)){
		return nil;
	}

	length := len(preorder)
	fmt.Printf("length %d \n ", length)
	// fmt.Printf("element %d \n ", preorder[1])
	return create(preorder, inorder, 0, length-1,0, length-1)
}

func create(preorder []int, inorder []int, preStart int, preEnd int, inStart int, inEnd int) *TreeNode {
	fmt.Printf("inStart %d inEnd %d \n", inStart, inEnd)
	if (inStart > inEnd){
		fmt.Println("OPS")
		return nil;
	}
	rootValue := preorder[preStart];
	position :=findPosition(rootValue, inorder, inStart, inEnd)
	root := TreeNode {Val:rootValue}
	size := position-inStart
	root.Left= create(preorder, inorder, preStart+1, preStart+size, inStart, position-1)
	root.Right = create(preorder,inorder, preStart+size+1, preEnd,position+1, inEnd)

	return &root;
}

func findPosition (value int, arr []int, start int, end int) int {
	for i := start; i<=end; i++ {
		if (arr[i]==value){
			return i;
		}
	}
	return -1;
}
