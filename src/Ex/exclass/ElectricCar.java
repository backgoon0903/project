package Ex.exclass;

public class ElectricCar extends Car {
    private int batteryLife;

    public ElectricCar(String brand,int age, int doors, int batteryLife) {
        super(brand, age, doors);
        this.batteryLife = batteryLife;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("This is an electric car with a battery life of " + batteryLife + " hours");
    }
}
