package Ex.graph;

import java.util.ArrayList;
import java.util.List;

class DirectedGraph {
    private List<List<Integer>> adjList;

    public DirectedGraph(int vertices) {
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v); // Add v to u's list
    }

    public void printGraph() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print("Vertex " + i + ": ");
            for (Integer v : adjList.get(i)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}

public class  DirectedGraphMain{
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
    }
}

