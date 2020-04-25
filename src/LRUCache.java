import java.util.HashMap;
import java.util.Map;

//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
//get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
//The cache is initialized with a positive capacity.
//
//Follow up:
//Could you do both operations in O(1) time complexity?
//
//Example:
//
//LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.put(4, 4);    // evicts key 1
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4
//
public class LRUCache {

    private final int capacity;
    private Map<Integer, Node> cache;
    private Node dummyHead = new Node();
    private Node tail = new Node();


    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        dummyHead.next = tail;
        dummyHead.prev = null;
        tail.prev = dummyHead;
        tail.next = null;
    }

    public void put(Integer key, Integer val) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = val;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, val);
            addFirst(newNode);
            cache.put(key, newNode);
            if (cache.size() > capacity) {
                Integer toRemove = removeLast();
                cache.remove(toRemove);
            }
        }
    }

    public Integer get(Integer key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        moveToHead(node);
        return node.val;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addFirst(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addFirst(Node n) {
        n.prev = dummyHead;
        n.next = dummyHead.next;

        n.next.prev = n;
        n.prev.next = n;
    }

    private Integer removeLast() {
        Integer key = tail.prev.key;
        removeNode(tail.prev);
        return key;
    }

    class Node {

        Node prev;
        Node next;
        Integer key;
        Integer val;

        public Node() {
        }

        public Node(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);
    }
}
