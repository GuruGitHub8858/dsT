package graphs;

class Node {
    int vertexNum;
    Node next;

    public Node(int vertexNum) {
        this.vertexNum = vertexNum;
        this.next = null;
    }
}

class List {
    Node head;

    public void addNode(int vertexNum) {
        Node newNode = new Node(vertexNum);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.vertexNum + " ");
            temp = temp.next;
        }
    }
}

public class GraphNc {
    List[] adjList = new List[4];

    public void addEdge(int s, int d) {
        if (adjList[s] == null) {
            adjList[s] = new List();
            adjList[s].addNode(s);
        }
        adjList[s].addNode(d);

        if (adjList[d] == null) {
            adjList[d] = new List();
            adjList[d].addNode(d);
        }
        adjList[d].addNode(s);
    }

    public void printGraph(int maxNode) {
        for (int i = 0; i < maxNode; i++) {
            if (adjList[i] != null) {
                System.out.print("Adjacency list for vertex " + i + ": ");
                adjList[i].printList();
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int maxNode = 4;
        GraphNc graph = new GraphNc();

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);

        graph.printGraph(maxNode);
    }
}
