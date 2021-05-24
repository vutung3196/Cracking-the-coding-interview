package Chapter3.StacksAndQueues.Exercise1ThreeInOne;
/**
 * Use a single array to implement three stacks
 */
public class Solution {
    public static void main(String[] args) throws FullStackException {
        FixedMultiStack stack = new FixedMultiStack(3);
        stack.push(0, 1);
        stack.push(0, 2);
        stack.push(1, 4);
        stack.push(1, 5);
        stack.push(2, 7);
        stack.push(2, 8);

        // top elements of each stack
        System.out.println(stack.peek(0));
        System.out.println(stack.peek(1));
        System.out.println(stack.peek(2));
    }
}
