package Ex.exclass;

public class Vehicle {
    private String brand ;
    private int age ;

    // 만든 년도를 선언하기
    public Vehicle(String brand, int age) {
        this.brand = brand;
        this.age = age;
        System.out.println("It was created in " + age);
    }


    public void display() {
        System.out.println("This is a vehicle from " + brand);
    }
}
