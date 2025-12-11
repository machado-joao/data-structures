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

    public boolean isEmpty() {
        return this.height == 0;
    }

    public static String reverseString(String str) {

        if (str == null || str.isEmpty()) {
            return str;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();

        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    public static boolean isBalanced(String str) {

        if (str == null || str.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {

                if (stack.isEmpty())
                    return false;

                char top = stack.pop().value;

                if (c == ')' && top != '(')
                    return false;
                if (c == '}' && top != '{')
                    return false;
                if (c == ']' && top != '[')
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public void print() {

        Node<T> temp = this.top;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }

    }

}
