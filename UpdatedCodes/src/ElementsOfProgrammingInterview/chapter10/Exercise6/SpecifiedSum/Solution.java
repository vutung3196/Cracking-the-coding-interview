package ElementsOfProgrammingInterview.chapter10.Exercise6.SpecifiedSum;

import ElementsOfProgrammingInterview.chapter10.BinaryTreeNode;

import static ElementsOfProgrammingInterview.chapter10.Exercise5.SumBinary.Solution.printAllPaths;

public class Solution {
    public static boolean hasPathSum(BinaryTreeNode<Integer> treeNode, int sum) {
        return hasPathSumHelper(treeNode, 0, sum);
    }


    static boolean hasPathSumHelper(BinaryTreeNode<Integer> treeNode, int pathSum, int targetSum) {
        if (treeNode == null) {
            return false;
        }

        pathSum += treeNode.data;
        if (treeNode.left == null && treeNode.right == null && pathSum == targetSum) {
            return true;
        }
        return hasPathSumHelper(treeNode.left, pathSum, targetSum) ||
                hasPathSumHelper(treeNode.right, pathSum, targetSum);
    };

    public static void main(String[] args) {
        var root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.right = new BinaryTreeNode<>(6);
        root.right.left = new BinaryTreeNode<>(7);
        printAllPaths(root);
        System.out.println(hasPathSum(root, 10));
    }
}
