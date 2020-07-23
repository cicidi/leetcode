/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
 *
 * https://leetcode.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (37.49%)
 * Total Accepted:    218.6K
 * Total Submissions: 570.7K
 * Testcase Example:  '[4,2,1,3]'
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * 
 * 
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

package mergeSort;

class SortList{

    public static void main(String[] args){
      ListNode node1 = new ListNode(-1);
      ListNode node2 = new ListNode(5);
      ListNode node3 = new ListNode(3);
      ListNode node4 = new ListNode(4);
      ListNode node5 = new ListNode(0);

      node1.next = node2;
      node2.next = node3;
      node3.next = node4;
      node4.next = node5;
      SortList sl = new SortList(); 
      ListNode result = sl.sortList(node1);
      while(result !=null){
        System.out.println(result.value);
        result = result.next;
      }
    }
    public ListNode sortList(ListNode head) {
       return mergeSort(head);              
    }

    public ListNode findMiddle(ListNode n) {
      //这个自己画一下就会发现，如果fast = n 的话，那么mid 会在中间的下一个node上
      ListNode slow = n;
      ListNode fast = n.next;
      while(slow != null && fast!= null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
      }
      System.out.println(slow.value);
      return slow;
    }

    public ListNode mergeSort(ListNode n){
      if (n == null || n.next == null){
        return n;
      }
      ListNode mid = findMiddle(n);
      ListNode right = mergeSort(mid.next);
      mid.next = null;
      ListNode left = mergeSort(n);
      
      return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right){
      ListNode head = new ListNode(0);
      ListNode dummy= new ListNode(0);
      head.next = dummy;
      while(left != null && right !=null){
        if (left.value < right.value){
          dummy.next = left;
          left = left.next;
        }else{
          dummy.next = right;
          right = right.next;
        }
        dummy = dummy.next;
      }
      while (left !=null){
        dummy.next = left;
        dummy = dummy.next;
        left = left.next;
      }
      while (right != null){
        dummy.next = right;
        dummy = dummy.next;
        right = right.next;
      }
      return head.next.next;
    }
}
class ListNode{
   public ListNode next;
   public int value;

   public ListNode(int value){
    this.value = value;
   }

}
