package LinkedList;

// node declaration
class Node
{
	int data;
	Node link;	
}
class Karthi 
{
	Node head;
    void insertAtBegin(int data)  // data =2
	{
    	//node creation
        Node newNode=new Node();
        newNode.data=data;
        newNode.link=null;
        //my list is empty
        if(head==null)
        {
        	head=newNode;
        }
        else {
        	newNode.link=head;
        	head=newNode;
        }      
	}
     void deletionAtEnd()
     {
    	 Node temp=head;	 
    	 while(temp.link.link!=null)
    	 {
    		 temp=temp.link;
    	 }
    	 temp.link=null;
    	 
     }
	void insertAtEnd(int data)
	{
    	Node newNode=new Node();
    	newNode.data=data;  // 11
    	newNode.link=null;
        if(head==null)       //empty list
        {
        	head=newNode;
        }
        else {
        	Node temp=head;
        	while(temp.link!=null)
        	{
        		temp=temp.link;
        	}
        	temp.link=newNode;
        }
       
	}
    
    void insertAtPos(int pos,int data)
    {
    	Node newNode=new Node();
    	newNode.data=data;
    	newNode.link=null;
    	Node temp=head;
    	if(pos==0)
    	{
    		insertAtBegin(data);
    		return;
    	}	
    	for(int i=1;i<=pos-1;i++)
    	{
    		temp=temp.link;
    		if(temp==null)
    		{
    			System.out.println("invalid input");
    			return;
    		}
    	}
    	newNode.link=temp.link;
    	temp.link=newNode;
    }
    void deleteAtBegin()
    {
    	head=head.link;
    	
    }
    void deleteAtPos(int pos) {
        if (pos == 0) {
            deleteAtBegin();
            return;
        }

        Node temp = head;
        Node pre = null;

        for (int i = 1; i <= pos; i++) {
            if (temp == null) {
                System.out.println("Invalid input");
                return;
            }
            pre = temp;
            temp = temp.link;
        }

        if (temp == null) {
            System.out.println("Invalid input");
            return;
        }

        pre.link = temp.link;
    }

    
    void displayList()
    {
    	Node temp=head;
    	while(temp!=null)
    	{
    		System.out.print(temp.data+" ");
    		temp=temp.link;
    	}
    	System.out.println();
    }
    
}
public class SingleLinkedList extends Karthi
{
	public static void main(String[] args) {
		SingleLinkedList list=new SingleLinkedList();
		
		System.out.println("insertion at begining");
	    list.insertAtBegin(5);
	    list.insertAtBegin(9);
	    list.insertAtBegin(10);
	    list.displayList();
	    System.out.println("insertion at point");
	    list.insertAtPos(3, 25);
        list.displayList();	
        System.out.println("isertion at end");
        list.insertAtEnd(6);
        list.displayList();
        System.out.println("deletion at pos");
        list.deleteAtPos(1);
        list.displayList();
        System.out.println("deletion at begin");
        list.deleteAtBegin();
        list.displayList();
        System.out.println("deletion at End");
        list.deletionAtEnd();
        list.displayList();
   
        
	}

}
