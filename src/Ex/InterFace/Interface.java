package Ex.InterFace;

interface Chargable {
    void charge();
}

interface Drivable {
    void drive();
}

interface ElectricVehicle extends Chargable, Drivable {
    void switchToEcoMode();
}


class Car implements Drivable {
    public void drive() {
        System.out.println("Car is driving");
    }
}

class ElectricCar extends Car implements ElectricVehicle {
    public void charge() {System.out.println("ElectricCar is charging");
    }
    public void switchToEcoMode() {System.out.println("ElectricCar is in Eco Mode");
    }
}


class SolarPanelCharger implements Chargable{
    public void charge() {System.out.println("Charging with solar power");
    }
}

class TransportManager {
    public static void main(String[] args) {
        Drivable myCar = new Car();
        ElectricVehicle myElectricCar = new ElectricCar();
        Chargable myCharger = new SolarPanelCharger();

        myCar.drive();
        myElectricCar.drive();
        myElectricCar.charge();
        myElectricCar.switchToEcoMode();
        myCharger.charge();
    }
}