/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/

public class LRUCache {
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;
    private int capacity;
    
    public LRUCache(int capacity) {
        cache = new HashMap<Integer, Node>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        update(node);
        return node.val;
    }
    
    public void set(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            if (cache.size() == capacity) {
                cache.remove(tail.key);
                dumpTail();
            }
            node = new Node(value, key);
            addToHead(node);
        } else {
            node.val = value;
            update(node);
        }
        cache.put(key, node);
    }
    
    private void dumpTail() {
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail.prev.next = null;
            tail = tail.prev;
        }
    }
    private void addToHead(Node node) {
        if (head == null) {
            head = node;
            tail = head;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }            
    
    private void update(Node node) {
        if (node == head) {
            return;
        }
        if (node == tail) {
            node.prev.next = null;
            tail = node.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.next = head;
        head.prev = node;
        node.prev = null;
        head = node;
    }
    
    private class Node {
        public int val;
        public int key;
        public Node prev;
        public Node next;
        
        public Node(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }
}