
package LinkedList;

class CircDubNode{
    int data;
    CircDubNode next;
    CircDubNode prev; // New 'prev' pointer for the doubly linked list.

    public CircDubNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null; // Initialize 'prev' to null for a new node.
    }
}

class CircDubMethods {
    CircDubNode head;

     CircDubMethods() {
        head = null;
    }

    void insert(int data) {
        CircDubNode newNode = new CircDubNode(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head; // Pointing to itself for a single node circular doubly linked list.
        } else {
            CircDubNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
            newNode.next = head;
            head.prev = newNode; // Update head's 'prev' to the newly added node.
        }
    }

    void insertAtEnd(int data) {
        CircDubNode newNode = new CircDubNode(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head; // Pointing to itself for a single node circular doubly linked list.
        } else {
            CircDubNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
            newNode.next = head;
            head.prev = newNode; // Update head's 'prev' to the newly added node.
            head = newNode; // Update head to the newly added node to maintain the circular structure.
        }
    }

    void insertAtPosition(int pos, int data) {
        if (pos <= 0) {
            insert(data);
        } else {
            CircDubNode newNode = new CircDubNode(data);
            if (head == null) {
                head = newNode;
                head.next = head;
                head.prev = head; // Pointing to itself for a single node circular doubly linked list.
            } else {
                CircDubNode temp = head;
                for (int i = 1; i < pos; i++) {
                    temp = temp.next;
                    if (temp == head) {
                        System.out.println("Invalid position");
                        return;
                    }
                }
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next.prev = newNode; // Update 'prev' of the next node.
                temp.next = newNode;
            }
        }
    }

    void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == head) {
            head = null;
        } else {
            head.next.prev = head.prev;
            head.prev.next = head.next;
            head = head.next; // Move head to the next node.
        }
    }

    void deleteAtPosition(int pos) {
        if (pos <= 0 || head == null) {
            deleteAtBeginning();
        } else {
            CircDubNode temp = head;
            for (int i = 1; i <= pos; i++) {
                temp = temp.next;
                if (temp == head) {
                    System.out.println("Invalid position");
                    return;
                }
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        CircDubNode temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
    
}

public class CircDoubList extends CircDubMethods {
    public static void main(String[] args) {
        CircLinkedList list = new CircLinkedList();
        System.out.println("insertion at beginning");
        list.insert(5);
        list.insert(9);
        list.insert(10);
        list.display();

        System.out.println("insertion at end");
        list.insertAtEnd(15);
        list.display();

        System.out.println("insertion at position");
        list.insertAtPosition(2, 7);
        list.display();

        System.out.println("deletion at beginning");
        list.deleteAtBeginning();
        list.display();

        System.out.println("deletion at position");
        list.deleteAtPosition(2);
        list.display();
    }
}
