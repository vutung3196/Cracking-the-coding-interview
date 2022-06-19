package ElementsOfProgrammingInterview.chapter10.Exercise9.KNodeInOrderTraversal;

import ElementsOfProgrammingInterview.chapter10.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    // Author's solution
    static BinaryTreeNode<Integer> kThElementInOrderBinaryTree(BinaryTreeNode<Integer> treeNode, int k) {
        // brute-force solution => return list all elements
        // perform in-oder walk
        var interTreeNode = treeNode;
        while (interTreeNode != null) {
            int leftSize = interTreeNode != null ? interTreeNode.left.size : 0;
            if (leftSize + 1 < k) {
                // kth node must be in the right of the subtree
                k -= leftSize + 1;
                interTreeNode = interTreeNode.right;
            } else if (leftSize == k - 1) {
                return interTreeNode;
            } else {
                interTreeNode = interTreeNode.left;
            }
        }
        return null;
    }

    static BinaryTreeNode<Integer> trivialSolutionFromInOrderTraversal(BinaryTreeNode<Integer> treeNode, int k) {
        Deque<BinaryTreeNode<Integer>> listNodes = new ArrayDeque<>();
        List<BinaryTreeNode<Integer>> inOrderBinaryTrees = new ArrayList<>();
        var currentNode= treeNode;
        while (!listNodes.isEmpty() || currentNode != null) {
            if (inOrderBinaryTrees.size() == k) {
                return inOrderBinaryTrees.get(k - 1);
            }
            if (currentNode != null) {
                listNodes.addFirst(currentNode);
                currentNode = currentNode.left;
            } else {
                currentNode = listNodes.removeFirst();
                inOrderBinaryTrees.add(currentNode);
                currentNode = currentNode.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        var root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.right = new BinaryTreeNode<>(6);
        root.right.left = new BinaryTreeNode<>(7);
        var trivialSolutionResult = trivialSolutionFromInOrderTraversal(root, 3);
        assert trivialSolutionResult != null;
        System.out.println(trivialSolutionResult.data);
    }
}
