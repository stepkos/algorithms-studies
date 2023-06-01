public class Main {
    public static void main(String[] args) {
        // Przykład użycia dla grafu nieskierowanego z użyciem macierzy sąsiedztwa
//        UndirectedGraphMatrix graphMatrix = new UndirectedGraphMatrix(4);
//        graphMatrix.addEdge(0, 1);
//        graphMatrix.addEdge(1, 2);
//        graphMatrix.addEdge(2, 3);
//        graphMatrix.addVertex();
//        graphMatrix.addEdge(3, 4);

        // Przykład użycia dla grafu nieskierowanego z użyciem listy sąsiedztwa
//        UndirectedGraphList graphList = new UndirectedGraphList(4);
//        graphList.addEdge(0, 1);
//        graphList.addEdge(1, 2);
//        graphList.addEdge(2, 3);
//        graphList.addVertex();
//        graphList.addEdge(3, 4);
//        graphList.printList();
//        graphList.BFS(0);
//        graphList.DFS(0);


        // Przykład użycia dla grafu skierowanego z użyciem macierzy sąsiedztwa
//        DirectedGraphMatrix directedGraphMatrix = new DirectedGraphMatrix(4);
//        directedGraphMatrix.addEdge(0, 1);
//        directedGraphMatrix.addEdge(1, 2);
//        directedGraphMatrix.addEdge(2, 3);
//        directedGraphMatrix.addVertex();
//        directedGraphMatrix.addEdge(3, 4);

        // Przykład użycia dla grafu skierowanego z użyciem listy sąsiedztwa
//        DirectedGraphList directedGraphList = new DirectedGraphList(4);
//        directedGraphList.addEdge(0, 1);
//        directedGraphList.addEdge(1, 2);
//        directedGraphList.addEdge(2, 3);
//        directedGraphList.addVertex();
//        directedGraphList.addEdge(3, 4);
//        directedGraphList.printList();


        UndirectedGraphList graph = new UndirectedGraphList(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        System.out.println("BFS:");
        graph.BFS(0);

        System.out.println("DFS:");
        graph.DFS(0);

    }
}
