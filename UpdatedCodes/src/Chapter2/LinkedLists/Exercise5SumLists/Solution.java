package Chapter2.LinkedLists.Exercise5SumLists;

import Chapter2.LinkedLists.Node;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * <br> The digits are stored in reverse order, and each of their nodes contains a single digit.
 * <br> Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class Solution {
    public static Node addTwoNumbers(Node number1, Node number2) {
        Node beforeResult = new Node(-1);
        Node result = beforeResult;
        // elementary math
        int carry = 0;
        while (number1 != null || number2 != null) {
            int data1 = number1 != null ? number1.data : 0;
            int data2 = number2 != null ? number2.data : 0;
            int sum = data1 + data2 + carry;
            carry = sum / 10;
            result.next = new Node(sum % 10);
            number1 = number1 != null ? number1.next : null;
            number2 = number2 != null ? number2.next : null;
            result = result.next;
        }
        if (carry > 0) {
            result.next = new Node(carry);
        }
        return beforeResult.next;
    }

    // follow-up questions 1-> 2 -> 3  + 3 -> 4 -> 5 => 4 -> 6 -> 8
    // Without using linked list revert
    public static Node addTwoNumbers2(Node number1, Node number2) {
        return new Node(1);
    }

    public static void main(String[] args) {
        
    }
}
