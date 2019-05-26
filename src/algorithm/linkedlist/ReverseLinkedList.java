package algorithm.linkedlist;
/*
* tag
* leetcode 206. Reverse Linked List
* https://leetcode.com/problems/reverse-linked-list/
*/


import algorithm.model.ListNode;

public class ReverseLinkedList {
    public static ListNode revert(ListNode node) {

        ListNode prev = null;

        while (node != null) {
            // 仅仅是为了记录下一个 node
            ListNode tmp = node.next;
            //这两行 做了实际的翻转
            node.next = prev;
            // 在最外层保留了一个prev 记录用
            prev = node;

            // 让head 继续往下走
            node = tmp;
        }
        return prev;
    }

}
