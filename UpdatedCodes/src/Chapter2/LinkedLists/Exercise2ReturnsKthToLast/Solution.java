package Chapter2.LinkedLists.Exercise2ReturnsKthToLast;

/**
 * 2.2 Return Kth to Last:  <br>
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class Solution {
    // find the index of the kth
    // trivial solution
    private static int indexOfKthTrivialSolution(Node head, int k) {
        int index = 0;
        var size = head.getSize();
        var targetIndex = size - k;
        while (head != null) {
            if (index == targetIndex) {
                return head.Data;
            }
            index++;
            head = head.Next;
        }
        return -1;
    }

    // wow, just wow
    private static int printKthToLast(Node node, int k) {
        if (node == null)
            // index zero == last
            return 0;
        int index = printKthToLast(node.Next, k) + 1;
        if (index == k) {
            System.out.println(k + "th to last node is " + node.Data);
        }
        return index;
    }

    // wow, just wow
    /**
     * moving p1 to the kth nodes into the list. <br>
     * p1 will hit the end of the linked list after length - k steps <br>
     * at that point p2 will be LENGTH - k nodes into the list or k nodes from end <br>
     * @param head
     * @param k
     * @return
     */
    private static Node getNodeKthToLastIteratively(Node head, int k) {
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < k; i++) {
            // out of bound
            if (p1 == null) return null;
            p1 = p1.Next;
        }

        while (p1 != null) {
            p1 = p1.Next;
            p2 = p2.Next;
        }
        return p2;
    }

    private static class Node {
        public Node(int data) {
            Data = data;
        }

        public Node Next;
        public int Data;

        public int getSize() {
            int size = 0;
            var currentNode = this;
            while (currentNode != null) {
                size++;
                currentNode = currentNode.Next;
            }
            return size;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.Next = new Node(2);
        node.Next.Next = new Node(3);
        node.Next.Next.Next = new Node(3);
        node.Next.Next.Next.Next = new Node(4);
        System.out.println(indexOfKthTrivialSolution(node, 1));
        System.out.println(indexOfKthTrivialSolution(node, 2));
        System.out.println(indexOfKthTrivialSolution(node, 3));
        System.out.println(indexOfKthTrivialSolution(node, 4));
        printKthToLast(node, 4);
        System.out.println(getNodeKthToLastIteratively(node, 4).Data);
    }
}
