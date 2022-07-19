package com.Homework01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server: waiting at 9999");

        Socket socket = serverSocket.accept();
        System.out.println("socket: " + socket.getClass());

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println("=======Input=======");
        String str;

        do {
            str = bufferedReader.readLine();
            switch (str) {
                case "name" -> System.out.println("我是 nova");
                case "hobby" -> System.out.println("编写 java 程序");
                default -> System.out.println("你说啥呢");
            }
        } while (!str.equals("q"));

        bufferedReader.close();
        socket.close();
        serverSocket.close();
        System.out.println("=======Server exit=======");
    }
}
