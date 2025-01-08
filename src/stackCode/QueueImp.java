package stackCode;

class QNode{
	int data;
	QNode link;
}
class QueueMethods{
	QNode front,rear;
	public void enqueue(int data)
	{
		QNode newNode=new QNode();// creating new node
		newNode.data=data;//6
		newNode.link=null;//null
		if(front==null)
		{
//			System.out.println("empty Queue");
			front=rear=newNode;
		}
		else {
			rear.link=newNode;
			rear=newNode;
		}
	}
	public int dequeue()
	{
		
		int data=front.data;
		
		front=front.link;
		
		return data;
	}
	public void displayList()
	{
		QNode temp=front;
		while(temp!=null)
		{
			System.out.println(temp.data+" ");
			temp=temp.link;
		}
		System.out.println();
	}
	
}
public class QueueImp extends QueueMethods {
     public static void main(String[] args) {
		QueueImp qu=new QueueImp();
		qu.enqueue(5);
		qu.enqueue(6);
		
		qu.dequeue();
		qu.displayList();
	}
}
