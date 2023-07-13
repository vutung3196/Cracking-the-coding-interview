package Chapter2.LinkedLists.ExerciseCyclicityTest;

import Chapter2.LinkedLists.Node;

public class Solution {
    public static void main(String[] args) {
        var root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = root.next;
        var result = new Solution().detectCycle(root);
        System.out.println(result.data);
    }

    public Node detectCycle(Node head) {
        var fast = head;
        var slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                int cycleLen = 0;
                do {
                    cycleLen = cycleLen + 1;
                    fast = fast.next;
                } while (slow != fast);

                // Finds the start of the cycle.
                var cycleAdvancedIter = head;
                while (cycleLen-- > 0) {
                    cycleAdvancedIter = cycleAdvancedIter.next;
                }

                var iter = head;
                while (iter != cycleAdvancedIter) {
                    iter = iter.next;
                    cycleAdvancedIter = cycleAdvancedIter.next;
                }

                return iter;
            }
        }
        return null;
    }
}
