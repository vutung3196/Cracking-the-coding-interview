package ElementsOfProgrammingInterview.chapter10.Exercise2.SymmeTric;

import ElementsOfProgrammingInterview.chapter10.BinaryTree;
import ElementsOfProgrammingInterview.chapter10.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTreeNode<>(1);
        tree.root.left = new BinaryTreeNode<>(2);
        tree.root.right = new BinaryTreeNode<>(3);
        tree.root.left.left = new BinaryTreeNode<>(4);
        tree.root.left.right = new BinaryTreeNode<>(5);
        tree.root.right.right = new BinaryTreeNode<>(7);
        tree.root.right.left = new BinaryTreeNode<>(5);
        tree.printUsingPostOrder();
        invertBinaryTreeIteratively(tree.root);
        System.out.println();
        tree.printUsingPostOrder();
    }

    public static boolean isSymmetric(BinaryTreeNode<Integer> treeNode) {
        return isEqual(invert(treeNode.left), treeNode.right);
    }

    private static BinaryTreeNode<Integer> invert(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return null;
        }
        var temp = node.left;
        node.left = invert(node.right);
        node.right = invert(temp);
        return node;
    }

    private static boolean isEqual(BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.data.equals(node2.data) && isEqual(node1.left, node2.left) && isEqual(node1.right, node2.right);
    }

    public static boolean isSymmetricWithoutUsingInvert(BinaryTreeNode<Integer> tree) {
        return tree == null || checkSymmetric(tree.left, tree.right);
    }

    private static boolean checkSymmetric(BinaryTreeNode<Integer> subTree0, BinaryTreeNode<Integer> subTree1) {
        if (subTree0 == null && subTree1 == null) {
            return true;
        } else if (subTree0 != null && subTree1 != null) {
            return subTree0.data.equals(subTree1.data) && checkSymmetric(subTree0.left, subTree1.right)
                    && checkSymmetric(subTree0.right, subTree1.left);
        }
        return false;
    }

    // 2nd solution iterative one.
    public static void swap(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        var temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void invertBinaryTreeIteratively(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            var current = queue.poll();
            swap(current);

            // enqueue left
            if (current.left != null) {
                queue.add(current.left);
            }

            // enqueue right
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}
