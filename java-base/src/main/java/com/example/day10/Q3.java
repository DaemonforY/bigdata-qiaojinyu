package com.example.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q3 {
    public static void main(String[] args) {
        Q3 q3 = new Q3();
        // 3. 从一组订单中，找出总金额最高的前3个订单的订单号
        System.out.println("\n3. 找出总金额最高的前3个订单的订单号:");
        List<Order1> orders =new ArrayList<>( Arrays.asList(
                new Order1("ORD001", 1500.0),
                new Order1("ORD002", 2300.0),
                new Order1("ORD003", 800.0),
                new Order1("ORD004", 3200.0),
                new Order1("ORD005", 1800.0)
        ));
        q3.exercise3(orders);
    }

    public void exercise3(List<Order1> orders) {
        List<String> top3OrderIds = orders.stream()
                .sorted(Comparator.comparing(Order1::getAmount).reversed())
                .limit(3)
                .map(Order1::getOrderId)
                .toList();

        System.out.println("订单列表: " + orders);
        System.out.println("金额最高的前3个订单号: " + top3OrderIds);
    }
}
class Order1 {
    private String orderId;
    private double amount;

    public Order1(String orderId, double amount) {
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