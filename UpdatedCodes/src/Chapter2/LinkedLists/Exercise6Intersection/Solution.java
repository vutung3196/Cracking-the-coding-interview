package Chapter2.LinkedLists.Exercise6Intersection;

import Chapter2.LinkedLists.Node;

public class Solution {
    static Node doIntersect(Node headA, Node headB) {
        if (headA == null || headB == null) return null;
        var currentA = headA;
        var currentB = headB;
        int lengthA = 1;
        int lengthB = 1;
        while (currentA != null || currentB != null) {
            if (currentA != null) {
                currentA = currentA.next;
                lengthA++;
            }
            if (currentB != null) {
                currentB = currentB.next;
                lengthB++;
            }
        }
        if (lengthA == lengthB && lengthA == 1) {
            return currentA;
        }
        if (currentA != currentB) return null;
        int differenceLength;
        if (lengthA < lengthB) {
            differenceLength = lengthB - lengthA;
            for (int i = 0; i < differenceLength; i++) {
                headB = headB.next;
            }
        } else {
            differenceLength = lengthA - lengthB;
            for (int i = 0; i < differenceLength; i++) {
                headA = headA.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    // outstanding
    public Node getIntersectionNode(Node headA, Node headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        Node a = headA;
        Node b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }


    public static void main(String[] args) {

    }
}
