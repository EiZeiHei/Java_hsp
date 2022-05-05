package com.Homework02;

import java.util.Scanner;

public class Homework02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入用户名（长度为2或3或4）");
        String name = scanner.next();
        if (name.length() < 2 || name.length() > 4) {
            throw new MessageException("用户名长度为2或3或4");
        }

        System.out.println("请输入密码（六位数字）");
        String password = scanner.next();
        if (password.length() != 6 || !isDigital(password)) {
            throw new MessageException("密码为六位数字");
        }

        System.out.println("请输入邮箱");
        String email = scanner.next();
        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if (i == -1 || j == -1 || i > j) {
            throw new MessageException("邮箱中包含@和.并且@在.前");
        }
    }

    public static boolean isDigital(String str) {
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (aChar < '0' || aChar > '9') {
                return false;
            }
        }
        return true;
    }
}
