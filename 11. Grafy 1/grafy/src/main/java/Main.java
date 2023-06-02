public class Main {
    public static void main(String[] args) {

        UndirectedGraphList graph = new UndirectedGraphList(6);
//        UndirectedGraphMatrix graph = new UndirectedGraphMatrix(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        System.out.println("\nBFS:");
        graph.BFS(0);

        System.out.println("\nDFS:");
        graph.DFS(0);

        graph.printList();
//        graph.displayMatrix();

    }
}
