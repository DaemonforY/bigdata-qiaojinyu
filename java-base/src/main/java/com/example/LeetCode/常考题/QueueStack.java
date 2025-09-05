package com.example.LeetCode.常考题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈
 * */
public class QueueStack {
    // 声明两个队列
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    // 初始化队列
    public QueueStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    // 入栈操作
    public void push(int x) {
        // 将元素加入非空队列（如果都为空，默认加入queue1）
        if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
    }
    // 出栈操作
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空，无法弹出元素");
        }
        // 确定哪个队列非空，哪个为空
        Queue<Integer> nonEmptyQueue = queue1.isEmpty() ? queue2 : queue1;
        Queue<Integer> emptyQueue = queue1.isEmpty() ? queue1 : queue2;
        // 将非空队列中除最后一个元素外的所有元素转移到空队列
        while (nonEmptyQueue.size() > 1) {
            emptyQueue.offer(nonEmptyQueue.poll());
        }
        // 弹出最后一个元素（栈顶元素）
        return nonEmptyQueue.poll();
    }
    // 获取栈顶元素
    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空，无法获取栈顶元素");
        }

        int top = pop(); // 先弹出栈顶元素
        push(top);       // 再将其入栈
        return top;
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
    public static void main(String[] args) {
        QueueStack stack = new QueueStack();

        // 测试入栈
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // 测试出栈和获取栈顶
        System.out.println("栈顶元素: " + stack.top()); // 应该输出3
        System.out.println("弹出元素: " + stack.pop());  // 应该输出3
        System.out.println("栈顶元素: " + stack.top()); // 应该输出2
        System.out.println("弹出元素: " + stack.pop());  // 应该输出2

        // 继续入栈
        stack.push(4);
        System.out.println("栈顶元素: " + stack.top()); // 应该输出4
        System.out.println("弹出元素: " + stack.pop());  // 应该输出4
        System.out.println("弹出元素: " + stack.pop());  // 应该输出1
        System.out.println("栈是否为空: " + stack.isEmpty()); // 应该输出true
    }
}
