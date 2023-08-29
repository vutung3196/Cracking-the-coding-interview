package LeetCodeTopics.commondatastructures;

public class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int val) {
        insertRec(root, val);
    }

    private TreeNode insertRec(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (val < root.val) {
            root.left = insertRec(root.left, val);
        } else if (val > root.val) {
            root.right = insertRec(root.right, val);
        }

        return root;
    }

    public TreeNode search(int val) {
        return searchRec(root, val);
    }

    public TreeNode searchRec(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val < root.val) {
            return searchRec(root.left, val);
        } else if (val == root.val) {
            return root;
        } else {
            return searchRec(root.right, val);
        }
    }

    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.println(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public void preorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public void postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.println(root.val);
        }
    }

    public static void main(String[] args) {
        var tree = new BinarySearchTree();
        tree.root = new TreeNode(4);
        tree.insert(3);
        tree.insert(5);
        tree.insert(2);
        tree.insert(4);
        tree.inorderTraversal(tree.root);
    }
}
