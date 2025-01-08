package stackCode;


class Node {
    int data;
    Node link;
}

class Stack {
    Node top;

    // Push operation
    void push(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.link = null;

        if (top == null) { // Stack is empty
            top = newNode;
        } else { // Non-empty stack
            newNode.link = top;
            top = newNode;
        }
    }

    // Pop operation
    int pop() {
        if (top == null) { // Stack is empty
            System.out.println("Stack Underflow");
            return -1;
        }

        int poppedData = top.data;
        top = top.link;
        return poppedData;
    }

    // Peek operation
    int peek() {
        if (top == null) { // Stack is empty
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    // Display stack
    void display() {
        if (top == null) { // Stack is empty
            System.out.println("Stack is empty");
            return;
        }

        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.link;
        }
        System.out.println();
    }
}

public class StackImp {
    public static void main(String[] args) {
        Stack stack = new Stack();

        System.out.println("Pushing elements into stack");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();

        System.out.println("Top element is: " + stack.peek());

        System.out.println("Popping element from stack: " + stack.pop());
        stack.display();

        System.out.println("Popping element from stack: " + stack.pop());
        stack.display();

        System.out.println("Popping element from stack: " + stack.pop());
        stack.display();

        System.out.println("Trying to pop from empty stack: " + stack.pop());
    }
}
