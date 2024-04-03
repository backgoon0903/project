package Ex.exclass;






public class VehicleTester {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Generic Brand",1994);
        Vehicle car = new Car("Toyota", 1958,4);
        Vehicle electricCar = new ElectricCar("Tesla", 1846, 4,24);


        vehicle.display();
        car.display();
        electricCar.display();
    }
}