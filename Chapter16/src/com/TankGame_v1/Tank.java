package com.TankGame_v1;

public class Tank {
    private int x;
    private int y;
    private int dir;
    private int speed;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
        speed = 1;
    }

    public void move(int dir) {
        switch (dir) {
            case 0:
                y -= speed;
                break;
            case 1:
                x += speed;
                break;
            case 2:
                y += speed;
                break;
            case 3:
                x -= speed;
                break;
            default:
                System.out.println("Error");
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
}
