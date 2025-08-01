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
	static BinaryTreeNode root;

	public Bt() {
		root = null;
	}

	public static void inOrderTraversal(BinaryTreeNode node) {
		if (node != null) {
			inOrderTraversal(node.left); // l
			System.out.print(node.value + " "); // ro
			inOrderTraversal(node.right);// r
		}
	}

	// Pre-order traversal (root, left, right)
	public static void preOrderTraversal(BinaryTreeNode node) {
		if (node != null) {
			System.out.print(node.value + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}

	// Post-order traversal (left, right, root)
	public static void postOrderTraversal(BinaryTreeNode node) {
		if (node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.value + " ");
		}
	}

	public static void insert(int value) { // 1
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
		insert(71);
		insert(110);
		insert(15);
		insert(8);
		insert(20);
		insert(12);
		insert(6);
		System.out.println("In-order Traversal: ");
		inOrderTraversal(root);
		System.out.println("\nPre-order Traversal: ");
		preOrderTraversal(root);
		System.out.println("\nPost-order Traversal: ");
		postOrderTraversal(root);
	}
}
