import java.util.Arrays;

public class UndirectedGraphMatrix {
    private int numVertices;
    private boolean[][] adjacencyMatrix;

    public UndirectedGraphMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new boolean[numVertices][numVertices];
    }

    public void addVertex() {
        numVertices++;
        boolean[][] newMatrix = new boolean[numVertices][numVertices];
        for (int i = 0; i < numVertices - 1; i++) {
            newMatrix[i] = Arrays.copyOf(adjacencyMatrix[i], numVertices);
        }
        adjacencyMatrix = newMatrix;
    }

    public void addEdge(int source, int destination) {
        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices) {
            adjacencyMatrix[source][destination] = true;
            adjacencyMatrix[destination][source] = true;
        } else {
            throw new IllegalArgumentException("Invalid vertex index");
        }
    }
}
