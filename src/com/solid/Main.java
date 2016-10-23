package com.solid;

public class Main {
    /**
     * SOLID PRINCIPLES
     * ----------------
     * Since apps changes over time quite fast (new functionalities) the changes in existing code
     * must be minimized. Thus it is necessary to write code, from the start, in a way it's easy
     * to extend while avoiding pre-existing code changes.
     *
     * SINGLE RESPONSIBILITY PRINCIPLE
     * A class or a method should only have one reason to change
     *      - If a class/method does more than one procedure, we should try to separate it into two distinct
     *      classes/methods.
     *      - It can be done easily with the help of interfaces.
     * Example: we have 2 reasons to change a class => we split the functionality into two separate classes
     * Result: Low coupled design with less and lighter dependencies
     *
     * OPEN/CLOSED PRINCIPLE
     * Software entities should be open for extension, but closed for modification
     *      - Every new behaviour should require a new module, without changing existing modules
     * Example: a class should not extend another class (avoid inheritance), but both can share the same interface,
     * so both can use a common method that can be override or modified on runtime
     * Design patterns:
     * - Strategy Pattern
     * - Template Pattern
     *
     * LISKOV SUBSTITUTION PRINCIPLE
     * New child classes must work without override the parent classes methods
     * Example: Car extends Vehicle => Whenever we can use the Car as a method argument
     * we can use Vehicle (or any other Vehicle) in the same place without breaking the app!
     * To violate Liskov usually implies to violate Open/Close principle too.
     * Design patterns:
     * - Template Pattern
     *
     * INTERFACE SEGREGATION PRINCIPLE
     * We can always have an abstraction of the system using interfaces
     * If we implement an interface because we need methods within it but we are actually
     * getting more methods that the ones we need, we should segregate the interfaces
     * until no client is forced to use methods that they do not use!
     *
     * DEPENDENCY INVERSION PRINCIPLE
     * Usually we first implement low level modules (db connection, bluetooth com, xml parser...) and
     * then we implement high level modules that dependent on those. This intuitive dependency is not
     * very flexible since if we have to use some alternative low level tech (mysql instead of microsoft sql)
     * then we have to change also al the dependant high level objects.
     * A good way of implementing the Dependency Inversion Principle is to use abstract layers:
     * High level modules <-> ¡¡¡ Abstract layer (Interface) !!! <-> Low level modules.
     * - It's the most difficult to implement, but the most important one too!
     * - High level modules should never depend on low level modules, both should depend on abstraction!
     * - Abstraction should not depend on detail, detail should depend upon abstraction
     * Design patterns:
     * - Factory, template, strategy patterns
     * - Service locator pattern
     * - Dependency injection
     */

    public static void main(String[] args) {
        // Bad implementation of Single Responsibility Principle
        BadBook badBook = new BadBook("Shakespeare", 532);
        badBook.printAndSave();

        // Good implementation of Single Responsibility Principle:
        // we use BookPersistence with composition within Book (property)
        // or as an interface (implements...) of Book in order to decouple
        // save() and print() methods from Book class implementation
        Book book = new Book("Albert Camus", 125);
        book.save();
        book.print();

        // Bad implementation of O/C principle:
        // to create a new sorting method (module) would require the modification of the SorterManager methods.
        SorterManager sorterManager = new SorterManager();
        sorterManager.sort(new Mergesort());
        sorterManager.sort(new InsertionSort());

        // Better implementation of multiple Sorters: strategy pattern
        GoodSorterManager gSorterManager = new GoodSorterManager();
        gSorterManager.sort(new GoodMergesort());
        gSorterManager.sort(new GoodInsertionSort());
        gSorterManager.sort(new QuickSort()); // a new module does not require to change the sorter manager class!

        // Bad implementation of Liskov principle:
        // Since electric car is vehicle and vehicle supposes all cars will add fuel, we can't use addFuel unless
        // we check the car implementation is not of an electric car, to avoid exceptions
        Vehicle car = new ElectricCar();
        //car.addFuel(); // exception thrown!
        if (car instanceof ElectricCar) {
            System.out.println("Unable to add fuel to electric car!!");
        } else {
            car.addFuel();
        }

        // Good implementation of Liskov Principle:
        // We create smaller interfaces with less coupled methods;
        // Now we can use its parent or child class interchangeably:
        //GoodElectricVehicle eCar = new GoodElectricCar();
        GoodElectricCar eCar = new GoodElectricCar();
        eCar.chargeBattery();

        // Good implementation of Interface Segregation principle
        // We segregated the methods of BadTree into two interfaces: Tree and Balanced specific IBalancedTree

        // Bad Dependency inversion principle example:
        // High level component DatabaseHandler depends on the low level class MySQLDatabase via composition!
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.connect();
        databaseHandler.disconnect();

        // Good dependency inversion principle example (strategy pattern with dependency injection example):
        GoodDatabaseHandler gDatabaseHandler1 = new GoodDatabaseHandler(new OracleDatabase());
        gDatabaseHandler1.connect();
        gDatabaseHandler1.disconnect();
        GoodDatabaseHandler gDatabaseHandler2 = new GoodDatabaseHandler(new MySQLDatabase());
        gDatabaseHandler2.connect();
        gDatabaseHandler2.disconnect();
    }
}
