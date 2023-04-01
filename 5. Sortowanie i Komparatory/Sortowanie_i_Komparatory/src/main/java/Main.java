import java.util.Comparator;

public class Main {

    public static Car[] getCars() {
        return new Car[] {
            new Car("Mercedes", "White", 2019),
            new Car("Mercedes", "Black", 2021),
            new Car("BMW", "Black", 2014),
            new Car("BMW", "Blue", 2017),
            new Car("Opel", "White", 1997)
        };
    }

    public static void demo1() {

        SortingAlgorithms<Car> algorithms = new SortingAlgorithms<>();

        Car[] cars1 = getCars();
        Car[] cars2 = getCars();
        Car[] cars3 = getCars();

        System.out.println("Cars sorted by production year");
        algorithms.bubbleSort(cars1, Comparator.comparingInt(Car::getProductionYear));
        for (Car car : cars1)
            System.out.println(car);

        System.out.println("\nCars sorted by color");
        algorithms.insertSort(cars2, (car1, car2) -> car1.getColor().equals(car2.getColor()) ? 0 : 1);
        for (Car car : cars2)
            System.out.println(car);

        System.out.println("\nCars sorted by brand");
        algorithms.insertSort(cars3, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car1.getBrand().compareTo(car2.getBrand());
            }
        });
        for (Car car : cars3)
            System.out.println(car);
    }

    public static void demo2() {
        SortingAlgorithms<Car> algorithms = new SortingAlgorithms<>();
        Car[] cars = getCars();

        CompoundComparator<Car> compoundComparator = new CompoundComparator<>();
        compoundComparator.addComparator(Comparator.comparing(Car::getBrand));
        compoundComparator.addComparator(Comparator.comparing(Car::getColor));
        compoundComparator.addComparator(Comparator.comparingInt(Car::getProductionYear));

        algorithms.insertSort(cars, compoundComparator);

        for (Car car : cars)
            System.out.println(car);
    }

    public static void demo3() {
        SortingAlgorithms<Car> algorithms = new SortingAlgorithms<>();
        Car[] cars = getCars();

        algorithms.insertSort(cars, Car::compareTo);

        for (Car car : cars)
            System.out.println(car);

    }

    public static void main(String[] args) {
//        demo1();
//        demo2();
        demo3();
    }

}
