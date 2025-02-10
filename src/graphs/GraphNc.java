package graphs;

// Node class represents a vertex in the graph with a linked list of neighbors
class Node {
	int vertexNum; // Store the vertex number
	Node next; // Reference to the next node in the list

	// Constructor to initialize a node with a vertex number
	public Node(int vertexNum) {
		this.vertexNum = vertexNum; // Initialize the vertex number
		this.next = null; // Initialize the next node to null
	}
}

// List class represents a linked list to store adjacent vertices for each node
class List {
	Node head; // Head of the linked list

	// Constructor to initialize the list as empty

	// Method to add a node to the linked list
	public void addNode(int vertexNum) {
		Node newNode = new Node(vertexNum); // Create a new node with the given vertex number

		// If the list is empty, set the new node as the head
		if (head == null) {
			head = newNode;
		} else {
			// Traverse the list to find the last node
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			// Add the new node at the end of the list
			temp.next = newNode;
		}
	}

	// Method to print all nodes in the linked list
	public void printList() {
		Node temp = this.head; // Start at the head node
		while (temp != null) { // Traverse until the end of the list
			System.out.print(temp.vertexNum + " "); // Print the vertex number of the current node
			temp = temp.next; // Move to the next node
		}
	}
}

// GraphNc class represents a graph using an adjacency list
public class GraphNc {
	List[] adjList = new List[4]; // Array of adjacency lists (one for each vertex)

	public void addEdge(int s, int d) {
		// If the list for vertex 's' is null (empty), create a new list
		if (adjList[s] == null) {
			adjList[s] = new List(); // Create a new list for vertex 's'
			adjList[s].addNode(s); // Add the source vertex to its own list
		}
		// Add the destination vertex to the list of the source vertex
		adjList[s].addNode(d); // Add the destination vertex 'd' to the adjacency list of 's'
		if (adjList[d] == null) {
			adjList[d] = new List(); // Create a new list for vertex 's'
			adjList[d].addNode(d); // Add the source vertex to its own list
		}
		// Add the destination vertex to the list of the source vertex
		adjList[d].addNode(s); // Add the destination vertex 'd' to the adjacency list of 's'

	}

	// Method to print the adjacency list of all vertices in the graph
	public void printGraph(int maxNode) {
		for (int i = 0; i < maxNode; i++) { // Iterate over all vertices
			// If the list for the current vertex is not null (has neighbors) 
			if (adjList[i] != null) {
				System.out.print("Adjacency list for vertex " + i + ": ");
				adjList[i].printList(); // Print the adjacency list for the current vertex
				System.out.println(); // Print a new line after printing the list
			}
		}
	}

	// Main method to demonstrate the graph functionality
	public static void main(String[] args) {
		int maxNode = 4; // The maximum number of nodes in the graph
		GraphNc graph = new GraphNc(); // Create a new graph object

		// Adding edges to the graph
		graph.addEdge(0, 1); // Add an edge from vertex 0 to vertex 1
		graph.addEdge(0, 3); // Add an edge from vertex 0 to vertex 3
		graph.addEdge(1, 2); // Add an edge from vertex 1 to vertex 2

		graph.printGraph(maxNode); // Print the adjacency lists for all vertices
	}
}
