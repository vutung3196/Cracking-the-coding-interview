package McGillProgrammingChallenge.datastructures.backspace;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Enter input please lol:");
        var scanner = new java.util.Scanner(System.in);
        var input = scanner.next();
        System.out.println(backspace(input));
    }

    public static String backspace(String input) {
        var result = "";
        Stack<Character> stack = new Stack<>();
        for (var character : input.toCharArray()) {
            if (character != '<') {
                stack.push(character);
            } else {
                stack.pop();
            }
        }

        var sb = new StringBuilder();
        for (var character : stack) {
            sb.append(character);
        }

        return sb.toString();
    }
}
