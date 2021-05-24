package Chapter3.StacksAndQueues.Exercise2StackMin;

/**
 * Design stack min having min function with O(1) time complexity, push, pop O(1) <br>
 * Related question: max stack and  <br> sliding window maximum (https://leetcode.com/problems/sliding-window-maximum/)
 */
public class Solution {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.push(2);
        System.out.println(minStack.getMin());
        minStack.push(-1);
        minStack.push(9);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

