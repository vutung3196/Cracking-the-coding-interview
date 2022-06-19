package ElementsOfProgrammingInterview.chapter10.Exercise10.ComputeSuccessor;

public class Solution {
    public static BinaryTree<Integer>  findSuccessor(BinaryTree<Integer> node) {
        BinaryTree<Integer> iter = node;
        // case 1
        if (iter.right != null) {
            // find the left most element is node's right subtree
            iter = iter.right;
            while (iter.left != null) {
                iter = iter.left;
            }
            return iter;
        }
        // case 2
        while (iter.parent != null && iter.parent.right == iter) {
            iter = iter.parent;
        }
        return iter.parent;
    }

    BinaryTree<Integer> preOrderSuccessorNode(BinaryTree<Integer> root,  BinaryTree<Integer> n){
        // if left node exist, it's preorder successor
        if (n.left == null)
            return n.left;
        BinaryTree<Integer> curr = n, parent = curr.parent;
        while (parent != null && parent.right == curr) {
            curr = curr.parent;
            parent = parent.parent;
        }
        if (parent == null)
            return null;
        return parent.right;
    }

    static BinaryTree<Integer> postorderSuccessor(BinaryTree<Integer> root, BinaryTree<Integer> n)
    {
        // Root has no successor in postorder
        // traversal
        if (n == root)
            return null;

        // If given node is right child of its
        // parent or parent's right is empty, then
        // parent is postorder successor.
        var parent = n.parent;
        if (parent.right == null || parent.right == n)
            return parent;

        // In all other cases, find the leftmost
        // child in right substree of parent.
        var curr = parent.right;
        while (curr.left != null)
            curr = curr.left;

        return curr;
    }

    public static void main(String[] args) {

    }
}

class BinaryTree<T> {
    BinaryTree<T> left, right, parent;
}
