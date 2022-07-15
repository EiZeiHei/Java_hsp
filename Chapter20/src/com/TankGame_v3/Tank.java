package com.TankGame_v3;

public class Tank {
    private int x;
    private int y;
    private int dir;
    private final int speed;
    private boolean isLive = true;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
        speed = 2;
    }

    public void move(int dir) {
        switch (dir) {
            case 0 -> y -= speed;
            case 1 -> x += speed;
            case 2 -> y += speed;
            case 3 -> x -= speed;
            default -> System.out.println("Error");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
