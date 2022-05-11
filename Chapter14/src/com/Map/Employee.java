package com.Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Employee {
    private final String name;
    private final int sal;
    private final String id;

    public Employee(String name, int sal, String id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    public int getSal() {
        return sal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id='" + id + '\'' +
                '}';
    }

    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Map map = new HashMap();

        map.put("1", new Employee("LA", 30000, "1"));
        map.put("2", new Employee("LA2", 3000, "2"));
        map.put("3", new Employee("LA3", 20000, "3"));
        map.put("4", new Employee("LA4", 39000, "4"));

        System.out.println("第一种便利方式");
        Set set = map.keySet();
        for (Object key : set) {
            if (((Employee) map.get(key)).getSal() > 18000) {
                System.out.println(map.get(key));
            }
        }

        System.out.println("第二种方式");
        Collection values = map.values();
        for (Object val : values) {
            if (((Employee) val).getSal() > 18000) {
                System.out.println((Employee) val);
            }
        }

        System.out.println("第三种方式");
        Set entrySet = map.entrySet();
        for (Object entry : entrySet) {
            Map.Entry kv = (Map.Entry) entry;
            if (((Employee) kv.getValue()).getSal() > 18000) {
                System.out.println((Employee) kv.getValue());
            }
        }


    }
}
