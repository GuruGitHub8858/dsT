package LinkedList;

class DubNode {
    int data;
    DubNode prev; // Reference to the previous DubNode
    DubNode next; // Reference to the next DubNode
}

class DoublyMethods extends DubNode {
    DubNode head ;
    DubNode tail;

    void insertAtBegin(int data)
    {
        DubNode newDubNode = new DubNode();
        newDubNode.data = data;   //1
        newDubNode.next=null;
        newDubNode.prev=null;
        if (head == null) 
        {
        	head = newDubNode;  
        	tail=newDubNode;
        }
        else
        {   
        	
            newDubNode.next=head;
            head.prev=newDubNode;
            head=newDubNode;
            
        }
    }

    void insertAtEnd(int data) {
        DubNode newDubNode = new DubNode();
        newDubNode.data = data;
        newDubNode.next = null;
        newDubNode.prev = null;
        if (head == null) {
            insertAtBegin(data);
            return;
        }

        else {
        	tail.next=newDubNode;
        	newDubNode.prev=tail;
        	tail=newDubNode;
        }
    }

    void insertAtPos(int pos, int data) {
        if (pos == 0) 
        {
            insertAtBegin(data);
            return;
        }

        DubNode newDubNode = new DubNode();
        newDubNode.data = data;
        DubNode temp = head;
        for (int i = 1; i <=pos-1; i++) 
        { // jump to prev node
            
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid input");
            return;
        }

        newDubNode.next = temp.next;
        temp.next.prev=newDubNode;
        temp.next = newDubNode;
        newDubNode.prev = temp;

      
    }

    void deleteAtBegin() {
        if (head == null) {
        	System.out.println("list is empty");
            return;
        }

        head = head.next;

        if (head != null) {
            head.prev = null;
        }
    }

    void deleteAtPos(int pos) 
    {
    	  if (head == null) {
          	System.out.println("list is empty");
              return;
    	  }
        if (pos == 0) {
            deleteAtBegin();
            return;
        }
        
        DubNode temp = head;
        DubNode prev=null;
        for (int i = 1; i <= pos; i++) {
            if (temp == null) {
                System.out.println("Invalid input");
                return;
            }
            prev=temp;
            temp = temp.next;
        }
        
       prev.next=temp.next;
       temp.next.prev=prev;
    }
    
    void deletionAtEnd()
    {
        
        if(head==null)
        {
        	System.out.println("There is no list");
        }
        else {
        	tail=tail.prev;
        	tail.next.prev=null;
        	tail.next=null;
        }
    }
    void displayList() {
    	if(head==null)
    	{
    		System.out.println("list is empty");
    	}
        DubNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next; //jump
        }
        System.out.println();
    }
    void displayRevList() {
        DubNode temp = tail;// Start from the tail
       
         while(temp!=null) {
            System.out.print(temp.data + " ");
            temp = temp.prev; // Move to the previous node
        }
        System.out.println();
    }
    

}

public class DoublyLinkedList extends DoublyMethods {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        System.out.println(list.tail);
        
        System.out.println("insertion at beginning");
        list.insertAtBegin(5);
        list.insertAtBegin(9);
        list.insertAtBegin(10);
        list.displayList();
        System.out.println("reverse doubly");
        list.displayRevList();    
        System.out.println("insertion at point");
        list.insertAtPos(2, 25);
        list.displayList();
        System.out.println("reverse doubly");
        list.displayRevList();
        System.out.println("insertion at end");
        list.insertAtEnd(6);
        list.insertAtEnd(8);
        list.displayList();
        System.out.println("reverse doubly");
        list.displayRevList();
        System.out.println("deletion at pos");
        list.deleteAtPos(2);
        list.displayList();
        System.out.println("reverse doubly");
        list.displayRevList();
        System.out.println("deletion at beginning");
        list.deleteAtBegin();
        list.displayList();
        System.out.println("reverse doubly");
        list.displayRevList();
        System.out.println("deletion at End");
        list.deletionAtEnd();
        list.displayList();
        System.out.println("reverse doubly");
        list.displayRevList();
    }
}
