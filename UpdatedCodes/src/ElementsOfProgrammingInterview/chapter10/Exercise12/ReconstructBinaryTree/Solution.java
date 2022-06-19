package ElementsOfProgrammingInterview.chapter10.Exercise12.ReconstructBinaryTree;

import ElementsOfProgrammingInterview.chapter10.BinaryTreeNode;
import ElementsOfProgrammingInterview.chapter10.InitializeBinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static List<String> inOrders = new ArrayList<>();
    private static List<String> preOrders = new ArrayList<>();

    public static BinaryTreeNode<String> reconstructBinaryTree(List<String> inOrderTraversal,
                                                               List<String> preOrderTraversal) {
        Map<String, Integer> nodeToInOrderIdx = new HashMap<>();
        for (int i = 0; i < inOrderTraversal.size(); i++) {
            nodeToInOrderIdx.put(inOrderTraversal.get(i), i);
        }
        return binaryTreeFromPreorderInorderHelper(preOrderTraversal, 0,
                preOrderTraversal.size(), 0, inOrderTraversal.size(), nodeToInOrderIdx);
    }

    private static BinaryTreeNode<String> binaryTreeFromPreorderInorderHelper(
            List<String> preOrder, int preOrderStart, int preOrderEnd,
            int inOrderStart, int inOrderEnd,
            Map<String, Integer> nodeToInOrderIndex) {
        if (preOrderEnd <= preOrderStart || inOrderEnd <= inOrderStart) {
            return null;
        }

        // get root's index
        int rootInorderIndex = nodeToInOrderIndex.get(preOrder.get(preOrderStart));
        int leftSubTreeSize = rootInorderIndex - inOrderStart;

        // get root node
        var rootNode = new BinaryTreeNode<>(preOrder.get(preOrderStart));
        // go to the left
        rootNode.left = binaryTreeFromPreorderInorderHelper(preOrder, preOrderStart + 1,
                preOrderStart + 1 + leftSubTreeSize,
                inOrderStart, rootInorderIndex, nodeToInOrderIndex);
        // go to the right
        // update pre-order start, pre-order end
        // update in-order start, in-order end
        rootNode.right = binaryTreeFromPreorderInorderHelper(preOrder, preOrderStart + 1 + leftSubTreeSize,
                preOrderEnd, rootInorderIndex + 1, inOrderEnd, nodeToInOrderIndex);
        return rootNode;
    }

    public static void inorder(BinaryTreeNode<String> root) {
        // return if the current node is empty
        if (root == null) {
            return;
        }

        // Traverse the left subtree
        inorder(root.left);

        // Display the data part of the root (or current node)
        inOrders.add(root.data);

        // Traverse the right subtree
        inorder(root.right);
    }

    public static void preorder(BinaryTreeNode<String> root) {
        if (root == null) {
            return;
        }
        preOrders.add(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        var root = InitializeBinaryTree.superSimple();
        inorder(root);
        preorder(root);
        var result = reconstructBinaryTree(inOrders, preOrders);
        System.out.println(result.data);
    }

    private static BinaryTreeNode<String> initSampleBinaryTree() {
        var root = new BinaryTreeNode<>("A");
        root.left = new BinaryTreeNode<>("B");
        root.right = new BinaryTreeNode<>("E");
        root.left.left = new BinaryTreeNode<>("C");
        root.left.right = new BinaryTreeNode<>("D");
        root.right.left = new BinaryTreeNode<>("F");
        root.right.right = new BinaryTreeNode<>("G");
        return root;
    }


//    Variant 1: Solve the same problem with an inorder traversal sequence and a postorder
//    traversal sequence.
//    Variant 2: Let A be an array of n distinct integers. Let the index of the maximum
//    element of A be m. Define the max-tree on A to be the binary tree on the entries of A
//    in which the root contains the maximum element of A, the left child is the max-tree
//    on A[0 : m -1] and the right child is the max-tree on A[m +1: n —1]. Design an 0(n)
//    algorithm for building the max-tree of A.


    // variant 1
    public static BinaryTreeNode<String> reconstructBinaryTreeInOrderPostOrder(String[] inOrder,
                                                                               String[] postOrder) {
        Map<String, Integer> nodeToInOrderIdx = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            nodeToInOrderIdx.put(inOrder[i], i);
        }
        return binaryTreeFromPostorderInorderHelper(inOrder, 0,
                inOrder.length - 1, postOrder, 0, postOrder.length - 1,
                nodeToInOrderIdx);
    }

    private static BinaryTreeNode<String> binaryTreeFromPostorderInorderHelper(
            String[] inorder, int inStart,
            int inEnd, String[] postorder,
            int postStart, int postEnd,
            Map<String, Integer> nodeToInOrderIndex) {
        if (inEnd <= inStart || postEnd <= postStart) {
            return null;
        }

        BinaryTreeNode<String> root = new BinaryTreeNode<>(postorder[postEnd]);
        int rootIndex = nodeToInOrderIndex.get(root.data);
        int numsOnLeft = rootIndex - inStart;
        root.left = binaryTreeFromPostorderInorderHelper(inorder, inStart, rootIndex - 1
                , postorder, postStart, postStart + numsOnLeft - 1, nodeToInOrderIndex);
        root.right = binaryTreeFromPostorderInorderHelper(inorder, rootIndex + 1,
                inEnd, postorder, postStart + numsOnLeft, postEnd - 1, nodeToInOrderIndex);
        return root;
    }
}
