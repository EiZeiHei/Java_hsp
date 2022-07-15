package com.TankGame_v3;

import java.util.Vector;

public class TankEnemy extends Tank implements Runnable {
    public TankEnemy(int x, int y) {
        super(x, y);
    }

    private final Vector<Bullet> bullets = new Vector<>();

    private Vector<TankEnemy> enemies = new Vector<>();

    public Vector<Bullet> getBullets() {
        return bullets;
    }

    public void setEnemies(Vector<TankEnemy> enemies) {
        this.enemies = enemies;
    }

    @Override
    public void run() {
        do {
            for (int i = 0; i < bullets.size(); i++) {
                if (!bullets.get(i).isLive())
                    bullets.remove(bullets.get(i));
            }

            if (isLive() && bullets.size() < 3) {
                Bullet bullet = switch (getDir()) {
                    case 0 -> new Bullet(getX() + 25, getY(), 0);
                    case 1 -> new Bullet(getX() + 60, getY() + 20, 1);
                    case 2 -> new Bullet(getX() + 25, getY() + 60, 2);
                    case 3 -> new Bullet(getX(), getY() + 25, 3);
                    default -> null;
                };

                bullets.add(bullet);
                new Thread(bullet).start();
            }

            int footRate = 30;
            switch (getDir()) {
                case 0:
                    for (int i = 0; i < footRate; i++) {
                        if (getY() > 0 && isNotOverlap())
                            move(0);

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < footRate; i++) {
                        if (getX() + 60 < 800 && isNotOverlap())
                            move(1);

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < footRate; i++) {
                        if (getY() + 60 < 600 && isNotOverlap())
                            move(2);

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < footRate; i++) {
                        if (getX() > 0 && isNotOverlap())
                            move(3);

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }

            setDir((int) (Math.random() * 4));

        } while (isLive());
    }

    public boolean isNotOverlap() {
        switch (getDir()) {
            case 0:
                for (int i = 0; i < enemies.size(); i++) {
                    TankEnemy enemy = enemies.get(i);

                    if (enemy != this) {
                        if (enemy.getDir() == 0 || enemy.getDir() == 2) {
                            if (compare(this.getX(), this.getY(), enemy.getX(), enemy.getY(),
                                    enemy.getX() + 50, enemy.getY() + 60))
                                return false;
                            if (compare(this.getX() + 50, this.getY(), enemy.getX(), enemy.getY(),
                                    enemy.getX() + 50, enemy.getY() + 60))
                                return false;
                        }
                        if (enemy.getDir() == 1 || enemy.getDir() == 3) {
                            if (compare(this.getX(), this.getY(), enemy.getX(), enemy.getY(),
                                    enemy.getX() + 60, enemy.getY() + 50))
                                return false;
                            if (compare(this.getX() + 50, this.getY(), enemy.getX(), enemy.getY(),
                                    enemy.getX() + 60, enemy.getY() + 50))
                                return false;
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < enemies.size(); i++) {
                    TankEnemy enemy = enemies.get(i);

                    if (enemy != this) {
                        if (enemy.getDir() == 0 || enemy.getDir() == 2) {
                            if (compare(this.getX() + 60, this.getY(), enemy.getX(), enemy.getY(),
                                    enemy.getX() + 50, enemy.getY() + 60))
                                return false;
                            if (compare(this.getX() + 60, this.getY() + 50, enemy.getX(), enemy.getY(),
                                    enemy.getX() + 50, enemy.getY() + 60))
                                return false;
                        }
                        if (enemy.getDir() == 1 || enemy.getDir() == 3) {
                            if (compare(this.getX() + 60, this.getY(), enemy.getX(), enemy.getY(),
                                    enemy.getX() + 60, enemy.getY() + 50))
                                return false;
                            if (compare(this.getX() + 60, this.getY() + 50, enemy.getX(), enemy.getY(),
                                    enemy.getX() + 60, enemy.getY() + 50))
                                return false;
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < enemies.size(); i++) {
                    TankEnemy enemy = enemies.get(i);

                    if (enemy != this) {
                        if (enemy.getDir() == 0 || enemy.getDir() == 2) {
                            if (compare(this.getX(), this.getY() + 60, enemy.getX(), enemy.getY(),
                                    enemy.getX() + 50, enemy.getY() + 60))
                                return false;
                            if (compare(this.getX() + 50, this.getY() + 60, enemy.getX(), enemy.getY(),
                                    enemy.getX() + 50, enemy.getY() + 60))
                                return false;
                        }
                        if (enemy.getDir() == 1 || enemy.getDir() == 3) {
                            if (compare(this.getX(), this.getY() + 60, enemy.getX(), enemy.getY(),
                                    enemy.getX() + 60, enemy.getY() + 50))
                                return false;
                            if (compare(this.getX() + 50, this.getY() + 60, enemy.getX(), enemy.getY(),
                                    enemy.getX() + 60, enemy.getY() + 50))
                                return false;
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < enemies.size(); i++) {
                    TankEnemy enemy = enemies.get(i);

                    if (enemy != this) {
                        if (enemy.getDir() == 0 || enemy.getDir() == 2) {
                            if (compare(this.getX(), this.getY(), enemy.getX(), enemy.getY(),
                                    enemy.getX() + 50, enemy.getY() + 60))
                                return false;
                            if (compare(this.getX(), this.getY() + 50, enemy.getX(), enemy.getY(),
                                    enemy.getX() + 50, enemy.getY() + 60))
                                return false;
                        }
                        if (enemy.getDir() == 1 || enemy.getDir() == 3) {
                            if (compare(this.getX(), this.getY(), enemy.getX(), enemy.getY(),
                                    enemy.getX() + 60, enemy.getY() + 50))
                                return false;
                            if (compare(this.getX(), this.getY() + 50, enemy.getX(), enemy.getY(),
                                    enemy.getX() + 60, enemy.getY() + 50))
                                return false;
                        }
                    }
                }
                break;
        }
        return true;
    }

    public boolean compare(int x, int y, int rangeX1, int rangeY1, int rangeX2, int rangeY2) {
        return x > rangeX1 && x < rangeX2 && y > rangeY1 && y < rangeY2;
    }
}
