package org.example.dip;

public class PetrolEngine extends Engine {
    private String fuelType;

    public PetrolEngine(String engineType, int horsepower, String fuelType) {
        super(engineType, horsepower);
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }

    @Override
    public String toString() {
        return "PetrolEngine{" +
                "engineType='" + getEngineType() + '\'' +
                ", horsepower=" + getHorsepower() +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
