package ElementsOfProgrammingInterview.chapter10.HeightBalanced;

import ElementsOfProgrammingInterview.chapter10.BinaryTree;
import ElementsOfProgrammingInterview.chapter10.BinaryTreeNode;

public class PostOrderExample {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTreeNode(1);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.right = new BinaryTreeNode(3);
        tree.root.left.left = new BinaryTreeNode(4);
        tree.root.left.right = new BinaryTreeNode(5);
        tree.printUsingPostOrder();
    }
}
