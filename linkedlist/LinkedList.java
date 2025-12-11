package linkedlist;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int length;

    public void append(T value) {

        Node<T> newNode = new Node<>(value);

        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }

        this.length++;
    }

    public Node<T> removeLast() {

        if (this.length == 0) {
            return null;
        }

        Node<T> temp = this.head;
        Node<T> pre = this.head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        this.tail = pre;
        this.tail.next = null;
        this.length--;

        if (this.length == 0) {
            this.head = null;
            this.tail = null;
        }

        return temp;
    }

    public void prepend(T value) {

        Node<T> newNode = new Node<>(value);

        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }

        this.length++;
    }

    public Node<T> removeFirst() {

        if (this.length == 0) {
            return null;
        }

        Node<T> temp = this.head;
        this.head = this.head.next;
        temp.next = null;
        this.length--;

        if (this.length == 0) {
            this.tail = null;
        }

        return temp;
    }

    public Node<T> get(int index) {

        if (index < 0 || index >= this.length) {
            return null;
        }

        Node<T> temp = this.head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
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
        Node<T> temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
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

        Node<T> prev = get(index - 1);
        Node<T> temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        this.length--;

        return temp;
    }

    public void reverse() {

        if (this.length <= 1) {
            return;
        }

        Node<T> prev = null;
        Node<T> current = this.head;
        this.tail = this.head;

        while (current != null) {
            Node<T> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        this.head = prev;
    }

    // Floyd’s Tortoise and Hare algorithms

    public Node<T> findMiddle() {

        if (this.length == 0) {
            return null;
        }

        Node<T> slow = this.head;
        Node<T> fast = this.head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean hasLoop() {

        Node<T> slow = this.head;
        Node<T> fast = this.head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public Node<T> findKthFromEnd(int k) {

        if (k <= 0 || k > this.length || this.length == 0) {
            return null;
        }

        if (k == this.length) {
            return this.head;
        }

        Node<T> slow = this.head;
        Node<T> fast = this.head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    // Runner technique

    public void removeDuplicatesRunner() {

        Node<T> current = this.head;

        while (current != null) {

            Node<T> runner = current;

            while (runner.next != null && runner.next != null) {
                if (Objects.equals(runner.next.value, current.value)) {
                    runner.next = runner.next.next;
                    this.length -= 1;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public void removeDuplicates() {

        if (this.head == null) {
            return;
        }

        Set<T> values = new HashSet<>();

        Node<T> previous = null;
        Node<T> current = this.head;

        while (current != null) {

            if (values.contains(current.value)) {
                previous.next = current.next;
                this.length -= 1;
            } else {
                values.add(current.value);
                previous = current;
            }
            current = current.next;
        }

    }

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }

    public int getLength() {
        return this.length;
    }

    public void print() {

        Node<T> temp = this.head;
        StringJoiner joiner = new StringJoiner(", ");

        while (temp != null) {
            joiner.add(temp.value.toString());
            temp = temp.next;
        }

        System.out.println(joiner.toString());
    }

}
