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
        copyRandomNode(head);
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

    public void copyRandomNode(RandomListNode head) {
        while (head != null) {
            // check head.next.random is null here
            if (head.next.random != null) {
                // - question I think this if statement might be wrong. - 1st oct 2019
                //      - I checked this line has no problem - 2nd oct 2019
                //      - Because this method is copying the random node. So should check the random node of
                //      the node which next to current, is not null and go ahead
                head.next.random = head.random.next;// question how can i gurentee
                // head.random is not null?
                // head.next is not null?
            }
            head = head.next.next;
        }

    }

    // copy 1->1'->2->2'->3->3'
    // 这是比较经典的一个方程，如何像拉链一样撕开linked list
    // 第一步， 新建一个要被返回的newNode， 这个node 也是一个head
    // 第二部， 取出第3个node，把这个node 加到前面的Node 后面去
    // 第三部， 让第2个node的next 等于 第四个node
    // 第四部， 让第一个变成他的下一次，起始已经是第三个node开始了
    public RandomListNode splitNode(RandomListNode head) {
        RandomListNode newNode = head.next;
        while (head != null) {
            RandomListNode random = head.next;
            head.next = random.next;
            //我做这道题的时候，这里落了split random 的部分
            if (random.next != null) {
                random.next = random.next.next;
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
