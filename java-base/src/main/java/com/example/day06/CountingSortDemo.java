package com.example.day06;

/**
 * 计数排序演示类
 * 计数排序是一种非比较排序算法，适用于一定范围内的整数排序
 * 它通过计算每个整数的出现次数来实现排序
 * 场景：整数且范围较小（如考试成绩排序）
 */
public class CountingSortDemo {

    /**
     * 使用计数排序对数组进行排序
     * 此方法适用于小范围整数的排序，当数组中的元素是正整数，
     * 并且范围较小时，计数排序非常有效
     * @param arr 待排序的整数数组
     */
    public static void countingSort(int[] arr) {
        int n = arr.length;
        if (n == 0) return;

        // 初始化最大值和最小值为数组的第一个元素
        int max = arr[0], min = arr[0];

        // 遍历数组，找到最大值和最小值，以确定计数数组的大小
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        // 计算数组元素的范围
        int range = max - min + 1;

        // 创建计数数组和输出数组
        int[] count = new int[range];
        int[] output = new int[n];

        // 统计每个元素出现的次数
        for (int num : arr) count[num - min]++;

        // 更新计数数组，使得每个元素的值是前面元素出现次数的累加
        for (int i = 1; i < range; i++) count[i] += count[i - 1];

        // 构建输出数组，实现稳定排序
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // 将排序后的数组复制回原数组
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        // 初始化一个整数数组，代表学生的成绩
        int[] arr = {88, 75, 90, 100, 99, 75, 88};
        countingSort(arr);
        System.out.println(java.util.Arrays.toString(arr));
    }
}
