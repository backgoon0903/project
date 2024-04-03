package Ex.exclass;

public class Car extends Vehicle {
    private int doors;

    public Car(String brand ,int age, int doors) {
        super(brand,age);
        this.doors = doors;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("This is a car with " + doors + " doors");
    }
}
