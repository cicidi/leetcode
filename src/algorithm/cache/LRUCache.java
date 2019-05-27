package algorithm.cache;

import java.util.*;
/*
  * tag
  * lintcode 134. LRU Cache
  * url https://www.lintcode.com/problem/lru-cache/description
  * leetcode
  * url
  */
public class LRUCache {



	public static void main (String[] args ){
	
	LRUCache cache= new LRUCache (1);

	cache.set(2,1);	
	println(cache.get(2));
	cache.set(3,2);
	println(cache.get(2));
	println(cache.get(3));
	println(cache.get(4));

	}


	public static void println (Object... list){
		for (Object obj:list){
			System.out.print(obj);
		}
		System.out.println();
	}
	class ListNode{
	
		public int key,value;
		public ListNode next;


		public ListNode(int key, int value){
			this.key = key;
			this.value = value;
			this.next=null;	
		}
	
	}



	private int capacity,size;

	private ListNode dummy,tail;
	
	private Map<Integer,ListNode> keyToPrev;



	public LRUCache (int capacity) {
	
	
		this.capacity = capacity;
		this.keyToPrev = new HashMap<Integer,ListNode>();
		this.dummy = new ListNode(0,0);
		// 4.0.1  who is dummy and then to use dummy
		// dummy is created at the begin, as new node is added to cache. dummy is the prev for the first node!!! .
		this.tail = this.dummy;
	}

	private void moveToTail(int key){
		
		ListNode prev = keyToPrev.get(key);
		ListNode curt = prev.next;

		if (tail == curt) {
			return; 
		}
		// curt pick out key,and value, connect  curt.prev, and curt.next
		// 1.1 change the relationship of prev and curt
		prev.next=curt.next;
		

		// 1.2 since prev.next is changed to curt.next
		// so curt.next 's prev should change
		if (prev.next!=null) {
		
			keyToPrev.put( prev.next.key, prev);
		}
		

		// 2. move curt to tail
		// 2.1 append curt to tail
		tail.next = curt;
		
		// 2.2 since curt is append to tail
		// tell map
		keyToPrev.put (curt.key, tail);

		// 3. tell the world who is the tail
		tail = curt;	
	}

	private int get (int key){
	
		if (! keyToPrev.containsKey(key)) {
			return -1 ;
		}
		
		// 5.1 move to tail 		
		moveToTail(key);
		// 5.2 return tail
		return tail.value;
	}


	private void set(int key, int value){
		
		//  if key alreay exist, dont have to remove key, but need to moveKey to tail
		if (keyToPrev.containsKey(key))  {
			ListNode prev = keyToPrev.get(key);
			prev.next.value = value;
			return ;
		} else {
		// key not exist before, and need to add new key;
		// 4.1 size < capacity 
			if ( size < capacity ){

				//
				ListNode curt = new ListNode (key, value );
				// 4.1.1 append newNode to tail	
				tail.next = curt;
				// 4.1.2 tell map 
				keyToPrev.put (key, tail);

				// 4.1.3 tell the world
				tail=curt;
				// size ++
				size++;
			}else {
				// 4.2 size not enough  remove firstNode
				     	// 4.2.1 whois the first   ->  dummy
					ListNode first = dummy.next;
				
					//4.2.3  remove first.key
					keyToPrev.remove(first.key);

					// instead of create new object use "first" object 
					//ListNode curt = new ListNode (key,value);
					println ("size > capacity: ",key,value);	
					first.key = key;
					first.value = value;
					keyToPrev.put(key, dummy);
					println ("check first key value -> ",keyToPrev.get(first.key).next.value);
					moveToTail(key);		
				}
		}

	}

}
