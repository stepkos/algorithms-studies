public class Main {
    public static void main(String[] args) {
        // Przykład użycia dla grafu nieskierowanego z użyciem macierzy sąsiedztwa
        UndirectedGraphMatrix graphMatrix = new UndirectedGraphMatrix(4);
        graphMatrix.addEdge(0, 1);
        graphMatrix.addEdge(1, 2);
        graphMatrix.addEdge(2, 3);
        graphMatrix.addVertex();
        graphMatrix.addEdge(3, 4);

        // Przykład użycia dla grafu nieskierowanego z użyciem listy sąsiedztwa
        UndirectedGraphList graphList = new UndirectedGraphList(4);
        graphList.addEdge(0, 1);
        graphList.addEdge(1, 2);
        graphList.addEdge(2, 3);
        graphList.addVertex();
        graphList.addEdge(3, 4);
        graphList.printList();

        // Przykład użycia dla grafu skierowanego z użyciem macierzy sąsiedztwa
        DirectedGraphMatrix directedGraphMatrix = new DirectedGraphMatrix(4);
        directedGraphMatrix.addEdge(0, 1);
        directedGraphMatrix.addEdge(1, 2);
        directedGraphMatrix.addEdge(2, 3);
        directedGraphMatrix.addVertex();
        directedGraphMatrix.addEdge(3, 4);

        // Przykład użycia dla grafu skierowanego z użyciem listy sąsiedztwa
        DirectedGraphList directedGraphList = new DirectedGraphList(4);
        directedGraphList.addEdge(0, 1);
        directedGraphList.addEdge(1, 2);
        directedGraphList.addEdge(2, 3);
        directedGraphList.addVertex();
        directedGraphList.addEdge(3, 4);
//        directedGraphList.printList();
    }
}
