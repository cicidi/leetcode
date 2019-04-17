public class RevertLinkedList {



	public static revert (ListNode node){

		ListNode prev= null;

		while ( head!=null ){
			// 仅仅是为了记录下一个 node 
			ListNode tmp = head.next;
			//这两行 做了实际的翻转
			head.next = prev;
			// 在最外层保留了一个prev 记录用
			prev = head;

			// 让head 继续往下走
			head = tmp;
		}
		return prev;
	}


}
