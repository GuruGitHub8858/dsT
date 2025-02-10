package tree;

//Node Class
class Node {
 int data;
 Node left, right;

 Node(int value) {
     data = value;
     left = right = null;
 }
}

//Binary Tree Implementation
class Bst {
 Node root;

 Node createNode(int data) {
     return new Node(data);
 }

 void insertNode(int data) {
     Node newNode = createNode(data);
     if (root == null) {
         root = newNode;
     } else {
         Node current = root;
         while (true) {
             if (data <= current.data) {
                 if (current.left == null) {
                     current.left = newNode;
                     break;
                 } else {
                     current = current.left;
                 }
             } else {
                 if (current.right == null) {
                     current.right = newNode;
                     break;
                 } else {
                     current = current.right;
                 }
             }
         }
     }
 }

 Node searchNode(int data) {
     Node current = root;
     while (current != null) {
         if (data == current.data) {
             return current;
         } else if (data < current.data) {
             current = current.left;
         } else {
             current = current.right;
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
     Bst tree = new Bst();
     tree.insertNode(50);
     tree.insertNode(30);
     tree.insertNode(20);
     tree.insertNode(40);
     tree.insertNode(70);
     tree.insertNode(60);
     tree.insertNode(80);

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
