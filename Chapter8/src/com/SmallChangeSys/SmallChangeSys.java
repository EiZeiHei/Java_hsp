package com.SmallChangeSys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    /**
     * 1.完成显示菜单
     * 2.完成零钱通明细
     * 3.完成收益入账
     * 4.完成消费
     * 5.退出
     */

    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key;
    String detail = "------------------零钱通明细-----------------";
    double money;
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    double balance;
    String item;
    String flag;

    public void menu() {
        do {
            System.out.println("-------------零钱通菜单------------");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退出");

            System.out.print("请选择（1-4）：");
            key = scanner.next();

            switch (key) {
                case ("1") ->
                        //1 零钱通明细
                        this.detail();
                case ("2") ->
                        //2 收益入账
                        this.income();
                case ("3") ->
                        //3 消费
                        this.cost();
                case ("4") ->
                        //4 退出
                        this.exit();
                default -> {
                }
            }

        } while (loop);

        System.out.println("退出了零钱通项目");
    }

    public void detail() {
        System.out.println(detail);
        System.out.println();
    }

    public void income() {
        System.out.print("请输入收益入账金额：");
        money = scanner.nextDouble();

        if (money <= 0) {
            System.out.println("收益入账金额应大于0");
            return;
        }

        balance += money;
        detail += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t余额：" + balance;
    }

    public void cost() {
        System.out.print("请输入消费金额：");
        money = scanner.nextDouble();

        if (money <= 0 || money > balance) {
            System.out.println("消费金额应大于0且不小于余额");
            return;
        }

        System.out.print("请输入消费项目：");
        item = scanner.next();

        balance -= money;
        detail += "\n" + item + "\t-" + money + "\t" + sdf.format(date) + "\t余额：" + balance;
    }

    public void exit() {
        System.out.println("你确定要退出吗？y/n");

        do {
            flag = scanner.next();

        } while (!flag.equals("y") && !flag.equals("n"));

        if (flag.equals("y")) {
            loop = false;
        }
    }
}
