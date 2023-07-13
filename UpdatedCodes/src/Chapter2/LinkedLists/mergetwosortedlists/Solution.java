package Chapter2.LinkedLists.mergetwosortedlists;

import Chapter2.LinkedLists.Node;

public class Solution {
    public static void main(String[] args) {

    }

    public static Node mergeTwoSortedLists(Node l1, Node l2) {
        // create the result
        Node dummyHead = new Node(0);
        Node current = dummyHead;
        Node p1 = l1;
        Node p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.data < p2.data) {
                current.next = p1;
                p1 = p1.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }

            current = current.next;
        }

        current.next = p1 != null ? p1 : p2;
        return dummyHead.next;
    }
}
