package Chapter2.LinkedLists.ReverseLinkedList;

import Chapter2.LinkedLists.Node;

public class Solution {
    public static void main(String[] args) {
        var root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        deleteNodeFromAList(root, 1);
    }

    public static void printReverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node prev = null;
        var current = head;
        while (current != null) {
            var forward = current.next;
            current.next = prev;
            prev = current;
            current = forward;
        }

        while (prev != null) {
            System.out.println(prev.data);
            prev = prev.next;
        }
    }

    public static void deleteNodeFromAList(Node head, int data) {
        if (head.data == data) {
            head = head.next;
            return;
        }

        while (head != null) {
            if (head.next != null && head.next.data == data) {
                head.next = head.next.next;
                break;
            }
            head = head.next;
        }
    }

    public static void reverse(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node prev = null;
        var current = head;
        while (current != null) {
            var forward = current.next;
            current.next = prev;
            prev = current;
            current = forward;
        }

        while (prev != null) {
            System.out.println(prev.data);
            prev = prev.next;
        }
    }
}
