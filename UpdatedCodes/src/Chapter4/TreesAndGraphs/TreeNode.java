package Chapter4.TreesAndGraphs;

public class TreeNode<K, V> {
    public K key;
    public V value;
    public TreeNode<K, V> left, right;
    public int size;

    /**
     * Using for Queue
     */
    public TreeNode<K, V> next;

    public TreeNode(V value) {
        this.value = value;
    }

    public TreeNode() {

    }

    public TreeNode(K key, V value, int size) {
        this.key = key;
        this.value = value;
        this.size = size;
    }
}
