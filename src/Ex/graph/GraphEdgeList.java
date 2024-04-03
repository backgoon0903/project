package Ex.graph;


import java.util.ArrayList;
import java.util.List;

class Edge {
    int source;
    int destination;

    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }
}

class GraphEdgeList {
    private List<Edge> edgeList;

    public GraphEdgeList() {
        edgeList = new ArrayList<>();
    }

    public void addEdge(int source, int destination) {
        edgeList.add(new Edge(source, destination));
    }

    public void printGraph() {
        for (Edge edge : edgeList) {
            System.out.println("Edge from " + edge.source + " to " + edge.destination);
        }
    }
}
