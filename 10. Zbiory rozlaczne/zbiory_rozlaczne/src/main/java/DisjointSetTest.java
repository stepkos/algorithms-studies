public class DisjointSetTest {
    public static void main(String[] args) {
        DisjointSetInterface disjointSet = new DisjointSet();
//        DisjointSetInterface disjointSet = new DisjointSetForest();
//        DisjointSetInterface disjointSet = new DisjointSetForest2();
//        DisjointSetInterface disjointSet = new DisjointSetList();

        // Tworzenie zbiorów
        disjointSet.makeSet(1);
        disjointSet.makeSet(2);
        disjointSet.makeSet(3);
        disjointSet.makeSet(4);
        disjointSet.makeSet(5);

        // Łączenie zbiorów
        disjointSet.union(1, 2);
        disjointSet.union(2, 3);
        disjointSet.union(4, 5);

        // Sprawdzanie przynależności do zbioru
        System.out.println(disjointSet.findSet(1));  // Powinno zwrócić 1
        System.out.println(disjointSet.findSet(3));  // Powinno zwrócić 1
        System.out.println(disjointSet.findSet(4));  // Powinno zwrócić 4
        System.out.println(disjointSet.findSet(5));  // Powinno zwrócić 4

        // Łączenie zbiorów
        disjointSet.union(1, 5);

        // Sprawdzanie przynależności do zbioru po kolejnym połączeniu
        System.out.println(disjointSet.findSet(1));  // Powinno zwrócić 1
        System.out.println(disjointSet.findSet(3));  // Powinno zwrócić 1
        System.out.println(disjointSet.findSet(4));  // Powinno zwrócić 1
        System.out.println(disjointSet.findSet(5));  // Powinno zwrócić 1
    }
}
