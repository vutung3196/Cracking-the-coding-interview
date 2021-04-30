package Chapter2.LinkedLists.Exercise1RemoveDubs;

import Chapter2.LinkedLists.Node;

import java.util.HashSet;

/**
 * 2.1 Remove Dups! Write code to remove duplicates
 * <br> from an unsorted linked list.
 */
public class Solution {
    /**
     * Time and space complexity: O(n)
     *
     * @param head: head node
     */
    private static void removeDuplicates(Node head) {
        if (head.next == null) return;
        HashSet<Integer> set = new HashSet<>();
        Node previous = null;
        while (head != null) {
            if (set.contains(head.data)) {
                previous.next = head.next;
            } else {
                set.add(head.data);
                previous = head;
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        var node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(4);
        removeDuplicates(node);
        System.out.println(node.data);
    }
}
