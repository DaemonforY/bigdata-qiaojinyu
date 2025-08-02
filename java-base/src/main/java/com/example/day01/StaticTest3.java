package com.example.day01;
//static 方法的继承关系
class Parent {
    /**
     * Parent 类的静态方法
     */
    static void show() {
        System.out.println("Parent's show()");
    }
}

class Child extends Parent {
    /**
     * Child 类的静态方法，重写了 Parent 类的静态方法
     */
    static void show() {
        System.out.println("Child's show()");
    }
}

public class StaticTest3 {

    public static void main(String[] args) {
        // 创建 Parent 类的实例
        Parent parent = new Parent();
        // 创建 Child 类的实例，但声明类型为 Parent
        Parent child = new Child();

        // 调用 Parent 类的静态方法
        parent.show();  // 输出 "Parent's show()"
        // 调用 Parent 类的静态方法，尽管实际对象是 Child
        // 这是因为静态方法的调用取决于声明的类型，而不是实际的类型
        child.show();  // 也输出 "Parent's show()"，因为静态方法的调用取决于声明的类型，而不是实际的类型，child 声明的类型为 Parent。

        // 创建 Child 类的实例
        Child child2 = new Child();
        // 调用 Child 类的静态方法
        child2.show();  // 输出 "Child's show()"，因为静态方法的调用取决于声明的类型，child2 声明的类型为 Child。
        // 直接通过子类名称调用静态方法
        Child.show();  // 输出 "Child's show()"，直接通过子类名称调用
    }
}

