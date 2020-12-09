public class Main {
    static boolean deleteNode(Node targetNode) {
        if (targetNode == null || targetNode.next == null) {
            return false;
        }
        Node next = targetNode.next;
        // Assign value to target node
        targetNode.data = next.data;
        targetNode.next = next.next;
        return true;
    }
}
