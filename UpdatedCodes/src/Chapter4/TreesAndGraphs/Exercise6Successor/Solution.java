package Chapter4.TreesAndGraphs.Exercise6Successor;

import Chapter4.TreesAndGraphs.BinaryTreeNode;
import Chapter4.TreesAndGraphs.InitializeBinaryTree;
import edu.princeton.cs.algs4.Stack;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static BinaryTreeNode<String> predecessor = new BinaryTreeNode<>("-1");
    private static BinaryTreeNode<String> successor = new BinaryTreeNode<>("-1");
    // left - root - right
    // brute-force solution
    public static BinaryTreeNode<String> findSuccessorBruteForce(BinaryTreeNode<String> root, BinaryTreeNode<String> search) {
        if (root == null) return null;
        List<BinaryTreeNode<String>> result = new ArrayList<>();
        Stack<BinaryTreeNode<String>> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root);
            root = root.right;
        }
        var index  = result.indexOf(search);
        if (index == result.size() - 1) return null;
        return result.get(index + 1);
    }

    public static void findSuccessor(BinaryTreeNode<String> root, String searchKey) {
        if (root == null) return;
        if (root.data.compareTo(searchKey) == 0) {
            // if its left sub tree is not null
                // predecessor will be the right most of left subtree or left child itself
            // if its right sub tree is not null
                // successor will be the left most child of right sub tree or right child

            // find the maximum value in the left sub tree : predecessor
            if (root.left != null) {
                var temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                predecessor = temp;
            }

            // The minimum value in
            // right subtree is successor
            if (root.right != null) {
                var temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                successor = temp;
            }
            return;
        }
        if (root.data.compareTo(searchKey) > 0) {
            successor = root;
            findSuccessor(root.left, searchKey);
        } else {
            predecessor = root;
            findSuccessor(root.right, searchKey);
        }
    }

    public static void findSuccessorV2(BinaryTreeNode<String> root, String searchKey) {
        if (root == null) return;
        if (root.data.compareTo(searchKey) == 0) {
            // maximum value in left subtree => predecessor
            if (root.left != null) {
                var temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                predecessor = temp;
            }
            // minimum value in right subtree => successor
            if (root.right != null) {
                var temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                successor = temp;
            }
            return;
        }
        if (root.data.compareTo(searchKey) > 0) {
            successor = root;
            findSuccessor(root.left, searchKey);
        } else {
            predecessor = root;
            findSuccessor(root.right, searchKey);
        }
    }


    public static void main(String[] args) {
        var root = InitializeBinaryTree.sampleBinarySearchTree();
        findSuccessor(root, "E");
        System.out.println(predecessor.data);
        System.out.println(successor.data);
    }
}
