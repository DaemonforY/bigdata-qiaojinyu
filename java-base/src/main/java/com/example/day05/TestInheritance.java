package com.example.day05;
// 父类
class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " 吃东西");
    }

    public void sleep() {
        System.out.println(name + " 睡觉");
    }
}

// 子类
class Dog extends Animal {
    public Dog(String name) {
        super(name); // 调用父类构造方法
    }

    // 重写父类的 eat 方法
    @Override
    public void eat() {
        System.out.println(super.getName() + " 吃骨头");
    }

    // 添加新的方法
    public void bark() {
        System.out.println(super.getName() + " 汪汪叫");
    }
}

public class TestInheritance {
    public static void main(String[] args) {
        Dog dog = new Dog("旺财");
        dog.eat();   // 输出：旺财 吃骨头
        dog.sleep(); // 输出：旺财 睡觉
        dog.bark();  // 输出：旺财 汪汪叫
    }
}