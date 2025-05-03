package org.example.dip;

public class Car {

  private Engine _dieselEngine;

  public Car() {

  }

  public void start() {
    System.out.println("Car started with " + _dieselEngine.getEngineType() + " engine.");
  }

  public Engine getDieselEngine() {
    return _dieselEngine;
  }

  public void setDieselEngine(DieselEngine dieselEngine) {
    _dieselEngine = dieselEngine;
  }
}
