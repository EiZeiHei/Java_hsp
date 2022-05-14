package com.GenericExercise;

import java.util.*;

public class GenericExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Student a = new Student("A");
        Student b = new Student("B");
        Student c = new Student("C");

        HashSet<Student> students = new HashSet<>();
        students.add(a);
        students.add(b);
        students.add(c);

        System.out.println("===HashSet===");
        for (Student student : students) {
            System.out.println(student);
        }

        HashMap<String, Student> stringStudentHashMap = new HashMap<>();
        stringStudentHashMap.put("A", a);
        stringStudentHashMap.put("B", b);
        stringStudentHashMap.put("C", c);

        System.out.println("===HashMap===");
        Set<Map.Entry<String, Student>> entries = stringStudentHashMap.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next = iterator.next();
            System.out.println(next.getKey() + "\t" + next.getValue());
        }
    }
}
