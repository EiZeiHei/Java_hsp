package com.TankGame_v3;

import java.io.*;
import java.util.Vector;

public class Record {
    private static int allNum = 0;

    private static final String path = "src\\record.txt";

    private static TankPlayer player;
    private static Vector<TankEnemy> enemies;
    private static final Vector<Node> nodes = new Vector<>();

    public static Vector<Node> getRecord() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        allNum = Integer.parseInt(bufferedReader.readLine());

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] xyd = line.split(" ");
            Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]), Integer.parseInt(xyd[2]));
            nodes.add(node);
        }

        bufferedReader.close();

        return nodes;
    }

    public static void setRecord() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));

        bufferedWriter.write(allNum + "\r\n");

        bufferedWriter.write(player.getX() + " " + player.getY() + " " + player.getDir());
        bufferedWriter.write("\r\n");

        for (int i = 0; i < enemies.size(); i++) {
            TankEnemy enemy = enemies.get(i);

            if (enemy.isLive()) {
                bufferedWriter.write(enemy.getX() + " " + enemy.getY() + " " + enemy.getDir());
                bufferedWriter.write("\r\n");
            }
        }

        bufferedWriter.close();
    }

    public static void allNumPlus() {
        allNum++;
    }

    public static int getAllNum() {
        return allNum;
    }

    public static String getPath() {
        return path;
    }

    public static void setPlayer(TankPlayer player) {
        Record.player = player;
    }

    public static void setEnemies(Vector<TankEnemy> enemies) {
        Record.enemies = enemies;
    }
}
