package Chapter2.LinkedLists.Exercise1RemoveDubs;

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
        if (head.Next == null) return;
        HashSet<Integer> set = new HashSet<>();
        Node previous = null;
        while (head != null) {
            if (set.contains(head.Data)) {
                previous.Next = head.Next;
            } else {
                set.add(head.Data);
                previous = head;
            }
            head = head.Next;
        }
    }

    private static class Node {
        public Node(int data) {
            Data = data;
        }

        public Node Next;
        public int Data;
    }

    public static void main(String[] args) {
        var node = new Node(1);
        node.Next = new Node(2);
        node.Next.Next = new Node(3);
        node.Next.Next.Next = new Node(3);
        node.Next.Next.Next.Next = new Node(4);
        removeDuplicates(node);
        System.out.println(node.Data);
    }
}
