package McGillProgrammingChallenge.datastructures.icanguessthedatatructure;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int ins = scanner.nextInt();
            boolean isStack = true;
            boolean isQueue = true;
            boolean isPQ = true;
            var stack = new Stack<Integer>();
            Queue<Integer> queue = new LinkedList<>();
            var maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
            for (int i = 0; i < ins; i++) {
                int type = scanner.nextInt();
                if (type == 1) {
                    int next = scanner.nextInt();
                    stack.add(next);
                    queue.add(next);
                    maxHeap.add(next);
                } else if (type == 2) {
                    int value = scanner.nextInt();
                    if (!stack.isEmpty()) {
                        if (value != stack.pop()) {
                            isStack = false;
                        }
                    } else {
                        isStack = false;
                    }

                    if (!queue.isEmpty()) {
                        if (value != queue.poll()) {
                            isQueue = false;
                        }
                    } else {
                        isQueue = false;
                    }

                    if (!maxHeap.isEmpty()) {
                        if (value != maxHeap.poll()) {
                            isPQ = false;
                        }
                    } else {
                        isPQ = false;
                    }
                }
            }

            if (!isStack && !isQueue && !isPQ) {
                System.out.println("impossible");
            } else if (isStack && !isQueue && !isPQ) {
                System.out.println("stack");
            } else if (!isStack && isQueue && !isPQ) {
                System.out.println("queue");
            } else if (!isStack && !isQueue && isPQ) {
                System.out.println("priority queue");
            } else {
                System.out.println("not sure");
            }
        }
    }
}
