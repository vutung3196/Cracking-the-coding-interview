package Chapter2.LinkedLists.ReserveSingleSubList;

import Chapter2.LinkedLists.Node;

public class Solution {
    public static void main(String[] args) {
        // init the linked list
        var root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);
        var result = reverseSubListV2(root, 1, 4);

        // print the result
        var current = result;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }


    public static Node found(Node root, int data) {
        var current = root;
        while (current != null) {
            if (current.data == data) {
                System.out.println("found");
                return current;
            }
            current = current.next;
        }

        return null;
    }

    public static Node reverseSublist(Node root, int start, int end) {
        if (start == end) return root;
        var current = root;
        var count = 0;
        Node startNode = null, endNode = null;
        while (current != null) {
            if (count == start) {
                startNode = current;
            }
            if (count == end) {
                endNode = current;
                break;
            }
            current = current.next;
            count++;
        }

        // append the rest;
        // reserve from start node to end node
        Node prev = current.next;
        var curr = startNode;
        var currentCount = start;
        while (currentCount <= end) {
            var forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
            currentCount++;
        }

        var anotherCurrent = root;
        while (anotherCurrent != null) {
            if (anotherCurrent.next == startNode) {
                anotherCurrent.next = endNode;
                break;
            }
            anotherCurrent = anotherCurrent.next;
        }

        return root;
    }

    public static Node reverseSubListV2(Node root, int start, int finish) {
        if (start == finish) return root;
        Node dummyHead = root;
        var sublistHead = dummyHead;
        int k = 1;
        while (k++ < start) {
            sublistHead = sublistHead.next;
        }

        // Reverse list
        var sublistIter = sublistHead.next;
        while (start++ < finish) {
            var temp = sublistIter.next;
            sublistIter.next = temp.next;
            temp.next = sublistHead.next;
            sublistHead.next = temp;
        }

        return dummyHead.next;
    }
}
