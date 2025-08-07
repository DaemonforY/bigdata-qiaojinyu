package com.example.day06;
/**
 * 堆排序演示类
 * 场景：对空间敏感且不要求稳定性（如优先队列实现）
 */
public class HeapSortDemo {

    /**
     * 对数组进行堆排序
     * @param arr 待排序的整数数组
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 构建最大堆（重排数组）
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // 一个个从堆顶取出最大元素
        for (int i = n - 1; i > 0; i--) {
            // 将堆顶元素（当前最大）与数组末尾交换
            int temp = arr[0]; arr[0] = arr[i]; arr[i] = temp;
            // 继续对剩余元素进行堆调整
            heapify(arr, i, 0);
        }
    }

    /**
     * 将数组中的元素构造成一个最大堆
     *
     * @param arr 待排序的整数数组
     * @param n 数组长度
     * @param i 当前需要调整的节点索引
     */
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // 初始化最大值索引为当前节点
        int left = 2 * i + 1; // 左子节点索引
        int right = 2 * i + 2; // 右子节点索引

        // 如果左子节点存在且大于当前最大值
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 如果右子节点存在且大于当前最大值
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大值不是当前节点
        if (largest != i) {
            // 交换当前节点与最大值节点
            int temp = arr[i]; arr[i] = arr[largest]; arr[largest] = temp;
            // 递归调整受影响的子树
            heapify(arr, n, largest);
        }
    }
    public static void main(String[] args) {
        // 初始化数组
        int[] arr = {20, 50, 30, 10, 60, 80, 70};
        heapSort(arr);
        System.out.println(java.util.Arrays.toString(arr));
    }
}
