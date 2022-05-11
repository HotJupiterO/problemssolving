package leetcode.com.stream_data;

public class RedBlackTree<T> {
    Node<T> node;

    public RedBlackTree() {


    }

    public Node<T> searchNode(T value) {
        return this.node;
    }

    public void insertNode(T value) {

    }

    public void deleteNode(T value) {

    }

    public T getMedian() {
        return this.node.value;
    }
}

class Node<T> {
    /**
     * Red color = true
     * Black color = false
     */
    boolean color;
    Node<T> parent;
    Node<T> left;
    Node<T> right;
    T value;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
