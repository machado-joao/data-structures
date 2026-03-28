package bst;

public class Node<T extends Comparable<T>> implements Comparable<T> {

    T value;
    Node<T> left;
    Node<T> right;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(T o) {
        return this.value.compareTo(o);
    }

}
