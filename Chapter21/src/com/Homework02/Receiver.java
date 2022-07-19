package com.Homework02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8888);

        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

        System.out.println("=======Receiver: waiting=======");

        String str;
        do {
            datagramSocket.receive(datagramPacket);

            int length = datagramPacket.getLength();
            byte[] data = datagramPacket.getData();

            str = new String(data, 0, length);
            if (str.equals("四大名著是哪些")) {
                System.out.println("四大名著是《xxx》...");
            } else if (str.equals("q")) {
                break;
            } else {
                System.out.println("what?");
            }
        } while (true);

        datagramSocket.close();
        System.out.println("=======Receiver exit=======");
    }
}
