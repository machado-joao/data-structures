package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<T> {

    Node<T> root;

    /*
     * The empty constructor is redundant, but it is included for clarity. It
     * initializes the root of the binary search tree to null, indicating that the
     * tree is initially empty. The second constructor allows for the creation of a
     * binary search tree with an initial value, setting the root node to a new Node
     * containing that value.
     */

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(T value) {
        this.root = new Node<>(value);
    }

    public boolean insert(T value) {

        Node<T> newNode = new Node<>(value);
        if (this.root == null) {
            this.root = newNode;
            return true;
        }

        Node<T> temp = this.root;
        while (true) {

            if (newNode.value == temp.value) {
                return false; // Duplicate value, do not insert
            }

            if (newNode.value.toString().compareTo(temp.value.toString()) < 0) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(T value) {

        Node<T> temp = this.root;
        while (temp != null) {
            if (value.toString().compareTo(temp.value.toString()) < 0) {
                temp = temp.left;
            } else if (value.toString().compareTo(temp.value.toString()) > 0) {
                temp = temp.right;
            } else {
                return true;
            }
        }

        return false; // Either the tree is empty or the value was not found
    }

    // Breadth-First Search (BFS) traversal

    public List<T> breadthFirstSearch() {

        Node<T> currentNode = this.root;
        Queue<Node<T>> queue = new LinkedList<>();
        List<T> results = new ArrayList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            results.add(currentNode.value);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        return results;
    }

}
