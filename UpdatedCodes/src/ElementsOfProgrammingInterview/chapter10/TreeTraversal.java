package ElementsOfProgrammingInterview.chapter10;

public class TreeTraversal {
    public static void main(String[] args) {

    }

    // Implement preorder, inorder, postorder
    public static void treeTraversal(BinaryTreeNode<Integer> root) {
        if (root != null) {
            // Pre-order: processes the root before the traversals of left and right
            // children.
            System.out.println("Preorder:" + root.data);
            treeTraversal(root.left);
            // Inorder: Processes the root after the traversal of left child
            // before the traversal of the right child
            System.out.println("Inorder: " + root.data);
            treeTraversal(root.right);
            // Postorder: Processes the root order after the traversal of left
            // and right children
            System.out.println("Postorder: " + root.data);
        }
    }
}
