package com.example.day03;

import java.util.*;

class Student1 {
    private String id;
    private String name;
    private int age;
    private String department;

    public Student1(String id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    @Override
    public String toString() {
        return "学号: " + id + ", 姓名: " + name + ", 年龄: " + age + ", 院系: " + department;
    }
}

public class StudentInformationSystem {
    private Map<String, Student1> studentMap;

    public StudentInformationSystem() {
        studentMap = new HashMap<>();
    }

    // 添加学生信息
    public void addStudent(String id, String name, int age, String department) {
        Student1 student = new Student1(id, name, age, department);
        studentMap.put(id, student);
        System.out.println("新增学生: " + student);
    }

    // 查找学生信息
    public void findStudent(String id) {
        Student1 student = studentMap.get(id);
        if (student != null) {
            System.out.println("查询结果: " + student);
        } else {
            System.out.println("未找到学号为 " + id + " 的学生");
        }
    }

    // 主方法，进行程序交互
    public static void main(String[] args) {
        StudentInformationSystem system = new StudentInformationSystem();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n学生信息系统");
            System.out.println("1. 新增学生信息");
            System.out.println("2. 查找学生信息");
            System.out.println("3. 退出");
            System.out.print("选择操作: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // 处理换行符

            switch (choice) {
                case 1:
                    System.out.print("输入学号: ");
                    String id = scanner.nextLine();
                    System.out.print("输入姓名: ");
                    String name = scanner.nextLine();
                    System.out.print("输入年龄: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // 处理换行符
                    System.out.print("输入院系: ");
                    String department = scanner.nextLine();
                    system.addStudent(id, name, age, department);
                    break;
                case 2:
                    System.out.print("输入学号: ");
                    id = scanner.nextLine();
                    system.findStudent(id);
                    break;
                case 3:
                    isRunning = false;
                    System.out.println("退出系统");
                    break;
                default:
                    System.out.println("无效选项，请重试");
            }
        }

        scanner.close();
    }
}
