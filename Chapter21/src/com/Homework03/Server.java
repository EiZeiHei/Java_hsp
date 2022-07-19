package com.Homework03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server: waiting at 9999");

        Socket socket = serverSocket.accept();
        System.out.println("socket: " + socket.getClass());

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println("=======Input=======");
        String str = bufferedReader.readLine();
        System.out.println(str);

        if (!str.equals("喜欢一个人 - 陈奕迅.flac")) {
            System.out.println("=======return default song=======");
            str = "十年 - 陈奕迅.flac";
        }

        BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream("src\\com\\Homework03\\" + str));

        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(bytes);
        socket.shutdownOutput();

        bufferedOutputStream.close();
        bufferedInputStream.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
        System.out.println("=======Server exit=======");
    }
}
