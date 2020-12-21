import java.util.EmptyStackException;

public class FixedMultiStack {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public FixedMultiStack(int stackSize) {
        stackCapacity = numberOfStacks;
        values = new int[stackSize * numberOfStacks];
        // size of each stack
        sizes = new int[numberOfStacks];
    }

    /* push values onto the stack */
    public void push(int stackNum, int value) throws FullStackException {
        if (isFull(stackNum)) {
            throw new FullStackException();
        }
        /* increment stack pointer and then update top value*/
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    /* pop item from top stack */
    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }

    /* return top element*/
    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];

    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    private boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    private int indexOfTop(int stackNum) {
        //  0 1 2 / 3 4 5 / 6 7  = 2 + 2 * 3 - 1
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}
