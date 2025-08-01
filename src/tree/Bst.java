package tree;

//TNode Class
class TNode {
 int data;
 TNode left, right;

 TNode(int value) {
     data = value;
     left = right = null;
 }
}
class Bst {
 TNode root;

 TNode createTNode(int data) {
     return new TNode(data);
 }

 void insertTNode(int data) {
     TNode newTNode = createTNode(data);
     if (root == null) {
         root = newTNode;
     } else {
         TNode current = root;
         while (true) {
             if (data <= current.data) {
                 if (current.left == null) {
                     current.left = newTNode;
                     break;
                 } else {
                     current = current.left;
                 }
             } else {
                 if (current.right == null) {
                     current.right = newTNode;
                     break;
                 } else {
                     current = current.right;
                 }
             }
         }
     }
 }

 TNode searchTNode(int data) {
     TNode current = root;
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
 void inOrder(TNode node) {
     if (node != null) {
         inOrder(node.left);
         System.out.print(node.data + " ");
         inOrder(node.right);
     }
 }

 void preOrder(TNode node) {
     if (node != null) {
         System.out.print(node.data + " ");
         preOrder(node.left);
         preOrder(node.right);
     }
 }

 void postOrder(TNode node) {
     if (node != null) {
         postOrder(node.left);
         postOrder(node.right);
         System.out.print(node.data + " ");
     }
 }

 public static void main(String[] args) {
     Bst tree = new Bst();
     tree.insertTNode(90);
     tree.insertTNode(20);
     tree.insertTNode(30);
     tree.insertTNode(120);
     tree.insertTNode(240);
     tree.insertTNode(310);
     tree.insertTNode(23);

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
     TNode searchResult = tree.searchTNode(searchData);
     if (searchResult != null) {
         System.out.println(searchData + " found in the binary tree.");
     } else {
         System.out.println(searchData + " not found in the binary tree.");
     }
 }
}