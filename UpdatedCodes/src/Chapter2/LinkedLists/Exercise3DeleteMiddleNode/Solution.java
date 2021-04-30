package Chapter2.LinkedLists.Exercise3DeleteMiddleNode;

/**
 * Delete Middle Node: Implement an algorithm to delete a node
 * <br> in the middle (i.e., any node but
 * <br> the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
 * that node.
 */
public class Solution {
    // given the head
    private static void deleteMiddleAssumption(Node head) {
        if (head == null) return;
        Node fast = head;
        Node slow = head;
        while (slow.Next != null && fast.Next != null) {
            slow = slow.Next;
            fast = fast.Next.Next;
        }

        // slow hit the middle;
        fast = head;
        slow = slow.Next;
        while (slow.Next != null) {
            fast = fast.Next;
            slow = slow.Next;
        }
        fast.Next = fast.Next.Next;
    }

    private static boolean deleteMiddle(Node node) {
        if (node == null || node.Next == null)
            return false;
        Node next = node.Next;
        node.Data = next.Data;
        node.Next = node.Next.Next;
        return true;
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
        node.Next.Next.Next = new Node(4);
        node.Next.Next.Next.Next = new Node(5);
        deleteMiddleAssumption(node);;
        System.out.println(node.Data);
    }
}
