package com.TankGame_v2;

public class Bullet implements Runnable {
    private int x;
    private int y;
    private int dir = 0;
    private int speed = 2;
    private boolean isLive = true;

    public Bullet(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            switch (dir) {
                case 0://上
                    y -= speed;
                    break;
                case 1://右
                    x += speed;
                    break;
                case 2://下
                    y += speed;
                    break;
                case 3://左
                    x -= speed;
                    break;
            }

            System.out.println("子弹 x=" + x + " y=" + y);
            //当子弹移动到面板的边界时，就应该销毁（把启动的子弹的线程销毁)
            if (!(x >= 0 && x <= 800 && y >= 0 && y <= 600)) {
                System.out.println("子弹线程退出");
                isLive = false;
                break;
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
