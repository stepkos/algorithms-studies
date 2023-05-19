import java.util.HashMap;
import java.util.Map;

/**
 * Implementacja zbiorów rozłącznych za pomocą listy wiązanej z wyważaniem
 */
class DisjointSetList {
    private Map<Integer, Node> nodeMap;

    private class Node {
        int data;
        Node parent;
        int rank;
        int size;
    }

    public DisjointSetList() {
        nodeMap = new HashMap<>();
    }

    public void makeSet(int data) {
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        node.size = 1;
        nodeMap.put(data, node);
    }

    public int findSet(int data) {
        return findSet(nodeMap.get(data)).data;
    }

    private Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node) {
            return parent;
        }
        node.parent = findSet(node.parent); // Path compression
        return node.parent;
    }

    public void union(int data1, int data2) {
        Node node1 = nodeMap.get(data1);
        Node node2 = nodeMap.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        if (parent1 == parent2) {
            return;
        }

        if (parent1.rank >= parent2.rank) {
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
            parent1.size += parent2.size;
        } else {
            parent2.parent = parent1;
            parent1.size += parent2.size;
        }
    }
}
