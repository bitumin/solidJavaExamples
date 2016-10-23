package com.solid;

public class ElectricCar implements Vehicle {
    @Override
    public void addFuel() {
        throw new RuntimeException("Error! Electric cars use no fuel!");
    }

    @Override
    public void speed() {
        System.out.println("Speed up with electric car...");
    }
}
