package stack;

class Node<E> {

    E value;
    Node<E> next;

    Node(E value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

}
