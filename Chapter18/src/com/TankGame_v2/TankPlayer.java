package com.TankGame_v2;

import java.util.Vector;

public class TankPlayer extends Tank {
    private final Vector<Bullet> bullets = new Vector<>();

    public TankPlayer(int x, int y) {
        super(x, y);
    }

    public void shoot() {
        for (int i = 0; i < bullets.size(); i++) {
            if (!bullets.get(i).isLive())
                bullets.remove(bullets.get(i));
        }

        int maxBullet = 7;
        if (bullets.size() == maxBullet)
            return;

        Bullet bullet = switch (getDir()) {
            case 0 -> //向上
                    new Bullet(getX() + 24, getY(), 0);
            case 1 -> //向右
                    new Bullet(getX() + 60, getY() + 24, 1);
            case 2 -> //向下
                    new Bullet(getX() + 24, getY() + 60, 2);
            case 3 -> //向左
                    new Bullet(getX(), getY() + 24, 3);
            default -> null;
        };

        bullets.add(bullet);

        new Thread(bullet).start();
    }

    public Vector<Bullet> getBullets() {
        return bullets;
    }
}
