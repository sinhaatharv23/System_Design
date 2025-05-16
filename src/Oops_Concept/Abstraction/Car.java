package Oops_Concept.Abstraction;
import java.util.*;
//Real Life car
interface Car_Model{
    public void startEngine();
    public void shiftGear(int gear);
    public void accelerate();
    public void brake();
    public void stopEngine();
}
class sports_Car implements Car_Model{
    String brand,Model;
    boolean isEngineOn=false;
    int currentSpeed=0;
    int currentGear =0;
    public sports_Car(String brand,String Model){
        this.brand=brand;
        this.Model=Model;
    }
    @Override
    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + Model + " : Engine starts with a roar!");
    }

    @Override
    public void shiftGear(int gear) {
        if (!isEngineOn) {
            System.out.println(brand + " " + Model + " : Engine is off! Cannot Cannot Shift Gear.");
            return;
        }
        this.currentGear = gear;
        System.out.println(brand + " " + Model + " : Shifted to gear " + currentGear);
    }

    @Override
    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + Model + " : Engine is off! Cannot accelerate.");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + Model + " : Accelerating to " + currentSpeed + " km/h");
    }

    @Override
    public void brake() {
        currentSpeed -= 20;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + Model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }

    @Override
    public void stopEngine() {
        isEngineOn = false;
        currentGear = 0;
        currentSpeed = 0;
        System.out.println(brand + " " + Model + " : Engine turned off.");
    }
}
public class Car{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the brand of the car:- ");
        String brand = sc.nextLine();
        System.out.println("Enter the model of the car:- ");
        String Model = sc.nextLine();
        Car_Model myCar = new sports_Car(brand,Model);
        myCar.startEngine();
        System.out.println("Enter the gear:- ");
        int gear = sc.nextInt();
        myCar.shiftGear(gear);
        myCar.accelerate();
        myCar.brake();
        myCar.stopEngine();
    }
}