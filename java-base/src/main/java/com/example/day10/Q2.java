package com.example.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q2 {
    // 2. 给定一个学生列表，统计每个年级的学生人数
    public void exercise2(List<Student1> students) {
        Map<Integer, Long> gradeCount = students.stream()
                .collect(Collectors.groupingBy(
                        Student1::getGrade,
                        Collectors.counting()
                ));

        System.out.println("学生列表: " + students);
        System.out.println("各年级人数: " + gradeCount);
    }



    public static void main(String[] args) {
        Q2 exercises = new Q2();
        // 2. 给定一个学生列表，统计每个年级的学生人数
        System.out.println("\n2. 统计每个年级的学生人数:");
        // 外层 new ArrayList<>(...)创建 java.util.ArrayList 实例的构造方法，
        // 它接收一个已有的集合作为参数，将该集合中的所有元素复制到新创建的 ArrayList 中。
        // 内部Arrays.asList(...) 是 Java 提供的工具方法，用于将一组对象转换为 List 集合,
        //
        List<Student1> students = new ArrayList<>(Arrays.asList(
                new Student1("张三", 1, 85),
                new Student1("李四", 2, 92),
                new Student1("王五", 1, 78),
                new Student1("赵六", 3, 88),
                new Student1("钱七", 2, 95)
        ));

        Student1 student = students.get(0);
        student.setScore(90); // 通过 setter 安全修改分数
        // 先用无参构造创建空对象
        Student1 student1 = new Student1();
        // 后续通过 setter 逐个赋值
        student1.setName("孙八");
        student1.setGrade(3);
        student1.setScore(82);
        // 将新学生添加到列表中
        students.add(student1);
        exercises.exercise2(students);

    }

}

class Student1 {
    private String name;
    private int grade;
    private int score;

    public Student1(String name, int grade, int score) {
        this.name = name;
        this.grade = grade;
        this.score = score;
    }
    // 无参构造函数
    /*
    * 当你需要先创建对象，再通过 setter 方法逐步设置属性时，必须依赖无参构造函数。
    * 否则就必须在创建对象时一次性传完所有参数（如 new Student1("孙八", 3, 82)），
    * 无法分步骤设置属性。
    *
    * */
    public Student1(){
    }

    /*
    * getter方法
    * 因为 name、grade、score 被 private 修饰（私有），
    * 外部代码不能直接通过 student.name 访问，必须通过 getter 方法获取。
    * 例如在你的 Q2 类中，Student1::getGrade 就是通过 getGrade() 方法获取年级
    *setter 方法
    * 修改私有属性的值,添加数据校验逻辑,
    * 外部代码不能直接通过 student.grade = 3 修改属性，必须通过 setter 方法。
    * */
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getGrade() { return grade; }
    public void setGrade(int grade) { this.grade = grade; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    @Override
    public String toString() {
        return name + "(年级" + grade + ", 分数" + score + ")";
    }
}
