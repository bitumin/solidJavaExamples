package com.solid;

public class MySQLDatabase implements IDatabase {
    @Override
    public void connect() {
        System.out.println("Connects MySQL database...");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnects MySQL database...");
    }
}
