package stack;

class Node<E> implements Comparable<Node<E>> {

    E value;
    Node<E> next;

    Node(E value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public int compareTo(Node<E> o) {
        if (this.value instanceof Comparable && o.value instanceof Comparable) {
            return ((Comparable<E>) this.value).compareTo(o.value);
        }
        throw new IllegalArgumentException("Values must be comparable");
    }

}
