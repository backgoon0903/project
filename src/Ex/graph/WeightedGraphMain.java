package Ex.graph;

import java.util.ArrayList;
import java.util.List;

class WeightedGraph {
    private List<List<Edge>> adjList;

    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public WeightedGraph(int vertices) {
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjList.get(source).add(edge);
        adjList.get(destination).add(new Edge(destination, source, weight));
    }

    public void printGraph() {
        for (int i = 0; i < adjList.size(); i++) {
            List<Edge> list = adjList.get(i);
            for (Edge edge : list) {
                System.out.println("Vertex " + edge.source + " is connected to vertex " +
                        edge.destination + " with weight " + edge.weight);
            }
        }
    }
}

public class WeightedGraphMain {
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(5);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 0, 4);
        graph.addEdge(4, 1, 4);

        graph.printGraph();
    }
}