package com.solid;

public class OracleDatabase implements IDatabase {
    @Override
    public void connect() {
        System.out.println("Connects Oracle database...");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnects Oracle database...");
    }
}
