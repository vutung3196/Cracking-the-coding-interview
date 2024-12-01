package Design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {

    }

    Map<Integer, ListNode> keyToNode;
    int capacity;
    ListNode head;

    // not the real tail
    ListNode tail;

    public LRUCache(int capacity) {
        keyToNode = new HashMap<>();
        this.capacity = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }


    // get by key, move a node to the last
    public int get(int key) {
        if (!keyToNode.containsKey(key)) return -1;

        var node = keyToNode.get(key);
        remove(node);
        add(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (keyToNode.containsKey(key)) {
            var oldNode = keyToNode.get(key);
            remove(oldNode);
        }

        ListNode node = new ListNode(key, value);
        keyToNode.put(key, node);
        add(node);
        if (keyToNode.size() > capacity) {
            ListNode toBeDelete = head.next;
            remove(toBeDelete);
            keyToNode.remove(toBeDelete.key);
        }

    }

    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void add(ListNode node) {
        // add to the last of the deque
        ListNode prevEnd = tail.prev;
        prevEnd.next = node;
        node.prev = prevEnd;
        node.next = tail;
        tail.prev = node;
    }

    private class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
