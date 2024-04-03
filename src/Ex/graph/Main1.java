package Ex.graph;

import java.util.ArrayList;
import java.util.List;

class Edge1 {
    int source;
    int destination;
    Integer weight;

    Edge1(int source, int destination, Integer weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class Graph {
    private int V;
    private List<List<Edge1>> adjList;

    Graph(int vertices) {
        this.V = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    void addEdge(int source, int destination, Integer weight, boolean isDirected) {
        Edge1 edge = new Edge1(source, destination, weight);
        adjList.get(source).add(edge);

        if (!isDirected && weight != null) {
            edge = new Edge1(destination, source, weight);
            adjList.get(destination).add(edge);
        } else if (!isDirected) {
            edge = new Edge1(destination, source, null);
            adjList.get(destination).add(edge);
        }
    }

    void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + " ->");
            for (Edge1 edge : adjList.get(i)) {
                System.out.print(" (" + edge.destination + ", " + (edge.weight != null ? edge.weight : "No Weight") + ")");
            }
            System.out.println();
        }
    }
}

public class Main1 {
    public static void main(String[] args) {
        Graph directedWeightedGraph = new Graph(5);
        directedWeightedGraph.addEdge(0, 1, 5, true);

        Graph undirectedUnweightedGraph = new Graph(5);
        undirectedUnweightedGraph.addEdge(0, 1, null, false);

        System.out.println("Directed Weighted Graph:");
        directedWeightedGraph.printGraph();

        System.out.println("\nUndirected Unweighted Graph:");
        undirectedUnweightedGraph.printGraph();
    }
}
