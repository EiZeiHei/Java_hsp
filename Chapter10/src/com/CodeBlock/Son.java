package com.CodeBlock;

public class Son extends CodeBlockDetail {
    private static int n1 = getN1();

    public static int getN1() {
        System.out.println("son's static n1 Init");
        return 1;
    }

    //Something interesting here
    //在调用父类的 getN2 时动态绑定到了子类的 getN2
    private int n2 = getN2();

    public int getN2() {
        System.out.println("son's normal n2 Init");
        return 2;
    }

    static {
        System.out.println("son's static code block Init");
    }

    {
        System.out.println("son's normal code block Init");
    }

    public Son() {
        System.out.println("son's constructor Init");
    }

    public static void main(String[] args) {
        new Son();
    }
}
