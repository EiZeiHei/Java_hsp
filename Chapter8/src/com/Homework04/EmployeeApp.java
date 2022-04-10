package com.Homework04;

public class EmployeeApp {
    public static void main(String[] args) {
        Worker worker = new Worker("Jackie", 250, 365);
        worker.printSal();

        Manager manager = new Manager("Amy", 250, 365);
        manager.printSal();
    }
}
