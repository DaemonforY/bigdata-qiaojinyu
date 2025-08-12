package com.example.day10;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExercises {
    
    public static void main(String[] args) {
        StreamExercises exercises = new StreamExercises();
        
        System.out.println("=== Java Stream 练习题 ===");
        
        // 1. 筛选字符串长度大于3的单词，并转为大写后去重，按字母顺序输出
        System.out.println("\n1. 筛选字符串长度大于3的单词，并转为大写后去重，按字母顺序输出:");
        List<String> words = Arrays.asList("apple", "banana", "cat", "dog", "elephant", "fish", "grape", "apple");
        exercises.exercise1(words);
        
        // 2. 给定一个学生列表，统计每个年级的学生人数
        System.out.println("\n2. 统计每个年级的学生人数:");
        List<Student> students = Arrays.asList(
            new Student("张三", 1, 85),
            new Student("李四", 2, 92),
            new Student("王五", 1, 78),
            new Student("赵六", 3, 88),
            new Student("钱七", 2, 95)
        );
        exercises.exercise2(students);
        
        // 3. 从一组订单中，找出总金额最高的前3个订单的订单号
        System.out.println("\n3. 找出总金额最高的前3个订单的订单号:");
        List<Order> orders = Arrays.asList(
            new Order("ORD001", 1500.0),
            new Order("ORD002", 2300.0),
            new Order("ORD003", 800.0),
            new Order("ORD004", 3200.0),
            new Order("ORD005", 1800.0)
        );
        exercises.exercise3(orders);
        
        // 4. 将一个字符串数组中的所有单词合并成一个用逗号分隔的字符串（不重复）
        System.out.println("\n4. 将字符串数组中的所有单词合并成一个用逗号分隔的字符串（不重复）:");
        String[] wordArray = {"hello", "world", "java", "stream", "hello", "world"};
        exercises.exercise4(wordArray);
        
        // 5. 统计一个整数列表中所有偶数的平方之和
        System.out.println("\n5. 统计一个整数列表中所有偶数的平方之和:");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        exercises.exercise5(numbers);
        
        // 6. 将员工列表按部门分组，并统计每个部门的平均工资
        System.out.println("\n6. 将员工列表按部门分组，并统计每个部门的平均工资:");
        List<Employee> employees = Arrays.asList(
            new Employee("张三", "技术部", 8000.0),
            new Employee("李四", "销售部", 6000.0),
            new Employee("王五", "技术部", 9000.0),
            new Employee("赵六", "人事部", 5000.0),
            new Employee("钱七", "销售部", 7000.0)
        );
        exercises.exercise6(employees);
        
        // 7. 判断一个字符串列表中，是否所有元素都以字母"a"开头
        System.out.println("\n7. 判断一个字符串列表中，是否所有元素都以字母'a'开头:");
        List<String> stringList1 = Arrays.asList("apple", "ant", "airplane");
        List<String> stringList2 = Arrays.asList("apple", "banana", "airplane");
        exercises.exercise7(stringList1);
        exercises.exercise7(stringList2);
        
        // 8. 对一组日期字符串（如"2024-06-20"），找出月份为6月的所有日期
        System.out.println("\n8. 找出月份为6月的所有日期:");
        List<String> dateStrings = Arrays.asList(
            "2024-06-15", "2024-07-20", "2024-06-30", 
            "2024-08-10", "2024-06-01", "2024-05-25"
        );
        exercises.exercise8(dateStrings);
        
        // 9. 给定学生列表，按分数段分组（<60, 60-80, >80），统计每组人数
        System.out.println("\n9. 按分数段分组统计每组人数:");
        exercises.exercise9(students);
        
        // 10. 用 Stream 实现：找出两个列表的交集和并集
        System.out.println("\n10. 找出两个列表的交集和并集:");
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);
        exercises.exercise10(list1, list2);
    }
    
    // 1. 筛选字符串长度大于3的单词，并转为大写后去重，按字母顺序输出
    private void exercise1(List<String> words) {
        List<String> result = words.stream()
                .filter(word -> word.length() > 3)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .toList();
        
        System.out.println("原始列表: " + words);
        System.out.println("结果: " + result);
    }
    
    // 2. 给定一个学生列表，统计每个年级的学生人数
    public void exercise2(List<Student> students) {
        Map<Integer, Long> gradeCount = students.stream()
                .collect(Collectors.groupingBy(
                    Student::getGrade,
                    Collectors.counting()
                ));
        
        System.out.println("学生列表: " + students);
        System.out.println("各年级人数: " + gradeCount);
    }
    
    // 3. 从一组订单中，找出总金额最高的前3个订单的订单号
    public void exercise3(List<Order> orders) {
        List<String> top3OrderIds = orders.stream()
                .sorted(Comparator.comparing(Order::getAmount).reversed())
                .limit(3)
                .map(Order::getOrderId)
                .collect(Collectors.toList());
        
        System.out.println("订单列表: " + orders);
        System.out.println("金额最高的前3个订单号: " + top3OrderIds);
    }
    
    // 4. 将一个字符串数组中的所有单词合并成一个用逗号分隔的字符串（不重复）
    public void exercise4(String[] wordArray) {
        String result = Arrays.stream(wordArray)
                .distinct()
                .collect(Collectors.joining(", "));
        
        System.out.println("原始数组: " + Arrays.toString(wordArray));
        System.out.println("合并结果: " + result);
    }
    
    // 5. 统计一个整数列表中所有偶数的平方之和
    public void exercise5(List<Integer> numbers) {
        int sum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n)
                .sum();
        
        System.out.println("数字列表: " + numbers);
        System.out.println("偶数平方之和: " + sum);
    }
    
    // 6. 将员工列表按部门分组，并统计每个部门的平均工资
    public void exercise6(List<Employee> employees) {
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDepartment,
                    Collectors.averagingDouble(Employee::getSalary)
                ));
        
        System.out.println("员工列表: " + employees);
        System.out.println("各部门平均工资: " + avgSalaryByDept);
    }
    
    // 7. 判断一个字符串列表中，是否所有元素都以字母"a"开头
    public void exercise7(List<String> stringList) {
        boolean allStartWithA = stringList.stream()
                .allMatch(s -> s.toLowerCase().startsWith("a"));
        
        System.out.println("字符串列表: " + stringList);
        System.out.println("是否所有元素都以'a'开头: " + allStartWithA);
    }
    
    // 8. 对一组日期字符串（如"2024-06-20"），找出月份为6月的所有日期
    public void exercise8(List<String> dateStrings) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        List<String> juneDates = dateStrings.stream()
                .filter(dateStr -> {
                    try {
                        LocalDate date = LocalDate.parse(dateStr, formatter);
                        return date.getMonthValue() == 6;
                    } catch (Exception e) {
                        return false;
                    }
                })
                .collect(Collectors.toList());
        
        System.out.println("日期列表: " + dateStrings);
        System.out.println("6月份的日期: " + juneDates);
    }
    
    // 9. 给定学生列表，按分数段分组（<60, 60-80, >80），统计每组人数
    public void exercise9(List<Student> students) {
        Map<String, Long> scoreGroups = students.stream()
                .collect(Collectors.groupingBy(
                    student -> {
                        int score = student.getScore();
                        if (score < 60) return "<60";
                        else if (score <= 80) return "60-80";
                        else return ">80";
                    },
                    Collectors.counting()
                ));
        
        System.out.println("学生列表: " + students);
        System.out.println("分数段统计: " + scoreGroups);
    }
    
    // 10. 用 Stream 实现：找出两个列表的交集和并集
    public void exercise10(List<Integer> list1, List<Integer> list2) {
        // 交集
        List<Integer> intersection = list1.stream()
                .filter(list2::contains)
                .distinct()
                .collect(Collectors.toList());
        
        // 并集
        List<Integer> union = Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .collect(Collectors.toList());
        
        System.out.println("列表1: " + list1);
        System.out.println("列表2: " + list2);
        System.out.println("交集: " + intersection);
        System.out.println("并集: " + union);
    }
}

// 辅助类
class Student {
    private String name;
    private int grade;
    private int score;
    
    public Student(String name, int grade, int score) {
        this.name = name;
        this.grade = grade;
        this.score = score;
    }
    
    public String getName() { return name; }
    public int getGrade() { return grade; }
    public int getScore() { return score; }
    
    @Override
    public String toString() {
        return name + "(年级" + grade + ", 分数" + score + ")";
    }
}

class Order {
    private String orderId;
    private double amount;
    
    public Order(String orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
    }
    
    public String getOrderId() { return orderId; }
    public double getAmount() { return amount; }
    
    @Override
    public String toString() {
        return orderId + "(" + amount + ")";
    }
}

class Employee {
    private String name;
    private String department;
    private double salary;
    
    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return name + "(" + department + ", " + salary + ")";
    }
}
