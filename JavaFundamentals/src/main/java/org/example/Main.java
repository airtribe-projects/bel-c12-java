package org.example;

import java.util.Scanner;


public class Main {
  public static void main(String[] args) {
    String[] names = new String[100];
    int[] ages = new int[100];
    int[] xps = new int[100];

    Scanner sc = new Scanner(System.in);
    int userChoice = 0;
    int totalCount = 0;

    do {
       System.out.println("1. Input Learner");
       System.out.println("2. List Learners");
       System.out.println("3. Calculate Average XP");
       System.out.println("4. Exit");

       userChoice = sc.nextInt();
       if (userChoice == 1) {
          if (totalCount < names.length) {
            System.out.println("Enter the age to be added");
            int providedAge = sc.nextInt();
            if (providedAge < 18) {
              System.out.println("Age should be greater than 18");
              continue;
            }
            ages[totalCount] = providedAge;
            System.out.println("Enter the xps of the learners");
            int providedXps = sc.nextInt();
            xps[totalCount] = providedXps;
            System.out.println("Enter the name of the learners");
            String providedName = sc.next();
            names[totalCount] = providedName;
            totalCount++;
          } else {
              System.out.println("No more space to add learners");
          }
       } else if (userChoice == 2) {
          if (totalCount == 0) {
            System.out.println("No learners to display");
          } else {
            for (int i = 0; i < totalCount; i++) {
              System.out.println("Name: " + names[i] + " Age: " + ages[i] + " XP: " + xps[i]);
            }
          }
       } else if (userChoice == 3) {
//         if (totalCount == 0) {
//           System.out.println("No learners to display");
//         } else {
           int totalXp = 0;
           for (int i=0; i< totalCount;i++) {
              totalXp = totalXp + xps[i];
           }
           double averageXp = (double) totalXp / totalCount;
            System.out.println("Average XP: " + averageXp);
         //}
       } else {
         System.out.println("Exiting the learner management system");
       }
    } while (userChoice != 4);


  }
}

JVM Architecture
    - Class loader subsytem
        - Loading
          - Bootstrap
          - Extension
          - Application
          - Method are
        - Linking
          - Verification
            - Byte code
          - Preparation
            - Static variable
          - Resolution
            - Symoblic reference
        - Initialization
          - User defined static
    - Runtime access area
        - Method area
          - Classes, Static Variables, Methods
        - Heap area
          - Objects, Instance variables
        - Stack are
          - Local variables, Method stacks/call stacks
        - PC register
          - Instruction
        - native method stack
          - C++ native code
    - Execution Engine
      - Interpreter
          - Line by line
      - JIT
          - All at once (Code cache)
      - Garbage collector