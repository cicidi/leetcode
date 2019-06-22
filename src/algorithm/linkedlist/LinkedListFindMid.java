package algorithm.linkedlist;

import algorithm.model.ListNode;

/*
 * tag
 * lintcode
 * leetcode 876. Middle of the Linked List
 * url https://leetcode.com/problems/middle-of-the-linked-list/
 */


//notice fast跑的速度等于1+2s
//notice slow跑的速度等于s
//notice 所以当1+2s跑到头了 slow 也就在中点了 因为slow跑了s ， 中点刚好也是2s+1/2 也等于s
public class LinkedListFindMid {
    public static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
