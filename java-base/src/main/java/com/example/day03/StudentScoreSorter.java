package com.example.day03;


import java.util.*;

import java.util.*;

class Student2 {
    private String name;
    private double score;

    public Student2(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "学生: " + name + ", 成绩: " + score;
    }
}

public class StudentScoreSorter {
    private List<Student2> students;

    public StudentScoreSorter() {
        this.students = new ArrayList<>();
    }

    // 增加学生成绩
    public void addStudentScore(String name, double score) {
        students.add(new Student2(name, score));
    }

    // 输出前5名学生信息
    public void printTopStudents() {
        Collections.sort(students, Comparator.comparingDouble(Student2::getScore).reversed());
        System.out.println("前5名学生信息:");
        for (int i = 0; i < Math.min(5, students.size()); i++) {
            System.out.println(students.get(i));
        }
    }
    public static void main(String[] args) {
        StudentScoreSorter sorter = new StudentScoreSorter();
        Scanner scanner = new Scanner(System.in);

        System.out.print("输入学生数量: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // 处理换行符

        for (int i = 0; i < numStudents; i++) {
            System.out.print("输入学生姓名: ");
            String name = scanner.nextLine();
            System.out.print("输入学生成绩: ");
            double score = scanner.nextDouble();
            scanner.nextLine(); // 处理换行符
            sorter.addStudentScore(name, score);
        }

        sorter.printTopStudents();
        scanner.close();
    }
}