import java.util.*;

class Dijkstra {
    private int V;
    private List<List<Edge>> adj;

    class Edge {
        int dest, weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    Dijkstra(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
    }

    void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(dest, weight);
        adj.get(src).add(edge);
    }

    void dijkstra(int src) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (Edge edge : adj.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;
                if (!visited[v] && dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        printShortestPaths(dist);
    }

    int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!visited[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    void printShortestPaths(int[] dist) {
        System.out.println("Shortest paths from source:");

        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        Dijkstra dijkstra = new Dijkstra(V);

        dijkstra.addEdge(0, 1, 2);
        dijkstra.addEdge(0, 2, 4);
        dijkstra.addEdge(1, 2, 1);
        dijkstra.addEdge(1, 3, 7);
        dijkstra.addEdge(2, 3, 3);
        dijkstra.addEdge(2, 4, 5);
        dijkstra.addEdge(3, 4, 2);

        int source = 0;
        dijkstra.dijkstra(source);
    }
}
