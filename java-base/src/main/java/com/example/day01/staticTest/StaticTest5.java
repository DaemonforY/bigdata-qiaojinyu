package com.example.day01.staticTest;


public class StaticTest5 {
    // 外部类的静态字段，可以在静态内部类中直接访问
    private static String outerField = "外部类的静态字段";

    // 静态内部类
    static class StaticInnerClass {
        // 静态内部类的字段
        private String staticInnerField = "静态内部类的字段";

        /**
         * 显示方法，用于输出外部类的静态字段和内部类的字段
         */
        public void display() {
            // 静态内部类可以访问外部类的静态成员
            System.out.println(outerField);
            System.out.println(staticInnerField);
        }
    }

    // 非静态内部类
    class InnerClass {
        // 内部类的字段
        private String innerField = "内部类的字段";

        /**
         * 显示方法，用于输出外部类的静态字段和内部类的字段
         */
        public void display() {
            System.out.println(outerField);
            System.out.println(innerField);
        }
    }

    /**
     * 主方法，用于测试静态内部类和非静态内部类的实例创建和方法调用
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 无需外部类实例，直接创建静态内部类实例
        StaticInnerClass staticInner = new StaticTest5.StaticInnerClass();
        staticInner.display();

        //  创建外部类实例，然后创建内部类实例
        StaticTest5 outerClass = new StaticTest5();
        StaticTest5.InnerClass inner = outerClass.new InnerClass();
        inner.display();
    }
}
// 输出结果：
//  外部类的静态字段
//  静态内部类的字段
//  外部类的静态字段
//  内部类的字段
