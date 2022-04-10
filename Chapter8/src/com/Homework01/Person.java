package com.Homework01;

public class Person {
    private String name;
    private int age;
    private String job;

    public static void main(String[] args) {
        Person[] person = new Person[3];

        person[0] = new Person("Jackie", 20, "Teacher");
        person[1] = new Person("Lucy", 18, "Dancer");
        person[2] = new Person("Mark", 48, "Driver");

        Person tmp;
        for (int i = 0; i < person.length - 1; i++) {
            for (int j = 0; j < person.length - i - 1; j++) {
                if (person[j].getAge() > person[j + 1].getAge()) {
                    tmp = person[j];
                    person[j] = person[j + 1];
                    person[j + 1] = tmp;
                }
            }
        }

        for (Person value : person) {
            System.out.println(value);
        }
    }

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
