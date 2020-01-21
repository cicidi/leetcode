/*
 * @lc app=leetcode id=82 lang=golang
 *
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (34.22%)
 * Total Accepted:    211.3K
 * Total Submissions: 609.3K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 *
 * Example 2:
 *
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 *
 *
 */

/**
 * Definition for singly-linked list.
 */

package linkedlist

import (
	"fmt"
	"github.com/cicidi/leetcode-WIP/algorithm/model"
	"math"
	_ "github.com/cicidi/leetcode-WIP/algorithm/model"
)

func deleteDuplicates82(head *model.ListNode) *model.ListNode {
	var resultNode = &model.ListNode{Val: math.MinInt32}
	var prev = &model.ListNode{Val: math.MinInt32}
	var ndNode *model.ListNode

	for head != nil {
		ep := false // equal prev
		en := false // equal next
		if head.Val == prev.Val {
			ep = true
		}
		if head.Next != nil && head.Val == head.Next.Val {
			en = true
		}

		if !ep && !en {
			if ndNode == nil {
				ndNode = &model.ListNode{Val: head.Val}
				resultNode.Next = ndNode
			} else {
				ndNode.Next = &model.ListNode{Val: head.Val}
				ndNode = ndNode.Next
			}
		}
		prev = head
		head = head.Next
	}

	return resultNode.Next
}

func main() {
	node1 := &model.ListNode{Val: 1}
	node2 := &model.ListNode{Val: 2}
	node3 := &model.ListNode{Val: 3}
	node4 := &model.ListNode{Val: 3}
	node5 := &model.ListNode{Val: 4}
	node6 := &model.ListNode{Val: 4}
	node7 := &model.ListNode{Val: 5}

	node1.Next = node2
	node2.Next = node3
	node3.Next = node4
	node4.Next = node5
	node5.Next = node6
	node6.Next = node7

	fmt.Println(deleteDuplicates82(node1))
}

/*
 1 2 3 3 4 4 4 5

*/
