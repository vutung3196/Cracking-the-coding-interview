package ElementsOfProgrammingInterview.BinaryTreeChapter;

public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode left, right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public static void treeTraversal(BinaryTreeNode<Integer> root) {
        if (root != null) {
            // Preorder: Processes the root before the traversals of left and right
            // children
            System.out.println("Preorder: " + root.data);

            treeTraversal(root.left);
            System.out.println("Inorder: " + root.data);

            treeTraversal(root.right);
            System.out.println("Postorder: " + root.data);
        }
    }
}
