package ElementsOfProgrammingInterview.chapter10.Exercise5.SumBinary;

import ElementsOfProgrammingInterview.chapter10.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static int sumRootToLeaf(BinaryTreeNode<Integer> root) {
        // find paths from root -> leaf
        // convert path to number => += sum
        return sumRootToLeafHelper(root, 0);
    }

    private static int sumRootToLeafHelper(BinaryTreeNode<Integer> node, int partialPathSum) {
        if (node == null) {
            return 0;
        }
        // key
        partialPathSum = partialPathSum * 2 + node.data;

        // reaching the leaf node
        if (node.left == null && node.right == null) {
            return partialPathSum;
        }

        // non-leaf
        var leftSumRootToLeaf = sumRootToLeafHelper(node.left, partialPathSum);
        var rightSumRootToLeaf = sumRootToLeafHelper(node.right, partialPathSum);
        return leftSumRootToLeaf + rightSumRootToLeaf;
    }

    public static void printAllPaths(BinaryTreeNode<Integer> node) {
        Stack<Integer> paths = new Stack<>();
        printAllPath(node, paths);
    }

    public static void printAllPath(BinaryTreeNode<Integer> node, Stack<Integer> paths) {
        // pre-order
        // create an array, put path into it, when reaching leaf => print
        if (node == null)
            return;

        paths.push(node.data);
        if (node.left == null && node.right == null) {
            for (Integer element : paths) {
                System.out.print(element + "->");
            }
            System.out.println();
        } else {
            printAllPath(node.left, paths);
            printAllPath(node.right, paths);
        }
        paths.pop();
    }

    public static List<String> binaryTreePaths(BinaryTreeNode<Integer> root) {
        var result = new ArrayList<String>();
        Stack<Integer> paths = new Stack<>();
        printAllPaths(root, paths, result);
        return result;
    }

    // leetcode
    private static void printAllPaths(BinaryTreeNode<Integer> node, Stack<Integer> paths, List<String> result){
        if (node == null)
            return;
        paths.push(node.data);
        if (node.left == null && node.right == null) {
            int i = 0;
            StringBuilder sb = new StringBuilder();
            for (Integer element : paths) {
                sb.append(element);
                if (i < paths.size() - 1)
                    sb.append("->");
                i++;
            }
            result.add(sb.toString());
        } else {
            printAllPaths(node.left, paths, result);
            printAllPaths(node.right, paths, result);
        }
        paths.pop();
    }

    public static void main(String[] args) {
        var root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(0);
        root.right = new BinaryTreeNode<>(1);
        root.left.left = new BinaryTreeNode<>(0);
        root.left.right = new BinaryTreeNode<>(1);
        root.right.right = new BinaryTreeNode<>(1);
        root.right.left = new BinaryTreeNode<>(0);
        printAllPaths(root);
        System.out.println(sumRootToLeaf(root));
    }
}
