/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (38.57%)
 * Total Accepted:    186.3K
 * Total Submissions: 476.8K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

public ListNode partition(ListNode head, int x) {
    if (head == null){
        return null;
    }
    ListNode left = new ListNode(0);
    ListNode right = new ListNode(0);

    while (head = head.next) {
        if (head.val >= x){
            right.next = head;
            right = right.next
        }else{
            left.next = head;
            left = left.next;
        } 
        head = head.next
    }
    left.next = right.next;
    right.next = null;
    return left.next;
}
//   1 2 3 2 5     ,   3
