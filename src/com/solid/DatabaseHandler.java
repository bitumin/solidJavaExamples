package com.solid;

public class DatabaseHandler {
    private MySQLDatabase mySQLDatabase;

    public DatabaseHandler() {
        this.mySQLDatabase = new MySQLDatabase();
    }

    public void connect() {
        this.mySQLDatabase.connect();
    }

    public void disconnect() {
        this.mySQLDatabase.disconnect();
    }
}
