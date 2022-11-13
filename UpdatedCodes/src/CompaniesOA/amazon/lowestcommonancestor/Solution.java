package CompaniesOA.amazon.lowestcommonancestor;

public class Solution {
    public static void main(String[] args) {

    }

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
     * @param root
     * @param p
     * @param q
     * @return
     */
    public Node lowestCommonAncestor(Node root, Node p, Node q) {

        return new Node(1);
    }
}
