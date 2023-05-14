package blind75.week1.implementequeueusingstacks;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }

    class MyQueue {

        // maybe one stack stores
        private final Stack<Integer> mainStack;
        // idea: reverse stack is actually queue
        private final Stack<Integer> reverseStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            mainStack = new Stack<>();
            reverseStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!reverseStack.empty()) {
                var element = reverseStack.pop();
                mainStack.push(element);
            }
            mainStack.push(x);
            while (!mainStack.isEmpty()) {
                var element = mainStack.pop();
                reverseStack.push(element);
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return reverseStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            return reverseStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return reverseStack.empty();
        }
    }
}
