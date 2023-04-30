package blind75.week1.validparentheses;


import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        // open brackets must be closed by the same type of brackets
        // open brackets must be closed in the correct order
        // every close bracket has a corresponding open bracket of the same type
        Stack<Character> stack = new Stack<>();

        // try to put every element to the stack
        // iterate to all characters in the String s
        for (var character : s.toCharArray()) {
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (character == ')' && stack.peek() != '(') {
                    return false;
                } else if (character == '}' && stack.peek() != '{') {
                    return false;
                } else if (character == ']' && stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
