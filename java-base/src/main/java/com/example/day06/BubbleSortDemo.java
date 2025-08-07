package com.example.day06;

import java.util.Arrays;

/**
 * 冒泡排序示例类
 * 场景：小规模、几乎有序的数组排序
 */
public class BubbleSortDemo {
    /**
     * 对整型数组进行冒泡排序
     *
     * @param arr 待排序的整型数组
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            boolean swap = false;
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // 交换 arr[j] 和 arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            if (!swap) break; // 如果在内层循环中没有发生交换，说明数组已经有序，提前终止排序过程
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 4}; // 初始化一个接近有序的数组
        bubbleSort(arr); // 对数组进行排序
        System.out.println(Arrays.toString(arr)); // 打印排序后的数组
    }
}
