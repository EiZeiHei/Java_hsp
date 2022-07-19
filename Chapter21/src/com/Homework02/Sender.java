package com.Homework02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        System.out.println("=======Output=======");
        System.out.println("=======q for quit=======");

        Scanner scanner = new Scanner(System.in);
        String str;
        do {
            str = scanner.nextLine();

            byte[] data = str.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(data, data.length,
                    InetAddress.getByName("218.193.189.66"), 8888);
            datagramSocket.send(datagramPacket);

        } while (!str.equals("q"));

        datagramSocket.close();
        System.out.println("=======Sender exit=======");
    }
}
