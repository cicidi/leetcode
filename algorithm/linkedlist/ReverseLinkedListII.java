package linkedlist;/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (36.15%)
 * Total Accepted:    227.6K
 * Total Submissions: 621.5K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 *
 *
 */

// (0), 1 , 2, ,3 ,4 ,5
//Definition for singly-linked list.
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //ListNode next = null;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;  //0
        dummy.next = head;  // 1

        ListNode current = head;
        for (int i = 1; i < m; i++) {
            System.out.println("i : " + i + " m " + m + " n " + n);
            prev = current;
            current = current.next;
        }
        // prev = 1 
        // current = 2
//        System.out.println("current" + current.val);
        ListNode lastCurrent = current;
        Pair pair = reverse(current, n - m);

        current = pair.current;
        ListNode next = pair.next;
//        System.out.println("lastCurrent" + lastCurrent.val);
//        System.out.println("next " + next.val);
//        System.out.println("current after reverse" + current.val);
        // current = 4
        // next = 5
        prev.next = current;
        lastCurrent.next = next;
        return dummy.next;
    }

    public Pair reverse(ListNode current, int n) {
        int i = 0;
        ListNode next = null;
        ListNode prev = null;
        while (i <= n) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
//            System.out.println("next " + next.val);
            i++;
        }
        current = prev;
        System.out.println("current" + current.val);
        return new Pair(current, next);
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ReverseLinkedListII r = new ReverseLinkedListII();
        ListNode result = r.reverseBetween(node1, 1, 2);
        // ListNode result = node1;
        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
        System.out.println(result.next.next.next.val);
        System.out.println(result.next.next.next.next.val);

    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Pair {
    ListNode current;
    ListNode next;

    public Pair(ListNode current, ListNode next) {
        this.current = current;
        this.next = next;
    }
}

