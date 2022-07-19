package com.Homework03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        System.out.println("=======Output=======");

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        bufferedWriter.write(str);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        if (!str.equals("喜欢一个人 - 陈奕迅.flac")) {
            System.out.println("=======return default song=======");
            str = "十年 - 陈奕迅.flac";
        }
        str = "src\\com\\" + str;

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
        bufferedOutputStream.write(bytes);

        bufferedOutputStream.close();
        bufferedInputStream.close();
        bufferedWriter.close();
        socket.close();
        System.out.println("=======Client exit=======");
    }
}
