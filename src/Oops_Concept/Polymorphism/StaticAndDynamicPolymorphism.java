package Oops_Concept.Polymorphism;

// Base Car class
abstract class car {
    protected String brand;
    protected String model;
    protected boolean isEngineOn;
    protected int currentSpeed;

    public car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.isEngineOn = false;
        this.currentSpeed = 0;
    }

    //Common methods for All cars.
    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine started.");
    }

    public void stopEngine() {
        isEngineOn = false;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " : Engine turned off.");
    }

    public abstract void accelerate();             // Abstract method for Dynamic Polymorphism

    public abstract void accelerate(int speed);    //Abstract method for Static Polymorphism

    public abstract void brake();                  // Abstract method for Dynamic Polymorphism
}

class manualcar extends car {
    private int currentGear;

    public manualcar(String brand, String model) {
        super(brand, model);
        this.currentGear = 0;
    }

    //Specialized method for Manual Car
    public void shiftGear(int gear) {
        currentGear = gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }

    // Overriding accelerate - Dynamic Polymorphism
    @Override
    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        currentSpeed += 20;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }

    //overriding and overloading accelerate at the same time.
    @Override
    public void accelerate(int speed) {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        currentSpeed += speed;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }

    // Overriding brake - Dynamic Polymorphism
    @Override
    public void brake() {
        currentSpeed -= 20;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }
}

class electriccar extends car {
    private int batteryLevel;

    public electriccar(String brand, String model) {
        super(brand, model);
        this.batteryLevel = 100;
    }

    //specialized method for Electric Car
    public void chargeBattery() {
        batteryLevel = 100;
        System.out.println(brand + " " + model + " : Battery fully charged!");
    }

    // Overriding accelerate - Dynamic Polymorphism
    @Override
    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        if (batteryLevel <= 0) {
            System.out.println(brand + " " + model + " : Battery dead! Cannot accelerate.");
            return;
        }
        batteryLevel -= 10;
        currentSpeed += 15;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed +
                " km/h. Battery at " + batteryLevel + "%.");
    }

    // Overriding accelerate - Dynamic Polymorphism
    @Override
    public void accelerate(int speed) {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        if (batteryLevel <= 0) {
            System.out.println(brand + " " + model + " : Battery dead! Cannot accelerate.");
            return;
        }
        batteryLevel -= 10 + speed;
        currentSpeed += speed;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed +
                " km/h. Battery at " + batteryLevel + "%.");
    }

    // Overriding brake - Dynamic Polymorphism
    @Override
    public void brake() {
        currentSpeed -= 15;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model +
                " : Regenerative braking! Speed is now " + currentSpeed +
                " km/h. Battery at " + batteryLevel + "%.");
    }
}

// Main function
public class StaticAndDynamicPolymorphism {
    public static void main(String[] args) {
        car myManualCar = new manualcar("Ford", "Mustang");
        myManualCar.startEngine();
        myManualCar.accelerate();
        myManualCar.accelerate();
        myManualCar.brake();
        myManualCar.stopEngine();

        System.out.println("----------------------");

        car myElectricCar = new electriccar("Tesla", "Model S");
        myElectricCar.startEngine();
        myElectricCar.accelerate();
        myElectricCar.accelerate();
        myElectricCar.brake();
        myElectricCar.stopEngine();
    }
}
//Why operator overloading is only supported in C++ and not in other Programming languages ??
/*Operator overloading is supported in **C++** but not in languages like **C, Java, and Python (to a limited extent)** because of the design philosophies and intended use cases of these languages. Let’s break it down:

### **1. C++: Supports Operator Overloading**

* C++ is designed with a strong emphasis on **object-oriented programming (OOP)** and **extensibility**.
* Operator overloading allows users to define custom behaviors for operators when applied to user-defined types (like classes).
* This feature makes C++ more **expressive** and **intuitive** when using objects in mathematical and logical expressions.
* Example: Defining `+` for complex numbers to add their real and imaginary parts.

---

### **2. C: Does Not Support Operator Overloading**

* C is a **procedural programming language** that emphasizes performance and low-level memory manipulation.
* Operator overloading is considered unnecessary as C does not have classes or objects to associate the overloaded operators with.
* Adding operator overloading would complicate the language syntax without much benefit.

---

### **3. Java: Does Not Support Operator Overloading**

* Java was designed with a focus on **simplicity and portability**.
* Operator overloading is deliberately left out to avoid **code ambiguity and complexity**.
* Java’s designers wanted to maintain **readability and predictability**.
* Instead of overloading operators, Java encourages the use of **methods** (e.g., `add()` for addition).
* The only overloaded operator in Java is `+` (used for both addition and string concatenation).

---

### **4. Python: Limited Support for Operator Overloading**

* Python allows operator overloading via **magic methods** (like `__add__`, `__mul__`, etc.), but it is not as flexible as in C++.
* The philosophy here is **simplicity and readability**.
* Python’s operator overloading is restricted to objects and classes, not primitive types.
* Example:

  ```python
  class Complex:
      def __init__(self, r, i):
          self.real = r
          self.imag = i

      def __add__(self, other):
          return Complex(self.real + other.real, self.imag + other.imag)
  ```
* Python overloading aims to be **less ambiguous** and more readable.

---

### **Summary:**

* C++ supports operator overloading as it aligns with its object-oriented and extensibility goals.
* C and Java avoid it due to simplicity and predictability concerns.
* Python supports it in a limited and controlled way to maintain readability.

Would you like a deeper dive into any of these languages or more examples of operator overloading?
*/