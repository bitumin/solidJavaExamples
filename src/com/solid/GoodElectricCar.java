package com.solid;

public class GoodElectricCar implements GoodElectricVehicle {
    @Override
    public void speed() {
        System.out.println("Speed up with electric car...");
    }

    @Override
    public void chargeBattery() {
        System.out.println("Charging the electric car battery...");
    }
}
