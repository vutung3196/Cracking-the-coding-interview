package Chapter2.LinkedLists.Exercise5SumLists;

import Chapter2.LinkedLists.Node;

public class FollowUp {
    class PartialSum {
        public Node sum = null;
        public int carry = 0;
    }

    Node addLists(Node l1, Node l2) {
        int len1 = length(l1);
        int len2 = length(l2);

        // processing
        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }

        // add list helper
        PartialSum sum = addListHelper(l1, l2);
        if (sum.carry == 0) {
            return sum.sum;
        } else {
            Node result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    /**
     * using recursion here
     * @param l1
     * @param l2
     * @return
     */
    private PartialSum addListHelper(Node l1, Node l2) {
        if (l1 == null && l2 == null) {
            PartialSum sum = new PartialSum();
            return sum;
        }

        /* Add smaller digits recursively */
        PartialSum sum = addListHelper(l1.next, l2.next);

        /* Add carry to current data */
        int val = sum.carry + l1.data + l2.data;
        Node full_result = insertBefore(sum.sum, val % 10);
        sum.sum = full_result;
        sum.carry = val / 10;
        return sum;
    }

    int length(Node node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    Node padList(Node l1, int padding) {
        Node head = l1;
        for (int i = 0; i < padding; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    private Node insertBefore(Node list, int data) {
        Node node = new Node(data);
        if (list == null) {
            node.next = list;
        }
        return node;
    }


    public static void main(String[] args) {

    }
}
