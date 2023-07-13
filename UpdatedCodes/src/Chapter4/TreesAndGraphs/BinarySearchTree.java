package Chapter4.TreesAndGraphs;

public class BinarySearchTree {
    BinaryTreeNode<Integer> root;

    BinarySearchTree() {
        this.root = null;
    }

    BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int key) {
        if (root == null) {
            root = new BinaryTreeNode<>(key);
            return root;
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    BinaryTreeNode<Integer> search(BinaryTreeNode<Integer> root, int key) {
        if (root == null || root.data == key) {
            return root;
        }

        if (root.data < key)
            return search(root.right, key);
        return search(root.left, key);
    }
}
