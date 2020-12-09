import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();
        linkedList.head = new Node(1);
        linkedList.head.appendToTail(1);
        linkedList.head.appendToTail(2);
        linkedList.head.appendToTail(3);
        linkedList.head.appendToTail(3);
        linkedList.head.appendToTail(2);
        var currents = linkedList.head;
        while(currents != null) {
            System.out.println(currents.data);
            currents = currents.next;
        }
        System.out.println("=====================");
        System.out.println("COUNT: " + linkedList.size());

        removeDuplicates(linkedList.head);
        var current = linkedList.head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("COUNT: " + linkedList.size());
    }

    static void removeDuplicates(Node node) {
        HashSet<Integer> linkedListSet = new HashSet<Integer>();
        Node previous = null;

        while(node != null) {
            if (linkedListSet.contains(node.data)) {
                previous.next = node.next;
            } else {
                linkedListSet.add(node.data);
                previous = node;
            }
            node = node.next;
        }
    }

}
