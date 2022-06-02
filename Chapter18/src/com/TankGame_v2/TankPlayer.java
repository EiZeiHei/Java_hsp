package com.TankGame_v2;

public class TankPlayer extends Tank {
    private Bullet bullet = null;

    public TankPlayer(int x, int y) {
        super(x, y);
    }

    public void shoot() {
        switch (getDir()) {
            case 0: //向上
                bullet = new Bullet(getX() + 24, getY(), 0);
                break;
            case 1: //向右
                bullet = new Bullet(getX() + 60, getY() + 24, 1);
                break;
            case 2: //向下
                bullet = new Bullet(getX() + 24, getY() + 60, 2);
                break;
            case 3: //向左
                bullet = new Bullet(getX(), getY() + 24, 3);
                break;
        }

        new Thread(bullet).start();
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }
}
