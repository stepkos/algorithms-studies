import java.util.List;

public abstract class GraphList {
    protected List<List<Integer>> adjacencyList;

    public void printList() {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                System.out.print(adjacencyList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
