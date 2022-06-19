package ElementsOfProgrammingInterview.chapter10.Exercise14.FormALinkedListOfLeaves;

import ElementsOfProgrammingInterview.chapter10.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

import static ElementsOfProgrammingInterview.chapter10.InitializeBinaryTree.initSimpleBinaryTree;


public class Solution {
    private static List<BinaryTreeNode<String>> formLinkedListOfLeaves(BinaryTreeNode<String> root) {
        var result = new ArrayList<BinaryTreeNode<String>>();
        formLinkedListOfLeavesFromLeftToRight(root, result);
        return result;
    }

    private static void formLinkedListOfLeavesFromLeftToRight(BinaryTreeNode<String> treeNode,
                                                              List<BinaryTreeNode<String>> leaves) {
        if (treeNode != null) {
            if (treeNode.left == null && treeNode.right == null) {
                leaves.add(treeNode);
            } else {
                formLinkedListOfLeavesFromLeftToRight(treeNode.left, leaves);
                formLinkedListOfLeavesFromLeftToRight(treeNode.right, leaves);
            }
        }
    }

    public static void main(String[] args) {
        var root = initSimpleBinaryTree();
        var result = formLinkedListOfLeaves(root);
        for (var a: result) {
            System.out.println(a.data);
        }
    }
}
