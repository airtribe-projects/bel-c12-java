package org.example;

public class Human {
  //data
  // behaviours
  String name;

  int age;

  int numberOfEyes;

  char hello;

  // instance variable
  static int count;

  // no arg constrcutor
  public Human() {
    hello = 'a';
    name = "test";
    age = 20;
    numberOfEyes = 2;
  }

  // Parameterized constructor
  // One Arg
  // two Arg
  // 3 arg
  // Multi arg constructr
  public Human(String providedName, int providedAge, int providedNumberofEyes) {
    name = providedName;
    age = providedAge;
    numberOfEyes = providedNumberofEyes;
    hello = 'b';
  }

  public Human(Human human) {
    this.name = human.name;
    this.numberOfEyes = human.numberOfEyes;
  }

  int sum(int a, int b) {
    return a + b;
  }

  void speak() {
    System.out.println("Hello, my name is " + name + " " + age + " " + numberOfEyes + " " + hello);
  }

  static void takeBirth() {
    count++;
    System.out.println("Taking birth");
  }

  void sleep() {
    long i = 0;
    System.out.println("Sleeping... " + i);
  }
}
