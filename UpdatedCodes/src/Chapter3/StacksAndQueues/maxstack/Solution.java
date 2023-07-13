package Chapter3.StacksAndQueues.maxstack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {

    }

    private static class ElementWithCachedMax {
        public Integer element;
        public Integer max;

        public ElementWithCachedMax(Integer element, Integer max) {
            this.element = element;
            this.max = max;
        }
    }

    public static class Stack {
        // Stores element, cached maximum pair
        private Deque<ElementWithCachedMax> elementWithCachedMax = new LinkedList<>();

        public boolean empty() {
            return elementWithCachedMax.isEmpty();
        }

        public Integer max() {
            if (empty()) throw new IllegalStateException("max(): empty stack");
            return elementWithCachedMax.peek().max;
        }

        public Integer pop() {
            if (empty()) throw new IllegalStateException("max(): empty stack");
            return elementWithCachedMax.removeFirst().element;
        }

        public void push(Integer x) {
            Integer maxValue = Math.max(x, empty() ? x : max());
            elementWithCachedMax.addFirst(new ElementWithCachedMax(x, maxValue));
        }
    }
}
