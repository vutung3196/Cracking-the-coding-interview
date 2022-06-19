package ElementsOfProgrammingInterview.chapter10;

public class BinaryTree {
    public BinaryTreeNode root;
    public BinaryTree() {
        this.root = null;
    }

    private void printPostorder(BinaryTreeNode node)
    {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.data + " ");
    }

    public void printUsingPostOrder() {
        printPostorder(root);
    }
}
