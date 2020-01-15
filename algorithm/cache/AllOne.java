package cache;

import java.util.*;

public class AllOne {

    public static void main(String[] args) {
        System.out.println("compiled");

        AllOne all = new AllOne();
        all.inc("a");
        all.inc("a");
        all.inc("a");
        all.inc("b");
        all.inc("b");
        all.inc("c");

        System.out.println(all.getMaxKey());
    }

    public static void println(String s) {
        System.out.println(s);

    }

    public Node max = new Node(0);

    public Node min = new Node(0);

    public Map<Integer, Set<String>> val2Key = new HashMap<>();

    public Map<String, Integer> key2Val = new HashMap<>();

    public String getMaxKey() {
        return getKey(max.val);
    }

    public String getKey(int val) {
        Set<String> set = val2Key.get(val);
        if (set != null && set.size() != 0) {
            Iterator<String> it = set.iterator();
            return it.next();

        } else {
            return "";
        }
    }

    public String getMinKey() {
        return getKey(min.val);
    }

    public void inc(String key) {
        change(key, 1);
    }

    public void dec(String key) {
        change(key, -1);
    }

    public void change(String key, int offset) {
        int val = key2Val.getOrDefault(key, 0);
        Set<String> set1 = val2Key.get(val);
        if (set1 != null) {
            if (set1.contains(key)) {
                set1.remove(key);
            }
        }
        val2Key.put(val, set1); // update val to key

        val += offset;  // update value
        Set<String> set2 = val2Key.getOrDefault(val, new HashSet<String>());
        set2.add(key);

        val2Key.put(val, set2);

        if (offset > 0) {
            swapNode(max);
        }
        if (offset < 0) {
            swapNode(min.prev);
        }

    }

    public void swapNode(Node root) {
        if (root != null && root.next != null && root.val < root.next.val) {
            Node prev = root.prev;
            Node NofN = root.next.next;
            Node curr = root;
            root = root.next;
            root.next = curr;
            root.prev = prev;
            root.next.next = NofN;
        }
    }

}

class Node {
    Node next;
    Node prev;
    int val;

    public Node(int val) {
        this.val = val;
    }
}

