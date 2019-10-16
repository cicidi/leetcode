package main

import (
	"fmt"
	"leetcode/algorithm/model"
)

/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL*/

/*Steps green
1。 先得倒linkedlist的size
2。 生成一个闭环，
3。 从dummy 开始，找切开的点
4。 把切开点的前一个的Next 变成null
4， 返回切开点
*/
func main() {
	fmt.Println("vim-go")
	node1 := model.ListNode{}
	node2 := model.ListNode{Val: 2}
	node3 := model.ListNode{Val: 3}
	node4 := model.ListNode{Val: 4}
	node5 := model.ListNode{Val: 5}
	node1.Next = &node2
	node2.Next = &node3
	node3.Next = &node4
	node4.Next = &node5

	res := rotateRight(&node1, 2)
	fmt.Sprint(res)
	fmt.Print("done")
}

func rotateRight(head *model.ListNode, k int) *model.ListNode {
	if head == nil || k == 0 {
		return head
	}
	size := getSize(head)
	k = k % size // question 为什么这里用余数  貌似直接减法就可以了把
	var dummy = model.ListNode{Val: 0}
	dummy.Next = head
	var current = head
	//var dummy = &head
	for i := 0; i < size-1; i++ {
		current = current.Next
	} // notice
	current.Next = dummy.Next

	var moveNode = dummy.Next
	for i := 0; i < size-k-1; i++ {
		moveNode = moveNode.Nex
	}
	result := moveNode.Next
	moveNode.Next = nil
	return result

}
func getSize(node *model.ListNode) int {
	i := 0
	for node != nil {
		i++
		node = node.Next
	}
	return i
}
