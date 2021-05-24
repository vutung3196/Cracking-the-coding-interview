package Chapter4.TreesAndGraphs;

public class InitializeBinaryTree {
    public static BinaryTreeNode<String> initLargeTree() {
        BinaryTreeNode<String> root = new BinaryTreeNode<>("A");
        root.left = new BinaryTreeNode<>("B");
        root.left.left = new BinaryTreeNode<>("C");
        root.left.left.left = new BinaryTreeNode<>("D");
        root.left.left.right = new BinaryTreeNode<>("E");
        root.left.right = new BinaryTreeNode<>("F");
        root.left.right.right = new BinaryTreeNode<>("G");
        root.left.right.right.left = new BinaryTreeNode<>("H");
        root.right = new BinaryTreeNode<>("I");
        root.right.right = new BinaryTreeNode<>("O");
        root.right.right.right = new BinaryTreeNode<>("P");
        root.right.left = new BinaryTreeNode<>("J");
        root.right.left.right = new BinaryTreeNode<>("K");
        root.right.left.right.left = new BinaryTreeNode<>("L");
        root.right.left.right.right = new BinaryTreeNode<>("N");
        root.right.left.right.left.right = new BinaryTreeNode<>("M");
        return root;
    }

    public static BinaryTreeNode<String> initSimpleBinaryTree() {
        BinaryTreeNode<String> root = new BinaryTreeNode<>("A");
        root.left = new BinaryTreeNode<>("B");
        root.right = new BinaryTreeNode<>("E");
        root.left.left = new BinaryTreeNode<>("C");
        root.left.right = new BinaryTreeNode<>("D");
        root.right.left = new BinaryTreeNode<>("F");
        root.right.right = new BinaryTreeNode<>("G");
        return root;
    }


    public static BinaryTreeNode<String> sample() {
        BinaryTreeNode<String> root = new BinaryTreeNode<>("A");
        root.left = new BinaryTreeNode<>("B");
        root.right = new BinaryTreeNode<>("C");
        root.left.left = new BinaryTreeNode<>("F");
        root.left.right = new BinaryTreeNode<>("G");
        root.left.right.right = new BinaryTreeNode<>("H");
        root.right.right = new BinaryTreeNode<>("D");
        root.right.right.left = new BinaryTreeNode<>("E");
        return root;
    }

    public static BinaryTreeNode<String> sampleBinarySearchTree() {
        BinaryTreeNode<String> root = new BinaryTreeNode<>("B");
        root.left = new BinaryTreeNode<>("A");
        root.right = new BinaryTreeNode<>("D");
        root.right.right = new BinaryTreeNode<>("E");
        root.right.left = new BinaryTreeNode<>("C");
        root.right.right.right = new BinaryTreeNode<>("F");
        return root;
    }

    public static void main(String[] args) {
        var a = sampleBinarySearchTree();
        inOrderTreeTraversal(a);
    }

    public static void inOrderTreeTraversal(BinaryTreeNode<String> node) {
        if (node != null) {
            inOrderTreeTraversal(node.left);
            System.out.println(node.data);
            inOrderTreeTraversal(node.right);
        }
    }

    public static void preOrderTreeTraversal(BinaryTreeNode<String> node) {
        if (node != null) {
            System.out.println(node.data);
            preOrderTreeTraversal(node.left);
            preOrderTreeTraversal(node.right);
        }
    }

    public static void postOrderTreeTraversal(BinaryTreeNode<String> node) {
        if (node != null) {
            postOrderTreeTraversal(node.left);
            postOrderTreeTraversal(node.right);
            System.out.println(node.data);
        }
    }
}
