package Ex.search;

import java.util.*;

public class BFSExample {
    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    BFSExample(int vertices) {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();
    }

    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
    }

    void BFS(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            Iterator<Integer> it = adjLists[vertex].listIterator();
            while (it.hasNext()) {
                int adj = it.next();
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSExample g1 = new BFSExample(7);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 3);
        g1.addEdge(1, 4);
        g1.addEdge(2, 5);
        g1.addEdge(2, 6);
        System.out.println("BFS starting from vertex 0 (Example 1):");
        g1.BFS(0);

        BFSExample g2 = new BFSExample(10);
        g2.addEdge(0, 1);
        g2.addEdge(0, 3);
        g2.addEdge(1, 2);
        g2.addEdge(3, 4);
        g2.addEdge(3, 7);
        g2.addEdge(4, 5);
        g2.addEdge(4, 6);
        g2.addEdge(7, 8);
        g2.addEdge(8, 9);
        System.out.println("\nBFS starting from vertex 0 (Example 2):");
        g2.BFS(3);
    }
}