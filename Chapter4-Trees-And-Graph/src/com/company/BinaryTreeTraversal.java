package com.company;


public class BinaryTreeTraversal {
    void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right);
        }
    }

    void preOrderTraversal(TreeNode node) {
        if (node != null) {
            visit(node);
            inOrderTraversal(node.left);
            inOrderTraversal(node.right);
        }
    }

    void postOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            inOrderTraversal(node.right);
            visit(node);
        }
    }

    private void visit(TreeNode node) {
    }
}

class TreeNode{

    public TreeNode left;
    public TreeNode right;
}
