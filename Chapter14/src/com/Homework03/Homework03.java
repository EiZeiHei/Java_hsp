package com.Homework03;

import java.util.*;

public class Homework03 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        hashMap.put("jack", 650);
        hashMap.put("tom", 1200);
        hashMap.put("smith", 2900);

        hashMap.replace("jack", 2600);

        System.out.println("-------keySet--------");
        Set set = hashMap.keySet();
        for (Object o : set) {
            hashMap.replace(o, 100 + (int) hashMap.get(o));
            System.out.println("K\t" + o + "\t\t" + "V\t" + hashMap.get(o));
        }

        System.out.println("-------entrySet--------");
        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry next = (Map.Entry) iterator.next();
            System.out.println("K\t" + next.getKey() + "\t\t" + "V\t" + next.getValue());
        }

        System.out.println("-------values--------");
        Collection values = hashMap.values();
        for (Object o : values) {
            System.out.println("V\t" + o);
        }

    }
}
