package com.TankGame_v2;

import java.util.Vector;

public class TankEnemy extends Tank implements Runnable {
    public TankEnemy(int x, int y) {
        super(x, y);
    }

    private final Vector<Bullet> bullets = new Vector<>();

    public Vector<Bullet> getBullets() {
        return bullets;
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
                        if (getY() > 0)
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
                        if (getX() + 60 < 800)
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
                        if (getY() + 60 < 600)
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
                        if (getX() > 0)
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
}
