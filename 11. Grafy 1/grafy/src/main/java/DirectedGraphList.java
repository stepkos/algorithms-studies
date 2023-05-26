import java.util.ArrayList;
import java.util.List;

public class DirectedGraphList extends GraphList {
    private int numVertices;

    public DirectedGraphList(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addVertex() {
        numVertices++;
        adjacencyList.add(new ArrayList<>());
    }

    public void addEdge(int source, int destination) {
        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices) {
            adjacencyList.get(source).add(destination);
        } else {
            throw new IllegalArgumentException("Invalid vertex index");
        }
    }
}
