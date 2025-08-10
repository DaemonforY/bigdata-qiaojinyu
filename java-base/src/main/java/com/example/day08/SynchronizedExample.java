package com.example.day08;
class BankAccount {
    private int balance = 100;

    public synchronized void withdraw(int amount, String name) {
        if (balance >= amount) {
            System.out.println(name + " is going to withdraw");
            balance -= amount;
            System.out.println(name + " completed the withdrawal, remaining balance: " + balance);
        } else {
            System.out.println(name + " cannot withdraw due to insufficient balance, remaining balance: " + balance);
        }
    }
}

public class SynchronizedExample {
    public static void main(String[] args) {
        final BankAccount account = new BankAccount();
        Runnable task = () -> account.withdraw(60, Thread.currentThread().getName());

        Thread t1 = new Thread(task, "Thread1");
        Thread t2 = new Thread(task, "Thread2");

        t1.start();
        t2.start();
    }
}