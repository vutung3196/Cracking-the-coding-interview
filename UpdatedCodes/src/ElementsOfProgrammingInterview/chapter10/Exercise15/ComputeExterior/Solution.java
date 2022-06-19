package ElementsOfProgrammingInterview.chapter10.Exercise15.ComputeExterior;

import ElementsOfProgrammingInterview.chapter10.BinaryTreeNode;
import ElementsOfProgrammingInterview.chapter10.InitializeBinaryTree;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static List<BinaryTreeNode<String>> exteriorBinaryTree(BinaryTreeNode<String> rootNode) {
        var exterior = new LinkedList<BinaryTreeNode<String>>();
        if (rootNode != null) {
            exterior.add(rootNode);
            exterior.addAll(allLeftTreeNodes(rootNode.left, true));
            exterior.addAll(allRightTreeNodes(rootNode.right, true));
        }
        return exterior;
    }

    private static List<BinaryTreeNode<String>> allLeftTreeNodes(BinaryTreeNode<String> treeNode, boolean isBoundary) {
        var result = new LinkedList<BinaryTreeNode<String>>();
        if (treeNode != null) {
            if (isBoundary || isLeaf(treeNode)) {
                result.add(treeNode);
            }
            result.addAll(allLeftTreeNodes(treeNode.left, isBoundary));
            result.addAll(allLeftTreeNodes(treeNode.right, isBoundary && treeNode.left == null));
        }
        return result;
    }

    private static List<BinaryTreeNode<String>> allRightTreeNodes(BinaryTreeNode<String> treeNode,
                                                                  boolean isBoundary) {
        var result = new LinkedList<BinaryTreeNode<String>>();
        if (treeNode != null) {
            if (isBoundary || isLeaf(treeNode)) {
                result.add(treeNode);
            }
            result.addAll(allRightTreeNodes(treeNode.right, isBoundary));
            result.addAll(allRightTreeNodes(treeNode.left, isBoundary && treeNode.right == null));
        }
        return result;
    }

    private static boolean isLeaf(BinaryTreeNode<String> node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        var sampleRoot = InitializeBinaryTree.initLargeTree();
        var result = exteriorBinaryTree(sampleRoot);
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println("Time: " + elapsedTime);
        for (var a : result) {
            System.out.println(a.data);
        }
    }
}
