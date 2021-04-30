package Chapter2.LinkedLists.Exercise4Partition;

import Chapter2.LinkedLists.Node;

/**
 * Partition list <br>
 * Given the head of a linked list and a value x, <br>
 * partition it such that all nodes less than
 * <br> x come before nodes greater than or equal to x.
 * <br>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */
public class Solution {
    public static Node partition(Node head, int x) {
        Node before_head = new Node(0);
        Node before = before_head;
        Node after_head = new Node(0);
        Node after = after_head;
        while (head != null) {
            if (head.data < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = after_head.next;
        return before_head.next;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(4);
        node.next.next = new Node(2);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(9);
        var result = partition(node, 3);
    }
}
