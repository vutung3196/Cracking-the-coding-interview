package blind75.week1.lowestcommonancestor;

public class Solution {
    public static void main(String[] args) {

    }
    
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // finding the lowest common ancestor node of two given nodes
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    public static TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        // traverse the tree
        while (node != null) {
            if (p.val > node.val && q.val > node.val) {
                node = node.right;
            } else if (p.val < node.val && q.val < node.val) {
                node = node.left;
            } else {
                return node;
            }
        }

        return null;
    }
}
