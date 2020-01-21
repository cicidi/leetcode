/*
 * @lc app=leetcode id=61 lang=golang
 *
 * [61] Rotate List
 *
 * https://leetcode.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (28.06%)
 * Total Accepted:    225.3K
 * Total Submissions: 793.9K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, rotate the list to the right by k places, where k is
 * non-negative.
 *
 * Example 1:
 *
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 *
 *
 * Example 2:
 *
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 *


 * Input: 1->2->3   / tmpNoee ->  4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 */

//Definition for singly-linked list.

package linkedlist

import (
	"fmt"
	"github.com/cicidi/leetcode-WIP/algorithm/model"
)
import _ "github.com/cicidi/leetcode-WIP/algorithm/model"

func rotateRight_2(head *model.ListNode, k int) *model.ListNode {
	var l int
	copyN := head
	tmpHead := model.ListNode{0, head}
	var last *model.ListNode
	for head != nil {
		last = head
		head = head.Next
		l++
	}
	last.Next = copyN
	fmt.Println("lengh {}", l)
	for l = l - k; l > 0; l-- {
		if l == 1 {
			next := copyN.Next
			copyN.Next = nil
			tmpHead.Next = next
			fmt.Println("break {}", tmpHead.Next)
			break
		}
		copyN = copyN.Next
	}
	return tmpHead.Next
}

func main() {
	n3 := model.ListNode{3, nil}
	n2 := model.ListNode{2, &n3}
	n1 := model.ListNode{1, &n2}
	node := rotateRight(&n1, 1)
	fmt.Println(node)
	fmt.Println(node.Next)
	fmt.Println(node.Next.Next)
}
