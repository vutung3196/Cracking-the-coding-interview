package ElementsOfProgrammingInterview.chapter10.Exercise7.InOrderTraversal;

import ElementsOfProgrammingInterview.chapter10.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Solution {
    // left root right
    public static List<Integer> inorderTraversalBST(BinaryTreeNode<Integer> treeNode) {
        Deque<BinaryTreeNode<Integer>> listNodes = new ArrayDeque<>();
        BinaryTreeNode<Integer> currentNode = treeNode;
        List<Integer> result = new ArrayList<>();
        while(!listNodes.isEmpty() || currentNode != null) {
            // go deep to the left path
            if (currentNode != null) {
                listNodes.addFirst(currentNode);
                currentNode = currentNode.left;
            } else {
                // go to the right
                currentNode = listNodes.removeFirst();
                result.add(currentNode.data);
                currentNode = currentNode.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.right = new BinaryTreeNode<>(6);
        root.right.left = new BinaryTreeNode<>(7);
        var result = inorderTraversalBST(root);
        for(Integer element : result) {
            System.out.println(element);
        }
    }
}
