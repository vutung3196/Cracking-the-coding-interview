package Chapter3.StacksAndQueues.Exercise1ThreeInOne;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class FixedMultiStack {
    private final int NUMBER_OF_STACK = 3;
    // total number of elements in each stack
    private int stackCapacity;
    private int[] values;
    // sizes of each stack. sizes[0] = size of stack[0]
    private int[] sizes;

    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * NUMBER_OF_STACK];
        sizes = new int[NUMBER_OF_STACK];
        var a =new ArrayList<>();
        a.add(false);
        a.set(0, true);
    }

    public void push(int stackNum, int value) throws FullStackException {
        if (isFull(stackNum)) throw new FullStackException();
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public boolean isFull(int stackNumber) {
        return sizes[stackNumber] == stackCapacity;
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) throw new EmptyStackException();
        return values[indexOfTop(stackNum)];
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) throw new EmptyStackException();
        int topIndexOfTheStack = indexOfTop(stackNum);
        int value = values[topIndexOfTheStack];
        // delete
        values[topIndexOfTheStack] = 0;
        // shrink
        sizes[stackNum]--;
        return value;
    }
}
