package Ex.graph;

import java.util.ArrayList;
import java.util.List;

class GraphAdjacencyList {
    private List<List<Integer>> adjList;

    public GraphAdjacencyList(int vertices) {
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
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