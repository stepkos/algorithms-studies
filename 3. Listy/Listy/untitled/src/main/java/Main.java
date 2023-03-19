public class Main {

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

    public static void demo() {
        IList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
    }

    public static void main(String[] args) {

        zad2(12, 3);
//        demo();

    }
}
