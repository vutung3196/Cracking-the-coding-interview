package implementation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    public BinaryTreeNode root;

    // binary tree, all left < all right
    private BinaryTreeNode addRecursive(BinaryTreeNode current, int value) {
        if (current == null) {
            return new BinaryTreeNode(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if(value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive(BinaryTreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    // Breath first search
    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            BinaryTreeNode node = nodes.remove();
            System.out.println(" " + node.value);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    // find and delete
    private BinaryTreeNode deleteRecursive(BinaryTreeNode current, int value) {
        if (current == null) {
            return null;
        }

        // tricky
        if (value == current.value) {
            // Node to delete
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            else {
                // Found a node having 2 children
                // find the smallest value to the node to delete
                int smallestValue = findSmallestValue(current.right);
                current.value = smallestValue;
                // delete the right subtree
                current.right = deleteRecursive(current.right, smallestValue);
                return current;
            }
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private int findSmallestValue(BinaryTreeNode node) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    private BinaryTreeNode deleteIteratively(BinaryTreeNode root, int value) {
        BinaryTreeNode current = root;
        // previous is the predecessor
        BinaryTreeNode predecessor = null;
        while(current != null && current.value != value) {
            predecessor = current;
            if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (current == null) {
            System.out.println("Cannot find");
            return null;
        }

        // if the node has only one child
        if (current.left == null || current.right == null) {
            BinaryTreeNode newCurr;
            if (current.left == null) {
                newCurr = current.right;
            } else {
                newCurr = current.left;
            }
            if (predecessor == null) {
                return newCurr;
            }
            if (current.value == predecessor.left.value) {
                predecessor.left = newCurr;
            } else {
                predecessor.right = newCurr;
            }
        }
        else {
            BinaryTreeNode p = null;
            BinaryTreeNode temp;
            // compute the in-order successor
            temp = current.right;
            while(temp.left != null) {
                p = temp;
                temp = temp.left;
            }
            // check if the parent of the inorder
            // successor is the root or not.
            // if it isn't, then make the
            // left child of its parent equal to the
            // inorder successor's right child.
            if (p != null) {
                p.left = temp.right;
            } else {
                current.right = temp.right;
            }
            current.value = temp.value;
        }
        return root;
    }

    // Depth first search
    // root -> left sub-tree -> right sub-tree
    public void traversePreOrder(BinaryTreeNode node) {
        if (node != null) {
            System.out.println(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    // left sub-tree -> root -> right sub-tree
    public void traverseInOrder(BinaryTreeNode node) {
        if (node == null) {
            traverseInOrder(node.left);
            System.out.println(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    // left sub-tree -> right sub-tree -> root
    public void traversePostOrder(BinaryTreeNode node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.println(" " + node.value);
        }
    }

    public BinaryTreeNode invertBinaryTree(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stackTree = new Stack<>();
        stackTree.add(node);
        while (!stackTree.isEmpty()) {
            BinaryTreeNode current = stackTree.pop();
            if (current != null) {
                BinaryTreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;
                if (current.left != null) {
                    stackTree.add(current.left);
                }
                if (current.right != null) {
                    stackTree.add(current.right);
                }
            }
        }
        return node;
    }
}

