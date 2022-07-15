package com.TankGame_v3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;

public class TankGame extends JFrame {

    public static void main(String[] args) throws IOException {
        new TankGame();
    }

    public TankGame() throws HeadlessException, IOException {
        System.out.println("请选择游戏模式：1.新游戏 2.继续游戏");
        Scanner scanner = new Scanner(System.in);
        String key = scanner.next();
        scanner.close();

        Panel panel = new Panel(key);

        new Thread(panel).start();

        this.add(panel);
        this.setSize(1100, 600);
        this.addKeyListener(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Record.setRecord();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                System.exit(0);
            }
        });
    }
}
