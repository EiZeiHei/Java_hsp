package com.Homework01;

public class EcmDef {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("参数个数错误");
            }
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            System.out.println("Result: " + cal(n1, n2));
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("all")
    public static double cal(int n1, int n2) {
        return n1 / n2;
    }
}
