import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public abstract class GraphMatrix {
    protected int numVertices;
    protected boolean[][] adjacencyMatrix;

    public GraphMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new boolean[numVertices][numVertices];
    }


    public void BFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.println("Visited: " + vertex);
//            System.out.println("Queue: " + queue);


            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[vertex][i] && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    public void DFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            if (!visited[vertex]) {
                System.out.println("Visited: " + vertex);
//                System.out.println("Stack: " + stack);
                visited[vertex] = true;
            }

            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[vertex][i] && !visited[i]) {
                    stack.push(i);
                }
            }
        }
    }

    public void displayMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

}
