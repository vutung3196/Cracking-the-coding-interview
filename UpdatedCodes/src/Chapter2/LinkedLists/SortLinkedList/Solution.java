package Chapter2.LinkedLists.SortLinkedList;

import Chapter2.LinkedLists.Node;

public class Solution {
    public static void main(String[] args) {
        int[] data = { 12, 2, 1, 15 };

        // creating the head pointer
        Node head = null;

        // constructing the linked list from last to first
        head = new Node(12);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(15);

        head = sort(head);
        var current = head;
        for (int i = 0; i < 4; i++) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static Node sortListInsertion(Node head, Node nextNodeToCompare) {
        Node temp = new Node(-1);
        Node current = temp;
        temp.next = head;
        while (current.next != null && current.next.data < nextNodeToCompare.data) {
            current = current.next;
        }

        nextNodeToCompare.next = current.next;
        current.next = nextNodeToCompare;
        return temp.next;
    }

    public static Node sort(Node head) {
        // get the sorted list first
        Node result = null;
        Node current = head;
        Node nextNode;

        while (current != null) {
            nextNode = current.next;
            result = sortListInsertion(result, current);
            current = nextNode;
        }

        return result;
    }
}
