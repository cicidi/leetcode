public class LinkedListCycle {



	public boolean hasCycle(ListNode head){
	
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

		if (head ==null && head.next==null) return null

		//这个地方得是head.next   = = !  
		ListNode fast=head.next;
		ListNode slow=head;	
		while (slow!=fast){
			if(slow==null||fast==null||fast.next==null){
				return false;
			}
			slow=slow.next;
			fast=fast.next.next;
		
		}
		return true;
	}
}
