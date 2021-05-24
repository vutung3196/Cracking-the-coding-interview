package Chapter3.StacksAndQueues.Exercise3StackOfPlates;

import Chapter3.StacksAndQueues.Stack;

public class SetOfStacks {
    public int sizeOfEachStack;
    // resize stack
    public Stack<Stack<Integer>> stacks;

    public SetOfStacks(int sizeOfEachStack) {
        this.sizeOfEachStack = sizeOfEachStack;
    }

    public void push(int item) {
        // push to left most, other wise push to next;
        Stack<Integer> targetStack = null;
        for (var currentStack: stacks) {
            if (!currentStack.isFull) {
                targetStack = currentStack;
                break;
            }
        }
        if (targetStack == null)
        {
            targetStack = new Stack<>(sizeOfEachStack);
            stacks.push(targetStack);
        }
        targetStack.push(item);
    }

    public int pop() {
        Stack<Integer> targetStack = stacks.peek();
        if (targetStack == null) return -1;
        return targetStack.pop();
    }

    public int popAt(int index) {
        Stack<Integer> targetStack = null;
        int currentIndex = 0;
        for (var currentStack: stacks) {
            if (currentIndex == index) targetStack = currentStack;
        }
        if (targetStack == null) return -1;
        return targetStack.pop();
    }
}
