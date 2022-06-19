package ElementsOfProgrammingInterview.chapter10.Exercise1.HeightBalanced;

import ElementsOfProgrammingInterview.chapter10.BinaryTreeNode;

public class Solution {
    private static class BalanceStatusWithHeight {
        public boolean balanced;
        public int height;

        public BalanceStatusWithHeight(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

    public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
        return checkBalanced(tree).balanced;
    }

    // debug
    private static BalanceStatusWithHeight checkBalanced(BinaryTreeNode<Integer> treeNode) {
        // post order traversal
        if (treeNode == null) {
            // is balanced;
            return new BalanceStatusWithHeight(true, -1);
        }

        BalanceStatusWithHeight leftResult = checkBalanced(treeNode.left);
        if (!leftResult.balanced) {
            return leftResult;
        }

        BalanceStatusWithHeight rightResult = checkBalanced(treeNode.right);
        if (!rightResult.balanced) {
            return rightResult;
        }

        boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        return new BalanceStatusWithHeight(isBalanced, height);
    }

    public static void main(String[] args) {
        // setup
        Solution solution = new Solution();
        BinaryTreeNode node = new BinaryTreeNode("A");
        node.left = new BinaryTreeNode("B");
        node.right = new BinaryTreeNode("K");
        node.left.left = new BinaryTreeNode("C");
        node.left.left.left = new BinaryTreeNode("D");
        node.left.left.right = new BinaryTreeNode("G");
        node.left.left.left.left = new BinaryTreeNode("E");
        node.left.left.left.right = new BinaryTreeNode("F");


        node.left.right = new BinaryTreeNode("H");
        node.left.right.left = new BinaryTreeNode("I");
        node.left.right.right = new BinaryTreeNode("J");
        node.right.left = new BinaryTreeNode("L");
        node.right.right = new BinaryTreeNode("O");
        node.right.left.left = new BinaryTreeNode("M");
        node.right.left.right = new BinaryTreeNode("N");
        System.out.println(solution.isBalanced(node));
    }
}
