package LinkedList;
//node class
class Node{
	int data; //1
	Node next; // he is just a reference variable for node class
	//he inilize the iv
	public Node(int data) {  //1
		this.data=data;
		next=null;
	}
}
// method class
class Methods{
    static Node head=null; 
    static int count=0;
    
	public static void insertAtBeg(int data) {  //1
		Node newNode=new Node(data); //1
		if(head==null) {
			head=newNode;
		}
		else {
			newNode.next=head;
			head=newNode;
		}		
		count++;
	}
	
	public static void insertAtPos(int pos,int data) {
		Node newNode=new Node(data);
		
		if(pos==0) insertAtBeg(data);
		else {
			Node temp=head;
			
			for(int i=1;i<pos;i++) {
				temp=temp.next;
			}
			newNode.next=temp.next;
			temp.next=newNode;
		}
		count++;
	}
	
	public static void insertAtEnd(int data) {
		Node newNode=new Node(data);
	    Node temp=head;
	    if(head==null)
	    {
	    	insertAtBeg(data);
	    }
	    else {
	    	while(temp.next!=null) {
	    		temp=temp.next;
	    	}
	    	temp.next=newNode;
	    }
	    count++;
	}
	public static void display() {
     Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
		System.out.println("the length of the list:"+count);
	}
	
	public static void deleteAtBeg() {
		Node temp=head;
		head=head.next;
		temp.next=null;
		count--;
	}
	public static void deleteAtPos(int pos) {
		Node temp=head;
		if(pos==0) deleteAtBeg();
		for(int i=1;i<pos;i++)
		{
			temp=temp.next;
		}
		temp.next=temp.next.next;
		count--;
	}
	public static void deleteAtEnd() {
		Node temp=head;
		while(temp.next.next!=null) {
			temp=temp.next;
		}
		temp.next=null;
		count--;
	}
	
}
//main class
public class SingleLinkedList extends Methods{
    public static void main(String[] args) {
		insertAtBeg(0);
		insertAtBeg(1);
		insertAtBeg(2);
		insertAtBeg(3);
		insertAtEnd(10);
		insertAtEnd(20);
		insertAtEnd(30);
		
		insertAtPos(2,100);
		
		deleteAtBeg();
		deleteAtEnd();
		deleteAtPos(2);
		display();
	}
}