package com.Homework04;

public class CellPhone {
    public void testWork() {
        PC pc = () -> System.out.println("匿名内部类");
        pc.work();
    }

    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.testWork();
    }
}
