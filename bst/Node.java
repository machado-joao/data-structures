package bst;

public class Node<T> implements Comparable<T> {

    T value;
    Node<T> left;
    Node<T> right;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public int compareTo(T o) {
        if (this.value instanceof Comparable) {
            return ((Comparable<T>) this.value).compareTo(o);
        } else {
            throw new IllegalArgumentException("Value must be comparable");
        }
    }

}
