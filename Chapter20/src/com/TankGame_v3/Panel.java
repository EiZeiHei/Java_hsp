package com.TankGame_v3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class Panel extends JPanel implements KeyListener, Runnable {
    private final TankPlayer player;
    private final Vector<TankEnemy> enemies = new Vector<>();
    private final Vector<Bomb> bombs = new Vector<>();

    Image image1;
    Image image2;
    Image image3;

    public Panel(String key) throws IOException {
        File file = new File(Record.getPath());
        if (!file.exists()) {
            System.out.println("无存档，只能选择新游戏");
            key = "1";
        }

        switch (key) {
            case "1" -> {
                player = new TankPlayer(400, 500);
                int enemyNum = 7;
                for (int i = 0; i < enemyNum; i++) {
                    TankEnemy enemy = new TankEnemy(100 * (i + 1), 10);
                    enemy.setEnemies(enemies);
                    enemy.setDir(2);
                    new Thread(enemy).start();

                    enemies.add(enemy);
                }
            }
            case "2" -> {
                Vector<Node> nodes = Record.getRecord();
                player = new TankPlayer(nodes.get(0).x(), nodes.get(0).y());
                player.setDir(nodes.get(0).dir());
                for (int i = 1; i < nodes.size(); i++) {
                    Node node = nodes.get(i);

                    TankEnemy enemy = new TankEnemy(node.x(), node.y());
                    enemy.setEnemies(enemies);
                    enemy.setDir(node.dir());
                    new Thread(enemy).start();

                    enemies.add(enemy);
                }
            }
            default -> {
                System.out.println("输入有误");
                player = new TankPlayer(400, 500);
            }
        }

        Record.setEnemies(enemies);
        Record.setPlayer(player);

        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

        new AePlayWave("src\\start.wav").start();
    }

    public void showInfo(Graphics g) {
        g.setColor(Color.BLACK);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);

        g.drawString("累计击毁敌方坦克：", 830, 50);
        drawTank(830, 90, g, 0, 1);
        g.setColor(Color.BLACK);
        g.drawString(Record.getAllNum() + "", 900, 130);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        showInfo(g);
        g.fillRect(0, 0, 800, 600);

        if (player.isLive())
            drawTank(player.getX(), player.getY(), g, player.getDir(), 0);

        for (int i = 0; i < player.getBullets().size(); i++) {
            Bullet bullet = player.getBullets().get(i);
            if (bullet != null && bullet.isLive())
                g.fillRect(bullet.getX(), bullet.getY(), 3, 3);
        }

        for (TankEnemy enemy : enemies) {
            if (enemy.isLive()) {
                drawTank(enemy.getX(), enemy.getY(), g, enemy.getDir(), 1);
                for (int i = 0; i < enemy.getBullets().size(); i++) {
                    Bullet bullet = enemy.getBullets().get(i);
                    if (bullet.isLive()) {
                        g.fillRect(bullet.getX(), bullet.getY(), 3, 3);
                    } else {
                        enemy.getBullets().remove(bullet);
                    }
                }
            }
        }

        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.getLife() > 20) {
                g.drawImage(image1, bomb.getX(), bomb.getY(), 60, 60, this);
            } else if (bomb.getLife() > 10) {
                g.drawImage(image2, bomb.getX(), bomb.getY(), 60, 60, this);
            } else {
                g.drawImage(image3, bomb.getX(), bomb.getY(), 60, 60, this);
            }

            bomb.lifeDown();

            if (bomb.getLife() == 0) {
                bombs.remove(bomb);
            }
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

    public void hitEnemy() {
        for (int i = 0; i < player.getBullets().size(); i++) {
            Bullet bullet = player.getBullets().get(i);

            if (bullet != null && bullet.isLive()) {
                for (int j = 0; j < enemies.size(); j++) {
                    TankEnemy enemy = enemies.get(j);
                    hitTank(bullet, enemy);
                }
            }
        }
    }

    public void hitPlayer() {
        for (int i = 0; i < enemies.size(); i++) {
            TankEnemy enemy = enemies.get(i);
            for (int j = 0; j < enemy.getBullets().size(); j++) {
                Bullet bullet = enemy.getBullets().get(j);
                if (player.isLive() && bullet.isLive())
                    hitTank(bullet, player);
            }
        }
    }

    public void hitTank(Bullet bullet, Tank tank) {
        switch (tank.getDir()) {
            case 0:
            case 2:
                if (bullet.getX() > tank.getX() && bullet.getX() < tank.getX() + 50
                        && bullet.getY() > tank.getY() && bullet.getY() < tank.getY() + 60) {
                    hitAction(bullet, tank);
                }
                break;
            case 1:
            case 3:
                if (bullet.getX() > tank.getX() && bullet.getX() < tank.getX() + 60
                        && bullet.getY() > tank.getY() && bullet.getY() < tank.getY() + 50) {
                    hitAction(bullet, tank);
                }
                break;
        }
    }

    private void hitAction(Bullet bullet, Tank tank) {
        bullet.setLive(false);

        tank.setLive(false);
        enemies.remove(tank);

        if (tank instanceof TankEnemy)
            Record.allNumPlus();

        Bomb bomb = new Bomb(tank.getX(), tank.getY());
        bombs.add(bomb);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_W -> {
                player.setDir(0);

                if (player.getY() > 0)
                    player.move(0);
            }
            case KeyEvent.VK_D -> {
                player.setDir(1);

                if (player.getX() + 60 < 800)
                    player.move(1);
            }
            case KeyEvent.VK_S -> {
                player.setDir(2);

                if (player.getY() + 60 < 600)
                    player.move(2);
            }
            case KeyEvent.VK_A -> {
                player.setDir(3);

                if (player.getX() > 0)
                    player.move(3);
            }
        }

        if (keyEvent.getKeyCode() == KeyEvent.VK_J) {
            player.shoot();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            hitEnemy();

            hitPlayer();

            repaint();
        }
    }
}

