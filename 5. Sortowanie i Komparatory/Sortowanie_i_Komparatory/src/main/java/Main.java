import java.util.Comparator;

public class Main {

    public static void demo1() {
        Car[] cars = new Car[5];
        cars[0] = new Car("Mercedes", "White", 2019);
        cars[1] = new Car("Mercedes", "Black", 2021);
        cars[2] = new Car("BMW", "Black", 2014);
        cars[3] = new Car("BMW", "Blue", 2017);
        cars[4] = new Car("Opel", "White", 1997);

        SortingAlgorithms algorithms = new SortingAlgorithms<Car>();

        algorithms.bubbleSort(cars, Comparator.comparingInt(Car::getProductionYear));


        for (Object car : cars) {
            System.out.println(car);
        }
    }

    public static void main(String[] args) {
        demo1();
    }

}
