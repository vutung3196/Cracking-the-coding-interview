package blind75.week2.reverselinkedlist;

public class Solution {
    public static void main(String[] args) {

    }
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

   public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        var current = head;
        while (current != null) {
            var temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
   }

    // 1-2-3-4-5
}
