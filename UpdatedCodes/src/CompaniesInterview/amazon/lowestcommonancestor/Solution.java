package CompaniesInterview.amazon.lowestcommonancestor;

public class Solution {
    public static void main(String[] args) {
    }

    private Node ans;

    private class Node {
        int val;
        Node left;
        Node right;
        Node (int x) {
            this.val = x;
        }
    }

    /**
     * Given a binary tree,
     * find the lowest common ancestor (LCA) of two given nodes in the tree.
     * According to the definition of LCA on Wikipedia:
     * “The lowest common ancestor is defined between two nodes p and q
     * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     * @param currentNode
     * @param p
     * @param q
     * @return
     */
    public boolean lowestCommonAncestorRecursion(Node currentNode, Node p, Node q) {
        if (currentNode == null) {
            return false;
        }

        // left recursion
        int left = this.lowestCommonAncestorRecursion(currentNode.left, p, q) ? 1 : 0;

        // right recursion
        int right = this.lowestCommonAncestorRecursion(currentNode.right, p, q) ? 1 : 0;

        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        return (mid + left + right > 0);
    }

    public Node lowestCommonAncestor(Node currentNode, Node p, Node q) {
        lowestCommonAncestorRecursion(currentNode, p, q);
        return this.ans;
    }
}
