package test;

import implementation.BinaryTree;
import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {
    @Test
    public void givenABinaryTree_WhenAddingElements_ThenTreeContainsThoseElements() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(4);
        binaryTree.add(5);
        Assert.assertTrue(binaryTree.containsNode(1));
        Assert.assertTrue(binaryTree.containsNode(2));
        Assert.assertTrue(binaryTree.containsNode(3));
        Assert.assertTrue(binaryTree.containsNode(4));
        Assert.assertTrue(binaryTree.containsNode(5));
        Assert.assertFalse(binaryTree.containsNode(6));
    }

    @Test
    public void givenABinaryTree_WhenDeletingElements_ThenNotContainThoseElements() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(1);
        binaryTree.add(2);
        binaryTree.add(3);
        Assert.assertTrue(binaryTree.containsNode(1));
        Assert.assertTrue(binaryTree.containsNode(2));
        Assert.assertTrue(binaryTree.containsNode(3));
        binaryTree.delete(3);
        Assert.assertFalse(binaryTree.containsNode(3));
    }
}