package Chapter4.TreesAndGraphs.Exercise5ValidateBST;

import Chapter4.TreesAndGraphs.BinaryTreeNode;
import edu.princeton.cs.algs4.Stack;

/**
 * Write a function to check if a binary tree is a binary search tree
 */
public class Solution {
    // assume that there is no duplicate values in Binary tree
    // get inorder => compare

    // solution 1: recursive
    static boolean checkBST(BinaryTreeNode<Integer> node) {
        return checkBST(node, null, null);
    }

    static boolean checkBST(BinaryTreeNode<Integer> node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.data <= min) || (max != null && node.data > max)) {
            return false;
        }
        return checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);
    }

    // solution 2: iterative
    // using stack to store inorder traversal
    public static boolean isValidBST(BinaryTreeNode<Integer> root) {
        if (root == null) return true;
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> previous = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (previous != null && root.data <= previous.data) return false;
            previous = root;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        var root = new BinaryTreeNode<>(20);
        root.left = new BinaryTreeNode<>(10);
        root.right = new BinaryTreeNode<>(30);
        System.out.println(isValidBST(root));
    }
}
