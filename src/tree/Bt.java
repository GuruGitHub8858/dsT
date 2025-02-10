package tree;
import java.util.*;
// Node Class
class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

// Binary Tree Implementation
class Bt {
    Node root;

    Node createNode(int data) {
        return new Node(data);
    }

    void insertNode(int data) {
        Node newNode = createNode(data);
        if (root == null) {
            root = newNode;
        } else {
            // Using level-order insertion for Binary Tree
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Node current = queue.poll();

                if (current.left == null) {
                    current.left = newNode;
                    break;
                } else {
                    queue.add(current.left);
                }

                if (current.right == null) {
                    current.right = newNode;
                    break;
                } else {
                    queue.add(current.right);
                }
            }
        }
    }

    Node searchNode(int data) {
        if (root == null) {
            return null;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.data == data) {
                return current;
            }

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return null;
    }

    // Traversal Methods
    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        Bt tree = new Bt();
        tree.insertNode(50);
        tree.insertNode(30);
        tree.insertNode(20);
        tree.insertNode(40);
        tree.insertNode(70);
        tree.insertNode(60);
        tree.insertNode(80);
        tree.insertNode(90);

        System.out.println("In-order Traversal:");
        tree.inOrder(tree.root);
        System.out.println();

        System.out.println("Pre-order Traversal:");
        tree.preOrder(tree.root);
        System.out.println();

        System.out.println("Post-order Traversal:");
        tree.postOrder(tree.root);
        System.out.println();

        int searchData = 20;
        Node searchResult = tree.searchNode(searchData);
        if (searchResult != null) {
            System.out.println(searchData + " found in the binary tree.");
        } else {
            System.out.println(searchData + " not found in the binary tree.");
        }
    }
}
