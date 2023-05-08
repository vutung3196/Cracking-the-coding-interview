package blind75.week1.balancedbinarytree;

public class Solution {
    public static void main(String[] args) {

    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public boolean isBalanced(TreeNode root) {
        // height left
        // height right
        int left;
        int right;
    }
}
