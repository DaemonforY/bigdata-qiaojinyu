package com.example.day06;

/**
 * 选择排序演示类
 * 适用于数据量小且对稳定性无要求的场景
 */
public class SelectionSortDemo {

    /**
     * 选择排序方法
     * 遍历数组，每次找到最小元素的索引，并将其与当前位置的元素交换
     *
     * @param arr 待排序的整型数组
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * 主方法
     * 创建一个小数据量的数组并进行选择排序，然后输出排序结果
     *
     * @param args 命令行参数，未使用
     */
    public static void main(String[] args) {
        int[] arr = {29, 10, 14, 37, 13}; // 小数据量
        selectionSort(arr);
        System.out.println(java.util.Arrays.toString(arr));
    }
}
