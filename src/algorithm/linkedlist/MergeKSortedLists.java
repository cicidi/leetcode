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
 *
 * 三种解法
 * https://www.jiuzhang.com/solution/merge-k-sorted-lists/

解法1 也是最简单的 已经是 若干的ListNode 头 就是要把这些listnode 头都放在queue 里面然后不断打开，不断的让他们
        在queue里面自己排序，然后我只负责每次不断打开新队列里面的的ListNode
解法2，和解法三在merge 2 node上是一样的， 只不过解法2 用了merge sort 的思想， 用recursion   check if (start< mid) 然后一直找到连个单独的node 然后merge
解法3 把一直到ListNode 头两两merge merge 两个头的方程不难 但是要多联系几次， merge 完以后把merge 好的头，要放到 最开始给的头里面，
        这样的好处是不浪费内存
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

    public ListNode merge2Node(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if (a != null) {
            tail.next = a;
        }
        if (b != null) {
            tail.next = b;
        }
        return dummy.next;
    }
}
