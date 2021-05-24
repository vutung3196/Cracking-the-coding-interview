package Chapter3.StacksAndQueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {
    public int currentSize;           // size of the stack
    public int maxSize;
    public Node<T> top;     // last (top) element of the stack

    // for exercise 3: stack of plates
    public boolean isFull;

    public Stack() {
        currentSize = 0;
        top = null;
    }

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        top = null;
    }

    private class Node<T> {
        public T item;
        public Node<T> next;
    }

    public void push(T item) {
        if (currentSize == maxSize) throw new StackOverflowError();
        Node<T> oldFirst = top;
        top = new Node<>();
        top.item = item;
        top.next = oldFirst;
        currentSize++;
        if (currentSize == maxSize) {
            isFull = true;
        }
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return top.item;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        T item = top.item;
        top = top.next;
        currentSize--;
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new Stack.StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private Node<T> current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}