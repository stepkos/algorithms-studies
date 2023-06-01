import java.util.*;

public class UndirectedGraphList extends GraphList {
    private int numVertices;

    public UndirectedGraphList(int numVertices) {
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
            adjacencyList.get(destination).add(source);
        } else {
            throw new IllegalArgumentException("Invalid vertex index");
        }
    }

    public void BFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.println("Visited: " + vertex);

            List<Integer> neighbors = adjacencyList.get(vertex);
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public void DFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();

        visited[startVertex] = true;
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            System.out.println("Visited: " + vertex);

            List<Integer> neighbors = adjacencyList.get(vertex);
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }


}
