package algorithm.linkedlist;

import algorithm.model.ListNode;

/**
 * @author cicidi on 5/26/19
 */

/*
  * tag
  * lintcode 223. Palindrome Linked List
  * https://www.lintcode.com/problem/palindrome-linked-list/description
  */
public class PalindromeLinkedList {
    /**
     * @param head: A ListNode.
     * @return: A boolean.
     */
    public boolean isPalindrome(ListNode head) {
        // write your code here
        if (head == null)
            return true;


        ListNode copy = clone(head);
        ResultType pair = reverse(head);
        ListNode end = pair.node;
        for (int i = 0; i <= pair.size / 2; i++) {
            // System.out.println(copy);
            // System.out.println(end);
            // System.out.printf("i %d copy: %d end : %d\n",i, copy.val,end.val);
            if (copy.val != end.val) {
                return false;
            } else {
                copy = copy.next;
                end = end.next;
            }
        }
        return true;
    }

    public ResultType reverse(ListNode current) {
        ListNode prev = null;
        int size = 0;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            size++;
            // System.out.printf("prev: %d \n", prev.val);
        }
        current = prev;

        return new ResultType(prev, size);
    }

    public ListNode clone(ListNode node) {
        ListNode copy = new ListNode(node.val);
        ListNode current = copy;
        while (node != null && node.next != null) {
            current.next = new ListNode(node.next.val);
            current = current.next;
            node = node.next;
        }
        return copy;
    }

}


class ResultType {
    public ListNode node;
    public int size;

    public ResultType(ListNode node, int size) {
        this.node = node;
        this.size = size;
    }
}
