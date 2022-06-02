package com.TankGame_v2;

import javax.swing.*;
import java.awt.*;

public class TankGame extends JFrame {
    private Panel panel;

    public static void main(String[] args) {
        TankGame tankGame = new TankGame();
    }

    public TankGame() throws HeadlessException {
        panel = new Panel();

        new Thread(panel).start();

        this.add(panel);
        this.setSize(800, 600);
        this.addKeyListener(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
