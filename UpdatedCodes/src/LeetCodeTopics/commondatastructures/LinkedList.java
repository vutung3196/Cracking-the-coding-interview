package LeetCodeTopics.commondatastructures;

public class LinkedList {
    public ListNode head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(int val) {
        this.head = new ListNode(val);
    }

    public void add(int val) {
        if (head == null) {
            head = new ListNode(val);
            return;
        }

        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = new ListNode(val);
    }

    public void delete(int val) {
        if (head == null) {
            return;
        }

        if (head.val == val) {
            head = head.next;
            return;
        }

        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
                return;
            }

            curr = curr.next;
        }
    }

    public void search(int val) {
        if (head == null) {
            return;
        }

        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                return;
            }

            curr = curr.next;
        }
    }

    public void print() {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

        System.out.println();
    }


}

