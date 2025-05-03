package org.example.dip;

public class Engine {
  private String engineType;
  private int horsepower;

  public Engine(String engineType, int horsepower) {
    this.engineType = engineType;
    this.horsepower = horsepower;
  }

  public String getEngineType() {
    return engineType;
  }

  public int getHorsepower() {
    return horsepower;
  }
}
