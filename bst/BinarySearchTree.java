package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

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

            if (newNode.compareTo(temp.value) == 0) {
                return false; // Duplicate value, do not insert
            }

            if (newNode.compareTo(temp.value) < 0) {
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
            int cmp = value.compareTo(temp.value);
            if (cmp < 0) {
                temp = temp.left;
            } else if (cmp > 0) {
                temp = temp.right;
            } else {
                return true;
            }
        }

        return false; // Either the tree is empty or the value was not found
    }

    // Breadth-First Search (BFS) traversal

    public List<T> breadthFirstSearch() {

        List<T> results = new ArrayList<>();

        if (this.root == null) {
            return results;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        Node<T> currentNode = this.root;
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

    // Depth-First Search (DFS) traversals

    public List<T> depthFirstSearchPreOrder() {

        List<T> results = new ArrayList<>();

        class Traverse {
            Traverse(Node<T> node) {
                results.add(node.value);
                if (node.left != null) {
                    new Traverse(node.left);
                }
                if (node.right != null) {
                    new Traverse(node.right);
                }
            }
        }

        if (this.root != null) {
            new Traverse(this.root);
        }

        return results;
    }

    public List<T> depthFirstSearchPostOrder() {

        List<T> results = new ArrayList<>();

        class Traverse {
            Traverse(Node<T> node) {
                if (node.left != null) {
                    new Traverse(node.left);
                }
                if (node.right != null) {
                    new Traverse(node.right);
                }
                results.add(node.value);
            }
        }

        if (this.root != null) {
            new Traverse(this.root);
        }

        return results;
    }

    public List<T> depthFirstSearchInOrder() {

        List<T> results = new ArrayList<>();

        class Traverse {
            Traverse(Node<T> node) {
                if (node.left != null) {
                    new Traverse(node.left);
                }
                results.add(node.value);
                if (node.right != null) {
                    new Traverse(node.right);
                }
            }
        }

        if (this.root != null) {
            new Traverse(this.root);
        }

        return results;
    }

}
