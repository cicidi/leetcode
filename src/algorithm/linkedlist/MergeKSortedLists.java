package algorithm.linkedlist;

import algorithm.model.ListNode;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author cicidi on 5/26/19
 */

/*
  * tag
  * lintcode 104. Merge K Sorted Lists
  * https://www.lintcode.com/problem/merge-k-sorted-lists/my-submissions
  */
public class MergeKSortedLists {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        PriorityQueue<ListNode> queue = new PriorityQueue<>((x, y) -> x.val - y.val);
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;
        while (!queue.isEmpty()) {
            ListNode node = queue.remove();
            current.next = node;
            if (current == null) {
                System.out.println(current);
            }
            System.out.println(current.val);
            current = node;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return dummyNode.next;

    }
}
