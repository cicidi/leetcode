/*
 * @lc app=leetcode id=83 lang=golang
 *
 * [83] Remove Duplicates from Sorted List
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (43.47%)
 * Total Accepted:    384.8K
 * Total Submissions: 878.9K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 *
 * Example 1:
 *
 *
 * Input: 1->1->2
 * Output: 1->2
 *
 *
 * Example 2:
 *
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 *
 */
//  Definition for singly-linked list.
package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteDuplicates(head *ListNode) *ListNode {
	var tmpNode = &ListNode{Val: 0}

	var resultNode = &ListNode{Val: 0}
	tmpNode.Next = resultNode
	for head != nil {
		if head.Next != nil && head.Next.Val != head.Val {
			resultNode.Next = &ListNode{Val: head.Val}
			fmt.Println(head.Val)
			fmt.Println(resultNode)
			resultNode = resultNode.Next

		}
		if head.Next == nil {
			resultNode.Next = &ListNode{Val: head.Val}
		}

		head = head.Next
	}
	return tmpNode.Next.Next
}

func main() {

	node1 := &ListNode{Val: 1}
	node2 := &ListNode{Val: 2}
	node3 := &ListNode{Val: 3}
	node4 := &ListNode{Val: 3}
	node5 := &ListNode{Val: 4}
	node6 := &ListNode{Val: 4}
	node7 := &ListNode{Val: 5}

	node1.Next = node2
	node2.Next = node3
	node3.Next = node4
	node4.Next = node5
	node5.Next = node6
	node6.Next = node7

	fmt.Println(deleteDuplicates(node1))
}
