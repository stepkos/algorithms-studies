package ex2;

public class Main {

    public static boolean isPrime(Integer x) {
        if (x<2) return false;
        for (int i=2; i<x; i++)
            if (x % i == 0)
                return false;
        return true;
    }

    public static void demo() {

        NumberFilterIterator<Integer> filterIterator = new NumberFilterIterator<>(
                new NumberIterator(100), Main::isPrime
        );

        while (!filterIterator.isDone()){
            System.out.println(filterIterator.current());
            filterIterator.next();
        }

//        filterIterator.last();
//        while (!filterIterator.isDone()){
//            System.out.println(filterIterator.current());
//            filterIterator.previous();
//        }

    }

    public static void main(String[] args) {
        demo();
    }

}
