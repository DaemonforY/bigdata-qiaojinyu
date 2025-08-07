package com.example.day06;

/**
 * 归并排序演示类
 * 适用于大规模数据集和对稳定性有要求的场景（如外部排序）
 */
public class MergeSortDemo {

    /**
     * 归并排序的递归实现
     * @param arr 待排序的数组
     * @param left 数组的左边界
     * @param right 数组的右边界
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // 计算中间点，避免整数溢出
            int mid = left + (right - left) / 2;
            // 递归排序左半部分
            mergeSort(arr, left, mid);
            // 递归排序右半部分
            mergeSort(arr, mid + 1, right);
            // 合并两个有序部分
            merge(arr, left, mid, right);
        }
    }

    /**
     * 合并两个有序数组段
     *
     * @param arr 待合并的数组
     * @param left 左段的起始索引
     * @param mid 左段的结束索引和右段的起始索引
     * @param right 右段的结束索引
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        // 左右段的长度
        int n1 = mid - left + 1, n2 = right - mid;
        // 创建临时数组存放左右段
        int[] L = new int[n1];
        int[] R = new int[n2];
        // 复制数据到临时数组
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);
        // 初始化左右段的索引和合并后的索引
        int i = 0, j = 0, k = left;
        // 合并左右段
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // 复制左段剩余元素
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        // 复制右段剩余元素
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * 主函数，用于测试归并排序
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 初始化一个包含大量数据的数组
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        // 调用归并排序方法
        mergeSort(arr, 0, arr.length - 1);
        // 输出排序后的数组
        System.out.println(java.util.Arrays.toString(arr));
    }
}
