package Chapter2.LinkedLists;

public class Node {
    public Node(int data) {
        this.data = data;
    }

    public Node next;
    public int data;


    // search a node
    public static Node search(Node L, int key) {
        while (L != null && L.data != key) {
            L = L.next;
        }

        return L;
    }

    // insert a new node after a specified node
    public static void insertAfter(Node node, Node newNode) {
        newNode.next = node.next;
        node.next = newNode;
    }

    // delete a node following aNode
    public static void deleteList(Node aNode) {
        aNode.next = aNode.next.next;
    }

    public static void deleteNode(int keyData) {
        // found and repalce
    }
}
