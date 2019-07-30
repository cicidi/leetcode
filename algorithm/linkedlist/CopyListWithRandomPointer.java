package linkedlist;

/**
 * @author cicidi on 5/26/19
 */
/*
 * tag
 * lintcode 105. Copy List with Random Pointer
 * https://www.lintcode.com/problem/copy-list-with-random-pointer/my-submissions
 */
public class CopyListWithRandomPointer {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */

    // copy 1->1'->2->2'->3->3'
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        copyNextNode(head);
        copyRanadomNode(head);
        RandomListNode newNode = splitNode(head);
        return newNode;
    }

    public void copyNextNode(RandomListNode head) {
        while (head != null) {
            RandomListNode next = head.next;
            RandomListNode random = head.random;
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.next = next;
            newNode.random = random;
            head.next = newNode;
            head = head.next.next;
        }
    }

    public void copyRanadomNode(RandomListNode head) {
        while (head != null) {
            // check head.next.random is null here
            if (head.next.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }

    }

    // copy 1->1'->2->2'->3->3'
    public RandomListNode splitNode(RandomListNode head) {
        RandomListNode newNode = head.next;
        while (head != null) {
            RandomListNode tmp = head.next;
            head.next = tmp.next;
            if (tmp.next != null) {
                //这里落了tmp
                tmp.next = tmp.next.next;
            }
            head = head.next;
        }
        return newNode;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
