package doublylinkedlist;

import java.util.Objects;
import java.util.StringJoiner;

public class DoublyLinkedList<T> {

    Node<T> head;
    Node<T> tail;
    int length;

    public void append(T value) {

        Node<T> newNode = new Node<>(value);

        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.previous = this.tail;
            this.tail = newNode;
        }
        this.length++;
    }

    public Node<T> removeLast() {

        if (this.length == 0) {
            return null;
        }

        Node<T> temp = this.tail;

        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.previous;
            this.tail.next = null;
            temp.previous = null;
        }
        this.length--;

        return temp;
    }

    public void prepend(T value) {

        Node<T> newNode = new Node<>(value);

        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.previous = newNode;
            this.head = newNode;
        }
        this.length++;
    }

    public Node<T> removeFirst() {

        if (this.length == 0) {
            return null;
        }

        Node<T> temp = this.head;

        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.previous = null;
            temp.next = null;
        }
        this.length--;

        return temp;
    }

    public Node<T> get(int index) {

        if (index < 0 || index >= this.length) {
            return null;
        }

        Node<T> temp = null;

        if (index < this.length / 2) {
            temp = this.head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = this.tail;
            for (int i = this.length - 1; i > index; i--) {
                temp = temp.previous;
            }
        }

        return temp;
    }

    public boolean set(int index, T value) {

        Node<T> temp = get(index);

        if (temp != null) {
            temp.value = value;
            return true;
        }

        return false;
    }

    public boolean insert(int index, T value) {

        if (index < 0 || index > this.length) {
            return false;
        }

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == this.length) {
            append(value);
            return true;
        }

        Node<T> newNode = new Node<>(value);
        Node<T> before = get(index - 1);
        Node<T> after = before.next;
        newNode.previous = before;
        newNode.next = after;
        before.next = newNode;
        after.previous = newNode;
        this.length++;

        return true;
    }

    public Node<T> remove(int index) {

        if (index < 0 || index >= this.length) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == this.length - 1) {
            return removeLast();
        }

        Node<T> temp = get(index);
        temp.previous.next = temp.next;
        temp.next.previous = temp.previous;
        temp.next = null;
        temp.previous = null;
        this.length--;

        return temp;
    }

    public boolean isPalindrome() {

        if (this.length <= 1) {
            return true;
        }

        Node<T> left = this.head;
        Node<T> right = this.tail;

        for (int i = 0; i < this.length / 2; i++) {
            if (!Objects.equals(left.value, right.value)) {
                return false;
            }
            left = left.next;
            right = right.previous;
        }

        return true;
    }

    public void reverse() {

        if (this.length <= 1) {
            return;
        }

        Node<T> current = this.head;
        Node<T> temp = null;

        while (current != null) {
            temp = current.previous;
            current.previous = current.next;
            current.next = temp;
            current = current.previous;
        }
        temp = this.head;
        this.head = this.tail;
        this.tail = temp;
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (tail == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void print() {

        Node<T> temp = head;
        StringJoiner joiner = new StringJoiner(", ");

        while (temp != null) {
            joiner.add(temp.value.toString());
            temp = temp.next;
        }

        System.out.println(joiner.toString());
    }

}
