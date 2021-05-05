package Chapter2.LinkedLists.Exercise8.LoopDetection;

import Chapter2.LinkedLists.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a circular linked list, implement an <br>
 * algorithm that returns the node at the beginning of the loop
 */
public class Solution {
    static Node detectLoop(Node head) {
        Set<Node> nodeCountMap = new HashSet<>();
        while (head != null) {
            if (nodeCountMap.contains(head)) {
                break;
            } else {
                nodeCountMap.add(head);
            }
            head = head.next;
        }
        return head;
    }

    /**
     * runner technique, fast and slow pointers
     * @param head
     * @return
     */
    private static Node detectLoopOptimalSolution(Node head) {
        var walker = head;
        var runner = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                break;
            }
        }
        if (walker == null || runner == null) return null;
        runner = head;
        while (runner != walker) {
            walker = walker.next;
            runner = runner.next;
        }
        return walker;
    }


    public static void main(String[] args) {
        var node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = node.next.next.next;

        var detectLoopOptimalSolution = detectLoopOptimalSolution(node);
    }
}
