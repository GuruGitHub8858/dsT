package tree;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeNode {
    int value;
    BinaryTreeNode left, right;

    public BinaryTreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}
public class Bt {
    BinaryTreeNode root;
    public Bt() {
        root = null;
    }
    public void inOrderTraversal(BinaryTreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);   // l
            System.out.print(node.value + " ");  // ro
            inOrderTraversal(node.right);// r
        }
    }
    // Pre-order traversal (root, left, right)
    public void preOrderTraversal(BinaryTreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
    // Post-order traversal (left, right, root)
    public void postOrderTraversal(BinaryTreeNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.value + " ");
        }
    }
    public void insert(int value) {  // 1
        BinaryTreeNode newNode = new BinaryTreeNode(value);
        if (root == null) {
            root = newNode;
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode current = queue.poll();
            
            if (current.left == null) {
                current.left = newNode;
                break;
            } else {
                queue.offer(current.left);
            }   
            if (current.right == null) {
                current.right = newNode;
                break;
            } else {
                queue.offer(current.right);
            }
        }
    }   
    public static void main(String[] args) {
        Bt tree = new Bt();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);      
        System.out.println("In-order Traversal: ");
        tree.inOrderTraversal(tree.root);
        System.out.println("\nPre-order Traversal: ");
        tree.preOrderTraversal(tree.root);
        System.out.println("\nPost-order Traversal: ");
        tree.postOrderTraversal(tree.root);
    }
}
