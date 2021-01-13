public class Main {
    public static void main(String[] args) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.head = new Node(1);
        customLinkedList.head.appendToTail(1);
        customLinkedList.head.appendToTail(2);
        customLinkedList.head.appendToTail(3);
        customLinkedList.head.appendToTail(3);
        customLinkedList.head.appendToTail(2);
        // 1 1 2 3 3 2
        System.out.println(getKthElementFromLast(customLinkedList, 3));
        System.out.println(getKthElementFromLast(customLinkedList, 4));
        System.out.println(getKthElementFromLast(customLinkedList, 1));
    }


    static int getKthElementFromLast(CustomLinkedList customLinkedList, int k) {
        var size = customLinkedList.size();
        // 1 2 3 4 5 6
        // => size - k + 1
        int index = customLinkedList.size() - k + 1;
        int i = 1;
        var currentNode = customLinkedList.head;
        while(i < index && currentNode != null) {
            i++;
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

}
