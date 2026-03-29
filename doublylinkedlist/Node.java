package doublylinkedlist;

public class Node<E> {

    E value;
    Node<E> next;
    Node<E> previous;

    Node(E value) {
        this.value = value;
    }

}
