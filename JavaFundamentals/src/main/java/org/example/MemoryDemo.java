package org.example;

// File: MemoryDemo.java
public class MemoryDemo {

    // Static field → stored in Method Area
    static int staticCounter = 0;

    // Instance field → stored in Heap (per object)
    int instanceCounter = 0;

    public MemoryDemo() {
        staticCounter++;
        instanceCounter++;
    }

    public void printState(String label) {
        System.out.println(label + " ➤ staticCounter = " + staticCounter + ", instanceCounter = " + instanceCounter);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("JVM Memory Demo: Method Area vs Heap");
        System.out.println("======================================");

        // Class is loaded into Method Area
        Class<?> clazz = Class.forName("org.example.MemoryDemo");
        System.out.println("Class " + clazz.getName() + " is loaded by " + clazz.getClassLoader());

        // Static field can be accessed without object → lives in Method Area
        System.out.println("\nStatic counter before any object creation: " + MemoryDemo.staticCounter);

        // Create first object → stored in Heap
        MemoryDemo obj1 = new MemoryDemo();
        obj1.printState("After obj1");

        // Create second object → also stored in Heap
        MemoryDemo obj2 = new MemoryDemo();
        obj2.printState("After obj2");

        // Show staticCounter from both objects to prove it's shared
        obj1.printState("From obj1");
        obj2.printState("From obj2");

        // Show memory identity hash codes to highlight separate heap objects
        System.out.println("\nHeap Object References:");
        System.out.println("obj1: " + System.identityHashCode(obj1));
        System.out.println("obj2: " + System.identityHashCode(obj2));
    }
}
