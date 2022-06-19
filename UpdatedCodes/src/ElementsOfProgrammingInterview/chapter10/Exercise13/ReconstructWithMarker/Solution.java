package ElementsOfProgrammingInterview.chapter10.Exercise13.ReconstructWithMarker;

import ElementsOfProgrammingInterview.chapter10.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static int subTreeIndex;

    public static BinaryTreeNode<String> reconstructPreOrder(List<String> preOrder) {
        subTreeIndex = 0;
        return reconstructPreOrderWithSubTree(preOrder);
    }

    public static List<String> preOrderList(BinaryTreeNode<String> root) {
        Deque<BinaryTreeNode<String>> treeNodes = new LinkedList<>();
        treeNodes.push(root);
        List<String> result = new ArrayList<>();
        while (!treeNodes.isEmpty()) {
            // add root first
            var currentNode = treeNodes.removeFirst();
            if (currentNode == null) {
                result.add(null);
            }
            if (currentNode != null) {
                result.add(currentNode.data);
                treeNodes.addFirst(currentNode.right);
                // root -> left - right
                treeNodes.addFirst(currentNode.left);
            }
        }
        return result;
    }

    private static BinaryTreeNode<String> reconstructPreOrderWithSubTree(List<String> preOrder) {
        // storing index
        String subTreeData = preOrder.get(subTreeIndex);
        ++subTreeIndex;
        if (subTreeData == null) {
            return null;
        }
        var leftSubTree = reconstructPreOrderWithSubTree(preOrder);
        var rightSubTree = reconstructPreOrderWithSubTree(preOrder);
        return new BinaryTreeNode<>(subTreeData, leftSubTree, rightSubTree);
    }

    public static void main(String[] args) {
        // store the
        // pre order: root -> left -> right
        var treeNode = initSimpleBinaryTreeWithMarkers();
        var preOrderList = preOrderList(treeNode);
        var result = reconstructPreOrder(preOrderList);
        System.out.println(result.data);
    }

    public static BinaryTreeNode<String> initSimpleBinaryTreeWithMarkers() {
        BinaryTreeNode<String> root = new BinaryTreeNode<>("A");
        root.left = new BinaryTreeNode<>("B");
        root.right = new BinaryTreeNode<>("E");
        root.left.left = new BinaryTreeNode<>("C");
        root.left.left.left = null;
        root.left.left.right = null;
        root.left.right = new BinaryTreeNode<>("D");
        root.left.right.left = null;
        root.left.right.right = null;
        root.right.left = new BinaryTreeNode<>("F");
        root.right.right = new BinaryTreeNode<>("G");
        root.right.left.left = null;
        root.right.left.right = null;
        root.right.right.left = null;
        root.right.right.right = null;
        return root;
    }
}
