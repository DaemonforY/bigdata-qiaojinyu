package com.example.day03;
import java.util.*;

public class CourseRegistrationSystem {
    private Map<String, Set<String>> studentCourses;

    public CourseRegistrationSystem() {
        studentCourses = new HashMap<>();
    }

    // 添加课程
    public void addCourse(String studentName, String courseName) {
        studentCourses.computeIfAbsent(studentName, k -> new HashSet<>());
        boolean added = studentCourses.get(studentName).add(courseName);
        if (added) {
            System.out.println("添加课程 '" + courseName + "' 至学生 '" + studentName + "'");
        } else {
            System.out.println("学生 '" + studentName + "' 已注册课程 '" + courseName + "'");
        }
    }

    // 删除课程
    public void removeCourse(String studentName, String courseName) {
        Set<String> courses = studentCourses.get(studentName);
        if (courses != null && courses.remove(courseName)) {
            System.out.println("从学生 '" + studentName + "' 移除课程 '" + courseName + "'");
        } else {
            System.out.println("学生 '" + studentName + "' 未注册课程 '" + courseName + "'");
        }
    }

    // 展示学生的课程
    public void showCourses(String studentName) {
        Set<String> courses = studentCourses.get(studentName);
        if (courses != null && !courses.isEmpty()) {
            System.out.println("学生 '" + studentName + "' 的课程列表:");
            for (String course : courses) {
                System.out.println("- " + course);
            }
        } else {
            System.out.println("学生 '" + studentName + "' 未注册任何课程");
        }
    }

    // 主方法，进行程序交互
    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n课程管理系统");
            System.out.println("1. 添加课程");
            System.out.println("2. 删除课程");
            System.out.println("3. 展示课程列表");
            System.out.println("4. 退出");
            System.out.print("选择操作: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // 处理换行符

            switch (choice) {
                case 1:
                    System.out.print("输入学生姓名: ");
                    String studentName = scanner.nextLine();
                    System.out.print("输入课程名称: ");
                    String courseName = scanner.nextLine();
                    system.addCourse(studentName, courseName);
                    break;
                case 2:
                    System.out.print("输入学生姓名: ");
                    studentName = scanner.nextLine();
                    System.out.print("输入课程名称: ");
                    courseName = scanner.nextLine();
                    system.removeCourse(studentName, courseName);
                    break;
                case 3:
                    System.out.print("输入学生姓名: ");
                    studentName = scanner.nextLine();
                    system.showCourses(studentName);
                    break;
                case 4:
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
