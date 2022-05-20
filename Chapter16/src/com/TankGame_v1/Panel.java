package com.TankGame_v1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class Panel extends JPanel implements KeyListener {
    private TankPlayer player;
    private Vector<TankEnemy> enemies = new Vector<>();
    private int enemyNum;

    public Panel() {
        player = new TankPlayer(100, 100);
        enemyNum = 3;
        for (int i = 0; i < enemyNum; i++) {
            TankEnemy enemy = new TankEnemy(100 * (i + 1), 10);
            enemy.setDir(2);
            enemies.add(enemy);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 800, 600);

        drawTank(player.getX(), player.getY(), g, player.getDir(), 0);

        for (TankEnemy enemy : enemies) {
            drawTank(enemy.getX(), enemy.getY(), g, enemy.getDir(), 1);
        }
    }

    // position (x, y), pen g, direction dir, type player/enemy
    public void drawTank(int x, int y, Graphics g, int dir, int type) {
        switch (type) {
            case 0 -> // our tank, player
                    g.setColor(Color.magenta);
            case 1 -> // enemy tank
                    g.setColor(Color.yellow);
        }

        switch (dir) {
            case 0 -> { // Up
                g.fill3DRect(x, y, 15, 60, false); // left
                g.fill3DRect(x + 35, y, 15, 60, false); // right
                g.fill3DRect(x + 15, y + 10, 20, 40, false); // main
                g.fillOval(x + 15, y + 20, 20, 20); // rotate
                g.fill3DRect(x + 24, y, 3, 30, false); // gun
            }
            case 1 -> { // right
                g.fill3DRect(x, y, 60, 15, false); // left
                g.fill3DRect(x, y + 35, 60, 15, false); // right
                g.fill3DRect(x + 10, y + 15, 40, 20, false); // main
                g.fillOval(x + 20, y + 15, 20, 20); // rotate
                g.fill3DRect(x + 30, y + 24, 30, 3, false); // gun
            }
            case 2 -> { // Down
                g.fill3DRect(x, y, 15, 60, false); // left
                g.fill3DRect(x + 35, y, 15, 60, false); // right
                g.fill3DRect(x + 15, y + 10, 20, 40, false); // main
                g.fillOval(x + 15, y + 20, 20, 20); // rotate
                g.fill3DRect(x + 24, y + 30, 3, 30, false); // gun
            }
            case 3 -> { // right
                g.fill3DRect(x, y, 60, 15, false); // left
                g.fill3DRect(x, y + 35, 60, 15, false); // right
                g.fill3DRect(x + 10, y + 15, 40, 20, false); // main
                g.fillOval(x + 20, y + 15, 20, 20); // rotate
                g.fill3DRect(x, y + 24, 30, 3, false); // gun
            }
            default -> System.out.println("Error");
        }
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_W -> {
                player.setDir(0);
                player.move(0);
            }
            case KeyEvent.VK_D -> {
                player.setDir(1);
                player.move(1);
            }
            case KeyEvent.VK_S -> {
                player.setDir(2);
                player.move(2);
            }
            case KeyEvent.VK_A -> {
                player.setDir(3);
                player.move(3);
            }
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}

