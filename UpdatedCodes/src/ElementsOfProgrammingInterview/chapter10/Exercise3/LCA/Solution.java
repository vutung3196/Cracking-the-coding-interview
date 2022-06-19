package ElementsOfProgrammingInterview.chapter10.Exercise3.LCA;

import ElementsOfProgrammingInterview.chapter10.BinaryTree;
import ElementsOfProgrammingInterview.chapter10.BinaryTreeNode;

public class Solution {
    private static class Status {
        // if numTargetNodes == 2 => return LCA;
        public int numTargetNodes;
        public BinaryTreeNode<Integer> ancestor;

        public Status(int numTargetNodes, BinaryTreeNode<Integer> ancestor) {
            this.numTargetNodes = numTargetNodes;
            this.ancestor = ancestor;
        }
    }

    // least common ancestor
    public static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> treeNode,
                                              BinaryTreeNode<Integer> node0,
                                              BinaryTreeNode<Integer> node1) {
        return LCAHelper(treeNode, node0, node1).ancestor;
    }

    private static Status LCAHelper(BinaryTreeNode<Integer> treeNode,
                                    BinaryTreeNode<Integer> node0,
                                    BinaryTreeNode<Integer> node1) {
        if (treeNode == null) {
            return new Status(0, null);
        }

        Status leftResult = LCAHelper(treeNode.left, node0, node1);
        if (leftResult.numTargetNodes == 2) {
            return leftResult;
        }

        Status rightResult = LCAHelper(treeNode.right, node0, node1);
        if (rightResult.numTargetNodes == 2) {
            return rightResult;
        }
        int numTargetNodes = leftResult.numTargetNodes + rightResult.numTargetNodes
                + (treeNode == node0 ? 1 : 0) + (treeNode == node1 ? 1 : 0);
        return new Status(numTargetNodes, numTargetNodes == 2 ? treeNode : null);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTreeNode<>(1);
        tree.root.left = new BinaryTreeNode<>(2);
        tree.root.right = new BinaryTreeNode<>(3);
        tree.root.left.left = new BinaryTreeNode<>(4);
        tree.root.left.right = new BinaryTreeNode<>(5);
        tree.root.right.right = new BinaryTreeNode<>(6);
        tree.root.right.left = new BinaryTreeNode<>(7);
        var result = LCA(tree.root, tree.root.left.left, tree.root.right.left);
        System.out.println(result.data);
    }
}
