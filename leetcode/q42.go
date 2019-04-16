package main

import "fmt"
import "github.com/golang-collections/collections/stack"

func main() {
	fmt.Println("vim-go")
	leftNode := TreeNode{1, nil, nil}
	rightNode := TreeNode{2, nil, nil}
	treeNode := TreeNode{3, leftNode, RightNode}
	fmt.Println(inorderTraversal(treeNode))
}

/**
 * Definition for a binary tree node.
 */
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func inorderTraversal(root *TreeNode) []int {

	/*create a list*/
	result := []int{}
	/*create a stack last in first out*/
	stack := statck.New()
	/*while loop , loop left tree then loop right until the last node in stack which is root done*/

	cur := root
	for stack.Len() > 0 || cur != nil {
		for cur != nil {
			stack.Push(cur)
			cur = cur.left
		}

		cur = stack.Pop()
		result.add(cur)
		cur = cur.right()
	}
	return result
}
