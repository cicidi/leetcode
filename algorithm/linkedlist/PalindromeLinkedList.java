package linkedlist;

import model.ListNode;

/**
 * @author cicidi on 5/26/19
 */

/*
  * tag
  * lintcode 223. Palindrome Linked List
  * https://www.lintcode.com/problem/palindrome-linked-list/description
  */

/*
steps
1 make a copy  每一个new 都要新的memory
2。 reverse node  revert 同时拿到 size
3。 start 和end for loop 跑size 的一半 就够了
* */
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
        ResultType pair = reverse(head);  //这个reverse 一般其实就够了  但是要用到find mid of linkedlist
        ListNode end = pair.node;
        for (int i = 0; i <= pair.size / 2; i++) {// notice 这个地方要用 1/2 因为palindrmoe 之比较一半，
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
