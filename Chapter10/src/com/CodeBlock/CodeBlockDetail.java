package com.CodeBlock;

public class CodeBlockDetail {
    private static int n1 = getN1();

    public static int getN1() {
        System.out.println("static n1 Init");
        return 1;
    }

    private int n2 = getN2();

    public int getN2() {
        System.out.println("normal n2 Init");
        return 2;
    }

    static {
        System.out.println("static code block Init");
    }

    {
        System.out.println("normal code block Init");
    }

    public CodeBlockDetail() {
        System.out.println("constructor Init");
    }

    public static void main(String[] args) {
        new CodeBlockDetail();
    }
}
