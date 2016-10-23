package com.solid;

public class Car implements Vehicle {
    @Override
    public void addFuel() {
        System.out.println("Speed up the car...");
    }

    @Override
    public void speed() {
        System.out.println("Adding fuel to car...");
    }
}
