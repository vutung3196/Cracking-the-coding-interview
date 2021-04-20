package Chapter2.LinkedLists.AdditionalExercises.PalindromeLinkedList;

public class Solution {
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * This can be solved by reversing the 2nd half and compare the two halves.
     * <br> Let's start with an example [1, 1, 2, 1].
     * <br> In the beginning, set two pointers fast and slow starting at the head.
     * <br> 1 -> 1 -> 2 -> 1 -> null
     * <br> (1) Move: fast pointer goes to the end, and slow goes to the middle.
     * <br> (2) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.
     * <br> (3) Compare: run the two pointers head and slow together and compare.
     */
    public static boolean isPalindromeReferenceSolution(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // for odd linked list
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public static boolean isPalindromeMySolution(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        StringBuilder stringBuilder = new StringBuilder();
        var next = head;
        while (next != null) {
            stringBuilder.append(next.val);
            next = next.next;
        }
        var testString = stringBuilder.toString();
        var length = testString.length();
        for (int i = 0; i < length; i++) {
            if (testString.charAt(i) != testString.charAt(length - i - 1))
                return false;
        }
        return true;
    }

    /**
     * reverse a linked list
     */
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
