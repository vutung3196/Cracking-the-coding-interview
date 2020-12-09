public class CustomLinkedList {
    Node head;

    public int size() {
        int count = 0;
        var currentNode = head;
        while(currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }
}

class Node {
    public Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    Node deleteNode(Node head, int d) {
        Node n = head;
        if (n.data == d) {
            return head.next;
        }

        while(n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }
}
