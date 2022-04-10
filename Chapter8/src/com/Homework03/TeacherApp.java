package com.Homework03;

public class TeacherApp {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Jackie", 58, "NaN", 13000);
        teacher.introduce();

        Professor professor = new Professor("Chan", 44, "Professor", 50000);
        professor.introduce();

        VicePro vicePro = new VicePro("Lin", 43, "Vice Professor", 40000);
        vicePro.introduce();

        Lecturer lecturer = new Lecturer("Liu", 25, "Lecturer", 30000);
        lecturer.introduce();
    }
}
