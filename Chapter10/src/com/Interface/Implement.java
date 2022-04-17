package com.Interface;

public class Implement extends Abstract implements Interface {
    @Override
    public void connect() {
        super.connect();
        System.out.println("Implement connect");
    }

    @Override
    public void close() {
        System.out.println("Implement close");
    }

    public static void main(String[] args) {
        Implement implement = new Implement();
        implement.connect();
        implement.close();
    }
}
