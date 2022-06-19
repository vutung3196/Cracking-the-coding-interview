package ElementsOfProgrammingInterview.chapter10.Exercise8.PreOrderTraversal;

import ElementsOfProgrammingInterview.chapter10.BinaryTreeNode;

import java.util.*;

public class Solution {
    static List<Integer> preOrderTraversalBST(BinaryTreeNode<Integer> treeNode) {
        // root -> left -> right
        Deque<BinaryTreeNode<Integer>> treeNodes = new LinkedList<>();
        treeNodes.push(treeNode);
        List<Integer> result = new ArrayList<>();
        while (!treeNodes.isEmpty()) {
            BinaryTreeNode<Integer> current =  treeNodes.removeFirst();
            if (current != null) {
                result.add(current.data);
                treeNodes.addFirst(current.right);
                treeNodes.addFirst(current.left);
            }
        }
        return result;
    }

    static void printPreOrder(BinaryTreeNode<Integer> treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.data + "->");

        printPreOrder(treeNode.left);
        printPreOrder(treeNode.right);
    }

    public static void main(String[] args) {
        var root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.right = new BinaryTreeNode<>(6);
        root.right.left = new BinaryTreeNode<>(7);
        var result = preOrderTraversalBST(root);
        for(Integer element : result) {
            System.out.println(element);
        }
    }
}
