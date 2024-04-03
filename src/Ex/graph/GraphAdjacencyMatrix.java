package Ex.graph;

class GraphAdjacencyMatrix {
    private int[][] adjMatrix;

    public GraphAdjacencyMatrix(int vertices) {
        adjMatrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination) {
        adjMatrix[source][destination] = 1;
    }

    public void printGraph() {
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}