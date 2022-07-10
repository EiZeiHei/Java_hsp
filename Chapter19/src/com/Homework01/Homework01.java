package com.Homework01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Homework01 {
    public static void main(String[] args) throws IOException {
        File path = new File("e:\\myTemp");

        if (path.exists()) {
            System.out.println("文件夹存在，无需重复创建");
        } else {
            System.out.println("文件夹不存在，自动创建");
            path.mkdir();
        }

        File txt = new File("e:\\myTemp\\hello.txt");

        if (txt.exists()) {
            System.out.println("文件存在，无需重复创建");
        } else {
            System.out.println("文件不存在，自动创建");
            txt.createNewFile();
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(txt));
        bufferedWriter.write("hello, world~");

        System.out.println("写入完成");

        bufferedWriter.close();
    }
}
