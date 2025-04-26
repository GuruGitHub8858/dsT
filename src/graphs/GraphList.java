package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphList {
    static List<List<Integer>> al = new ArrayList<>();

    public GraphList(int V) {
        for (int i = 0; i < V; i++) {
            al.add(new ArrayList<>());
        }
    }

    public void addEdge(int s, int d) {
        al.get(s).add(d);
        al.get(d).add(s);
    }

    void BFS(int start) {
        boolean[] visited = new boolean[al.size()];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            List<Integer> neigh = al.get(current);

            for (int i = 0; i < neigh.size(); i++) {
                int data = neigh.get(i);
                if (!visited[data]) {
                    visited[data] = true;
                    queue.add(data);
                }
            }
        }
    }

    void displayGraph() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < al.size(); i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < al.get(i).size(); j++) {
                System.out.print(al.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    void DFSRec(boolean[] visited, int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int neighbor : al.get(node)) {
            if (!visited[neighbor]) {
                DFSRec(visited, neighbor);
            }
        }
    }

    void DFS(int start) {
        boolean[] visited = new boolean[al.size()];
        DFSRec(visited, start);
    }

    public static void main(String[] args) {
        GraphList g = new GraphList(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 3);

        g.displayGraph();

        System.out.print("BFS Traversal: ");
        g.BFS(1);
        System.out.println();

        System.out.print("DFS Traversal: ");
        g.DFS(0);
        System.out.println();
    }
}
