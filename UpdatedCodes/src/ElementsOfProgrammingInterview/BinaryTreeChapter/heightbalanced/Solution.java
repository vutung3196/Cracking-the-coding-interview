package ElementsOfProgrammingInterview.BinaryTreeChapter.heightbalanced;

import ElementsOfProgrammingInterview.BinaryTreeChapter.BinaryTreeNode;

public class Solution {
    public static void main(String[] args) {

    }

    private static boolean isBalanced(BinaryTreeNode<Integer> root) {
        if (root == null) return true;
        int left = height(root.left);
        int right = height(root.right);

        if (Math.abs(left - right) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int height(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
