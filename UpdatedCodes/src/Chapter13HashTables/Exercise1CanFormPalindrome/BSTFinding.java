package Chapter13HashTables.Exercise1CanFormPalindrome;

import java.util.ArrayList;
import java.util.List;

public class BSTFinding {
    private static class Node {
        public int Value;
        public Node left, right;

        public Node(int value) {
            Value = value;
        }
    }

    private static final List<Integer> elements = new ArrayList<>();


    static void solution(Node node, int low, int high) {
        if (node == null) {
            return;
        }
        if (low < node.Value) {
            solution(node.left, low, high);
        }

        if (low <= node.Value && high >= node.Value) {
            elements.add(node.Value);
        }
        solution(node.right, low, high);
    }

    public static void main(String[] args) {
            var a= "1226#24#";
            var b = a.split(("#"));
        for (var c:
             b) {
            System.out.println(c);
        }
//        int low = 4, high = 12;
//        var root = new Node(20);
//        root.left = new Node(8);
//        root.right = new Node(22);
//        root.left.left = new Node(4);
//        root.left.right = new Node(16);
//
//        solution(root, low, high);
//        for (var a: elements) {
//            System.out.println(a);
//        }
    }
}
