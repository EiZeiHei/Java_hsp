package com.Homework;

import java.util.*;

public class DAO<T> {
    private final Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.replace(id, entity);
    }

    public List<T> list() {
        List<T> list = new ArrayList<>();

        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            list.add(map.get(s));
        }

        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }

    @Override
    public String toString() {
        return "DAO{" +
                "map=" + map +
                '}';
    }
}
