package org.example.preferCompositionOverInheritance;

public class BaseDuck {
  int hands;

  int legs;

  int beak;


  public BaseDuck(int hands, int legs, int beak) {
    this.hands = hands;
    this.legs = legs;
    this.beak = beak;
  }

  public int getHands() {
    return hands;
  }

  public void setHands(int hands) {
    this.hands = hands;
  }

  public int getLegs() {
    return legs;
  }

  public void setLegs(int legs) {
    this.legs = legs;
  }

  public int getBeak() {
    return beak;
  }

  public void setBeak(int beak) {
    this.beak = beak;
  }

  public void swim() {
    System.out.println("Swimming with hands");
  }

  public void walk() {
    System.out.println("Walking");
  }

  public void squeak() {
    System.out.println("Squeaking");
  }
}
