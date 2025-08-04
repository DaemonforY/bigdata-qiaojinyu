package com.example.day03;

import java.util.*;
import java.util.stream.Collectors;

// 学生评价系统

class Student3 {
    private String name;
    private double score;

    public Student3(String name, double score) {
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

public class StudentEvaluationSystem {
    private List<Student3> students;

    public StudentEvaluationSystem() {
        this.students = new ArrayList<>();
    }

    // 增加学生成绩
    public void addStudentScore(String name, double score) {
        students.add(new Student3(name, score));
    }

    // 筛选并计算平均分
    /**
 * 评估并打印出成绩在90分以上的学生信息
 */
public void evaluateAndPrintTopStudents() {
    // 过滤出成绩大于90分的学生并收集到一个列表中
    /*
    * stream() 创建流的作用是将集合（如 List、Set 等）转换为一个流，
    * 从而支持一系列 **函数式操作（如过滤、映射、归约等）
    * 主要用途包括：- filter()：过滤元素 - map()：转换元素
    * - sorted()：排序 - collect()：收集结果
    * - forEach()：遍历执行操作
    * - reduce()：归约操作（如求和、求最大值等）
    * */
    List<Student3> topStudents = students.stream()
            .filter(student -> student.getScore() > 90)
            .collect(Collectors.toList());

    // 打印90分以上的学生信息
    System.out.println("90分以上的学生:");
    topStudents.forEach(System.out::println);

    // 计算90分以上学生的平均成绩
    double averageScore = topStudents.stream()
            .mapToDouble(Student3::getScore)
            .average()
            .orElse(0);

    // 打印这些学生的平均成绩
    System.out.println("这些学生的平均分: " + averageScore);
}

    public static void main(String[] args) {
        StudentEvaluationSystem system = new StudentEvaluationSystem();
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
            system.addStudentScore(name, score);
        }

        system.evaluateAndPrintTopStudents();
        scanner.close();
    }
}
