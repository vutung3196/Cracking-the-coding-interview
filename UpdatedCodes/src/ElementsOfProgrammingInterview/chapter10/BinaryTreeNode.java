package ElementsOfProgrammingInterview.chapter10;

public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left, right;
    // for exercise 16
    public BinaryTreeNode<T> next;
    public int size;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

