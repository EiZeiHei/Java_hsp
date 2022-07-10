package com.Homework03;

import java.io.*;
import java.util.Properties;

public class Homework03 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("name", "tom");
        properties.setProperty("age", "5");
        properties.setProperty("color", "red");

        String path = "E:\\Git\\Java_hsp\\Chapter19\\src\\com\\Homework03\\dog.properties";
        properties.store(new FileOutputStream(path), null);
        System.out.println("保存配置文件成功");

        String name = properties.getProperty("name");
        int age = Integer.parseInt(properties.getProperty("age"));
        String color = properties.getProperty("color");

        Dog dog = new Dog(name, age, color);
        System.out.println("========");
        System.out.println(dog);

        String pathData = "E:\\Git\\Java_hsp\\Chapter19\\src\\com\\Homework03\\dog.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathData));
        objectOutputStream.writeObject(new Dog(name, age, color));
        objectOutputStream.close();
    }
}
