public class LinkedListFindMid {


	public static ListNode findMid (ListNode head){
		Node slow=head;

   	
	// lintCode 用的是head.next , 这样的结果就是在偶数是，  mid =n/2   
        
        // 这个结果  mid =n/2  + 1
		Node fast=head.next;
		while (slow !=null || fast.next!=null){
			
			slow = slow.next;
			fast = fast.next.next;
			
		}
		return slow;

	}


}
