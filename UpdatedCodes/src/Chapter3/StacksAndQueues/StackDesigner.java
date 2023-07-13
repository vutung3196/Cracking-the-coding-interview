package Chapter3.StacksAndQueues;

import java.util.NoSuchElementException;

public class StackDesigner {
    public int currentSize;
    public int maxSize;
    public Node top;


    public StackDesigner() {
        currentSize = 0;
        top = null;
    }

    public StackDesigner(int maxSize) {
        this.maxSize = maxSize;
        top = null;
    }

    public void push(int itemData) {
        if (currentSize == maxSize) throw new StackOverflowError();
        if (top == null) {
            top = new Node(itemData);
            return;
        }

        var oldTop = top;
        top = new Node(itemData);
        top.next = oldTop;
        currentSize++;
    }

    public int peek() {
        return top.data;
    }

    public int pop() {
        if (currentSize == 0) throw new NoSuchElementException();
        int item = top.data;
        top = top.next;
        currentSize--;
        return item;
    }

    private class Node {
        public Node(int data) {
            this.data = data;
        }

        public int data;
        public Node next;
    }
}
