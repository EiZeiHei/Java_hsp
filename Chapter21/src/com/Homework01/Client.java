package com.Homework01;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        System.out.println("=======Output=======");
        System.out.println("=======q for quit=======");

        Scanner scanner = new Scanner(System.in);
        String str;
        while (true) {
            str = scanner.nextLine();
            bufferedWriter.write(str);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            if (str.equals("q")) {
                System.out.println("=======quit=======");
                break;
            }
        }

        bufferedWriter.close();
        socket.close();
        System.out.println("=======Client exit=======");
    }
}
