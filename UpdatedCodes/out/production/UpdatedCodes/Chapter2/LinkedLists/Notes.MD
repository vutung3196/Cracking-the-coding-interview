**Notes**
1. LinkedList implementation
`class Node {
    Node next = null;
    int data;
}`
   
2. The "runner" technique
`ListNode fast = head, slow = head; 
while (fast != null && fast.next != null) {
fast = fast.next.next;
slow = slow.next;
   }`