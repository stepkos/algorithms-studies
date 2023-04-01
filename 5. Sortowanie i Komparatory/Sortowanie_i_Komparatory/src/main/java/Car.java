import java.util.Comparator;

public class Car implements Comparable<Car> {
    private String brand;
    private String color;
    private int productionYear;

    public Car(String brand, String color, int productionYear) {
        this.brand = brand;
        this.color = color;
        this.productionYear = productionYear;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", productionYear=" + productionYear +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        int result = 0;
        result = getBrand().compareTo(o.getBrand());
        if (result != 0) return result;
        result = getColor().compareTo(o.getColor());
        if (result != 0) return result;
        result = Integer.compare(getProductionYear(), o.getProductionYear());
        return 0;
    }

}
