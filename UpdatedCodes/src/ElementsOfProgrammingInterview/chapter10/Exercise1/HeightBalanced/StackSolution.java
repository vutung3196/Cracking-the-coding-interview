package ElementsOfProgrammingInterview.chapter10.Exercise1.HeightBalanced;

import Chapter4.TreesAndGraphs.BinaryTreeNode;

import java.util.Stack;

public class StackSolution {
    public int sumRootToLeaf(BinaryTreeNode<Integer> root) {
        Result result = new Result();
        Stack<Integer> paths = new Stack<>();
        calculateSumInAllPaths(root, paths, result);
        return result.sum;
    }

    private void calculateSumInAllPaths(BinaryTreeNode<Integer> node, Stack<Integer> paths, Result result) {
        if (node == null)
            return;
        paths.push(node.data);
        if (node.left == null && node.right == null) {
            result.sum += calculate(paths);
        } else {
            calculateSumInAllPaths(node.left, paths, result);
            calculateSumInAllPaths(node.right, paths, result);
        }
        paths.pop();
    }

    private int calculate(Stack<Integer> paths) {
        int result = 0;
        int i = 0;
        for(Integer element : paths) {
            result += element * Math.pow(2, paths.size() - i - 1);
            i++;
        }
        return result;
    }

    private static class Result {
        public int sum;
    }
}
