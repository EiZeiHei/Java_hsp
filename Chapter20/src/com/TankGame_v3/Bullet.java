package com.TankGame_v3;

public class Bullet implements Runnable {
    private int x;
    private int y;
    private final int dir;
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

            int speed = 5;
            switch (dir) {
                case 0 ->//上
                        y -= speed;
                case 1 ->//右
                        x += speed;
                case 2 ->//下
                        y += speed;
                case 3 ->//左
                        x -= speed;
            }

            //System.out.println("子弹 x=" + x + " y=" + y);
            //当子弹移动到面板的边界时，就应该销毁（把启动的子弹的线程销毁)
            if (!(x >= 0 && x <= 800 && y >= 0 && y <= 600 && isLive)) {
                //System.out.println("子弹线程退出");
                isLive = false;
                break;
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
