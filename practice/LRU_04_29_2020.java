public class LRU {
    Map<String, Node> keyToPrev = new HashMap<>();
    Node dummy;
    Node tail;
    int limit = 10;

    public LRU(int limit) {
        this.limit = limit;
        dummy = new Node();
        dummy.next = tail;
    }

    public void add(Node node) {
        if (keyToPrev.containsKey(node.key)) {
            return;
        }
        if (keyToPrev.size() < limit) {
            tail.next = node;
            keyToPrev.put(node.key, tail);
            tail = node;
        } else {
            Node firstNode = dummy.next;
            keyToPrev.remove(firstNode.key);
            firstNode = node;
            mapToPrev.put(node.key, dummy);
            moveToTail(node.key);
        }
    }

    public Node get(String key) {
        Node prev = keyToPrev.get(key);
        if (prev == null) {
            return null;
        } else {
            moveToTail(key);
            return tail;

        }

    }

    public void moveToTail(String key) {
        Node prev = keyToPrev.get(key);
        Node cur = prev.next;
        prev.next = cur.next;
        keyToPrev.put(prev.next.key, prev);

        tail.next = cur;
        keyToPrev.put(key, tail);
        tail = cur;

    }
}

class Node {
    String key;
    int val;
}