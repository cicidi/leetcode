package cache;

import java.util.HashMap;
import java.util.Map;

/*
 * tag
 * lintcode 134. LRU Cache
 * url https://www.lintcode.com/problem/lru-cache/description
 * leetcode
 * url


    这道题三个method
    movetail
       给current 换位置要做几件事情
       1.找到current
       3.把他从current 挪到tail 去
                需要条件：1，知道current 之前是谁
                            需要条件。
                                1 通过map 找到current prev
                        2. 谁依赖者current
                                1. current。next 就是他的依赖者
                        3 把依赖者挂在current 的prev上
       4 current 关系清理干净以后吧 current 挂在 tail上
                需要条件 tail。next=currrent
                        current。prev 在map 里面更新
                        tail = current 内存换位置
    get
        1 把get到的current 挪到tail去
        2. 返回current 的值
    set
        新加入一对值要做几件事
        1 如果当前有了key，value mapping 那么就给他们的值换一下就行了， 这里也不需要move tail
        2 如果没有key value mapping 那么就需要
            1 看是否超载 没有的话就直接加，然后把最新的值放到tail去
                tail.next
                在全局map里面注册
                tail 替换成current
            2 如果超载，就需要把dummy 下面的 最前端的remove掉 （其实这里面只需要把那个node 的全局注册里面注销，然后用新的key，value 头换面 再move tail 就行了）
              再把current 加到tail 里面


*/
public class LRUCache {
    private int capacity, size;
    // 4.0.1  who is dummy and then to use dummy
    // dummy 和tail 都是在一开始创建，dummy是整个数据的结构的prev.
    // tail 代表被更新的node
    private ListNode dummy, tail;
    private Map<Integer, ListNode> keyToPrev;


    private void moveToTail(int key) {
        ListNode prev = keyToPrev.get(key);
        ListNode curt = prev.next;
        if (tail == curt) {
            return;
        }


        prev.next = curt.next;
        // 1.2 since prev.next is changed to curt.next
        // so curt.next 's prev should change
        if (prev.next != null) {
            keyToPrev.put(prev.next.key, prev);
        }
        // 2. move curt to tail
        // 2.1 append curt to tail
        tail.next = curt;
        // 2.2 since curt is append to tail
        // tell map
        keyToPrev.put(curt.key, tail);
        // 3. tell the world who is the tail
        tail = curt;
    }

    private int get(int key) {

        if (!keyToPrev.containsKey(key)) {
            return -1;
        }
        moveToTail(key);
        return tail.value;
    }


    private void set(int key, int value) {

        //  if key alreay exist, dont have to remove key, but need to moveKey to tail
        if (keyToPrev.containsKey(key)) {
            ListNode prev = keyToPrev.get(key);
            prev.next.value = value;
            return;
        } else {
            // key not exist before, and need to add new key;
            // 4.1 size < capacity
            if (size < capacity) {
                //
                ListNode curt = new ListNode(key, value);
                // 4.1.1 append newNode to tail
                tail.next = curt;
                // 4.1.2 tell map
                keyToPrev.put(key, tail);

                // 4.1.3 tell the world
                tail = curt;
                // size ++
                size++;
            } else {
                // 4.2 size not enough  remove firstNode
                // 4.2.1 who is the first   ->  dummy
                ListNode first = dummy.next;

                //4.2.3  remove first.key
                keyToPrev.remove(first.key);

                // instead of create new object use "first" object
                //ListNode curt = new ListNode (key,value);
                println("size > capacity: ", key, value);
                first.key = key;
                first.value = value;
                keyToPrev.put(key, dummy);
                println("check first key value -> ", keyToPrev.get(first.key).next.value);
                moveToTail(key);
            }
        }

    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyToPrev = new HashMap<>();
        this.dummy = new ListNode(0, 0);
        this.tail = this.dummy;
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(1);

        cache.set(2, 1);
        println(cache.get(2));
        cache.set(3, 2);
        println(cache.get(2));
        println(cache.get(3));
        println(cache.get(4));

    }


    public static void println(Object... list) {
        for (Object obj : list) {
            System.out.print(obj);
        }
        System.out.println();
    }

    class ListNode {

        public int key, value;
        public ListNode next;


        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

    }

}
