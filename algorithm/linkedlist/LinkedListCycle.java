package linkedlist;

import model.ListNode;

/*
 * tag
 * lintcode
 * leetcode 141. Linked List Cycle
 * url https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {


    public boolean hasCycle(ListNode head) {

/*	
        if (head == null ) return null
		ListNode slow= head;
		ListNode fast= head;


		while (fast!=null || fast.next!=null ){
		
			
			if (slow==fast){
				break;
			}
			slow = slow.next;
			fast = fast.next.next	
		}
		return true;
	
	}

*/

        if (head == null && head.next == null) return false;

        //这个地方得是head.next 不然上来不是直接就fast==slow 等了吗  = = !
        ListNode fast = head.next;
        ListNode slow = head;
        while (slow != fast) {
            if (slow == null || fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;

        }
        return true;
    }
}
