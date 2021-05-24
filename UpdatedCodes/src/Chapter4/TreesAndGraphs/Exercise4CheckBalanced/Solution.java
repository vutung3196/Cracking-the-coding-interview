package Chapter4.TreesAndGraphs.Exercise4CheckBalanced;

import Chapter4.TreesAndGraphs.BinaryTreeNode;

/**
 * Difference between two subtrees of any node never differ by more than one
 */
public class Solution {
    /**
     * O(n*Log(n) time complexity
     * @param root
     * @return
     */
    private static int getHeight(BinaryTreeNode<String> root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private static boolean isBalanced(BinaryTreeNode<String> root) {
        if (root == null) return true;
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    // solution 2
    public static boolean isTreeBalanced(BinaryTreeNode<String> root) {
        return checkBalanced(root).balanced;
    }

    private static BalancedTreeWithHeight checkBalanced(BinaryTreeNode<String> node) {
        if (node == null) {
            return new BalancedTreeWithHeight(false, -1);
        }
        var leftTree = checkBalanced(node.left);
        if (!leftTree.balanced) return leftTree;
        var rightTree = checkBalanced(node.right);
        if (!rightTree.balanced) return rightTree;
        boolean isBalanced = Math.abs(leftTree.height - rightTree.height) <= 1;
        int height = Math.max(leftTree.height, rightTree.height) + 1;
        return new BalancedTreeWithHeight(isBalanced, height);
    }

    private static class BalancedTreeWithHeight {
        public boolean balanced;
        public int height;

        public BalancedTreeWithHeight(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

    public static void main(String[] args) {

    }
}
