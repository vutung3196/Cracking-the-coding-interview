package ElementsOfProgrammingInterview.chapter10.Exercise16.RightSiblingTree;

import ElementsOfProgrammingInterview.chapter10.BinaryTreeNode;
import ElementsOfProgrammingInterview.chapter10.InitializeBinaryTree;

//    For this problem, assume that each binary tree node has a extra field, call it level-next,
//    that holds a binary tree node (this field is distinct from the fields for the left and right
//            children). The level-next field will be used to compute a map from nodes to their
//    right siblings. The input is assumed to be perfect binary tree. See Figure 10.6 for an
//    example.
//    Write a program that takes a perfect binary tree, and sets each node's level-next field
//    to the node on its right, if one exists.
public class Solution {
    public static void constructTheRightSibling(BinaryTreeNode<String> tree) {
        BinaryTreeNode<String> leftStart = tree;
        while (leftStart != null && leftStart.left != null) {
            populateLowerLevelNextField(leftStart);
            leftStart = leftStart.left;
        }
    }

    private static void populateLowerLevelNextField(BinaryTreeNode<String> startNode) {
        BinaryTreeNode<String> iter = startNode;
        while (iter != null) {
            iter.left.next = iter.right;
            if (iter.next != null) {
                iter.right.next = iter.next.left;
            }
            iter = iter.next;
        }
    }

    public static void main(String[] args) {
        var simpleTree = InitializeBinaryTree.initSimpleBinaryTree();
        constructTheRightSibling(simpleTree);
        System.out.println(simpleTree.data);
    }
}
