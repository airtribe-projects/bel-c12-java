package org.example.dip;

public class DieselEngine extends Engine {

  int dieselCapacity;

  public DieselEngine(String engineType, int horsepower, int dieselCapacity) {
    super(engineType, horsepower);
    this.dieselCapacity = dieselCapacity;
  }

  public int getDieselCapacity() {
    return dieselCapacity;
  }

  public void setDieselCapacity(int dieselCapacity) {
    this.dieselCapacity = dieselCapacity;
  }
}
