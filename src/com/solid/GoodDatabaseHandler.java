package com.solid;

public class GoodDatabaseHandler {
    private IDatabase myDatabase;

    public GoodDatabaseHandler(IDatabase dataBase) { //Dependency injection!
        this.myDatabase = dataBase;
    }

    public void connect() {
        this.myDatabase.connect();
    }

    public void disconnect() {
        this.myDatabase.disconnect();
    }
}
