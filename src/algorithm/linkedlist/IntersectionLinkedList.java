package algorithm.linkedlist;

import algorithm.model.ListNode;

/*
  * tag
  * lintcode 380. Intersection of Two Linked Lists
  * https://www.lintcode.com/problem/intersection-of-two-linked-lists/description
  * https://www.jiuzhang.com/solution/intersection-of-two-linked-lists/
  */
public class IntersectionLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        // a1->a2->c1->c2->c3->b1->b2->b3->c1->c2->c3
        // b1->b2->b3->c1->c2->c3->a1->a2->c1->c2->c3
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}