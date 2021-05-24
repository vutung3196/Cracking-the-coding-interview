package Chapter4.TreesAndGraphs.Exercise3ListOfDepths;

import Chapter4.TreesAndGraphs.BinaryTreeNode;

import java.util.*;

public class Solution {
    private static List<Queue<BinaryTreeNode<String>>> listDepths(BinaryTreeNode<String> root) {
        List<Queue<BinaryTreeNode<String>>> result = new ArrayList<>();
        Queue<BinaryTreeNode<String>> current = new LinkedList<>();
        current.add(root);
        while (current.size() != 0) {
            // add the previous level to the result
            result.add(current);
            // go to the next level
            var parents = current;
            current = new LinkedList<>();
            for (var parent : parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeNode<String> root = new BinaryTreeNode<>("A");
        root.left = new BinaryTreeNode<>("B");
        root.right = new BinaryTreeNode<>("K");
        root.left.left = new BinaryTreeNode<>("C");
        root.left.left.left = new BinaryTreeNode<>("D");
        root.left.left.right = new BinaryTreeNode<>("G");
        root.left.left.left.left = new BinaryTreeNode<>("E");
        root.left.left.left.right = new BinaryTreeNode<>("F");
        var result = listDepths(root);
        int level = 0;
        for (var linkedList : result) {
            System.out.println("Level " + level);
            for (var node : linkedList) {
                System.out.print(node.data + " ");
            }
            System.out.println();
            level++;
        }
    }
}
