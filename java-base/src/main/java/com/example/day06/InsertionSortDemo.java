package com.example.day06;

/**
 * 插入排序示例类
 * 场景：小规模或几乎有序的数据（如数据库索引）
 * 说明：插入排序在处理小规模或几乎有序的数据时效率较高
 */
public class InsertionSortDemo {

    /**
     * 对一个整数数组进行插入排序
     * 插入排序的基本思想是将一个记录插入到已经排序好的有序表中，从而得到一个新的、记录数增加1的有序表
     *
     * @param arr 待排序的整数数组
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            // 将arr[i]插入到已排序序列中的适当位置
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 3}; // 几乎有序
        insertionSort(arr);
        System.out.println(java.util.Arrays.toString(arr));
    }
}
