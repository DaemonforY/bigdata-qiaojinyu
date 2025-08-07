package com.example.day06;

/**
 * 快速排序演示类
 * 适用于大规模数据集且不需要稳定性的排序场景
 * 快速排序是一种高效的排序算法，采用分治法策略
 * 最好情况时间复杂度为O(nlogn)，最坏情况为O(n^2)
 * 不稳定排序，原地排序（不需要额外的存储空间）
 */
public class QuickSortDemo {

    /**
     * 快速排序主函数
     * @param arr 待排序的数组
     * @param low 排序起始索引
     * @param high 排序结束索引
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi是分区索引，arr[pi]的位置已经确定
            int pi = partition(arr, low, high);
            // 递归排序左子数组
            quickSort(arr, low, pi - 1);
            // 递归排序右子数组
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * 分区函数
     * 选择数组最右侧元素作为基准值，小于等于基准值的元素移动到基准值左侧，大于基准值的元素移动到基准值右侧
     * @param arr 待分区的数组
     * @param low 分区起始索引
     * @param high 分区结束索引
     * @return 基准值的最终索引
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // 交换元素
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        // 交换基准值到正确位置
        int temp = arr[i+1]; arr[i+1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    /**
     * 主函数
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        int[] arr = {33, 10, 55, 71, 29, 3, 18}; // 大量无序数据
        quickSort(arr, 0, arr.length - 1);
        System.out.println(java.util.Arrays.toString(arr));
    }
}
