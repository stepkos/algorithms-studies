public class Main {

    public static void zad1() {
        IList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.insert(1, 5);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
    }

    public static void zad2(int n, int k) {

        LinkedList<String> list = new LinkedList<>();
        for (int i=1; i<=n; i++)
            list.add("Osoba " + i);

        int akt=0;
        for (int i=0; i<n-1; i++) {
            akt += k-1;
            akt %= n-i;
            System.out.println("Usunieto: " + list.removePos(akt));
        }

        System.out.println("Aktualny stan listy:");
        list.display();

    }

    public static void zad3() {
        LinkedList<String> list = new LinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println("Wyswietlanie listy rekursywnie");
        list.displayListRecursive();

        System.out.println("\nWyswietlanie listy rekursywnie odwrotnie");
        list.displayListRecursiveReverse();

        System.out.println("Oto skopiowana lista");
        list.copyListRecursive().displayListRecursive();

        System.out.println(list.sumRecursive());

        System.out.println(list.sizeRecursive());

    }

    public static void main(String[] args) {

        System.out.println("ZAD 1");
        zad1();

        System.out.println("\nZAD 2");
        zad2(12, 3);

        System.out.println("\nZAD 3");
        zad3();

    }
}
