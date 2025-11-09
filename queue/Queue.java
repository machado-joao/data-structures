package queue;

public class Queue<T> {

    private Node<T> first;
    private Node<T> last;
    private int length;

    public void enqueue(T value) {

        Node<T> newNode = new Node<>(value);

        if (this.length == 0) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }

        this.length++;

    }

    public Node<T> dequeue() {

        if (this.length == 0) {
            return null;
        }

        Node<T> temp = this.first;
        if (this.length == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.next;
            temp.next = null;
        }

        this.length--;

        return temp;
    }

    public void print() {

        Node<T> temp = this.first;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }

    }

}
