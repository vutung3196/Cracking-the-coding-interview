package Chapter3.StacksAndQueues.Exercise2StackMin;

class MinStack {
    public int size;
    public Node top;

    /** initialize your data structure here. */
    public MinStack() {
        size = 0;
        top = null;
    }

    public void push(int val) {
        if (top == null) {
            top = new Node(val, val);
        } else {
            top = new Node(val, Math.min(val, top.min), top);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void pop() {
        top = top.next;
        size--;
    }

    public int top() {
        return top.data;
    }

    public int getMin() {
        return top.min;
    }

    private class Node {
        public int data;
        public Node next;
        public int min;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, int min) {
            this.data = data;
            this.min = min;
        }

        public Node(int data, int min, Node next) {
            this.data = data;
            this.min = min;
            this.next = next;
        }
    }
}

