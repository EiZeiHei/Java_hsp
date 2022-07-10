package com.Homework02;

import java.io.*;

public class Homework02 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                new FileInputStream("E:\\LA\\Downloads\\NewText.txt"), "GBK"));

        String line;
        int lineNum = 1;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(lineNum++ + " " + line);
        }

        bufferedReader.close();
    }
}
