package Chapter4.TreesAndGraphs.Exercise2MnimalTree;


import Chapter4.TreesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity O(n)
 */
public class Solution {
    private static final List<TreeNode<Integer, Integer>> sortedOrder = new ArrayList<>();
    public static TreeNode<Integer, Integer> construct() {
        // sorted order is in order
        return sortedArrayToBST(0, sortedOrder.size() - 1);
    }

    // in order traversal
    private static TreeNode<Integer, Integer> sortedArrayToBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        var root = sortedOrder.get(mid);
        root.left = sortedArrayToBST(start, mid - 1);
        root.right = sortedArrayToBST(mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        sortedOrder.add(new TreeNode<>(1));
        sortedOrder.add(new TreeNode<>(2));
        sortedOrder.add(new TreeNode<>(3));
        sortedOrder.add(new TreeNode<>(4));
        sortedOrder.add(new TreeNode<>(5));
        sortedOrder.add(new TreeNode<>(6));
        sortedOrder.add(new TreeNode<>(7));
        System.out.println(construct().value);
    }
}
