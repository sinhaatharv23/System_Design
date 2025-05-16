package Oops_Concept.Polymorphism;/*
Static Polymorphism (Compile-time polymorphism) in real life says that
the same action can behave differently depending on the input parameters.
For example, a Manual car can accelerate by a fixed amount or by a
specific amount you request. In programming, we achieve this via method
overloading: multiple methods with the same name but different signatures.
*/

public class Static_Polymorphism {
    public static void main(String[] args) {
        Manual_Car myManualCar = new Manual_Car("Suzuki", "WagonR");
        myManualCar.startEngine();
        myManualCar.accelerate();
        myManualCar.accelerate(40);
        myManualCar.brake();
        myManualCar.stopEngine();
    }
}