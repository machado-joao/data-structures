package stack;

public class Stack<T> {

    private Node<T> top;
    private int height;

    public void push(T value) {

        Node<T> newNode = new Node<>(value);

        if (this.height == 0) {
            this.top = newNode;
        } else {
            newNode.next = this.top;
            this.top = newNode;
        }

        this.height++;
    }

    public Node<T> pop() {

        if (this.height == 0) {
            return null;
        }

        Node<T> temp = this.top;
        this.top = this.top.next;
        temp.next = null;
        this.height--;

        return temp;
    }

    public Node<T> peek() {
        return this.top;
    }

    public void print() {

        Node<T> temp = this.top;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }

    }

}
