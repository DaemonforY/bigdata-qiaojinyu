package com.example.LeetCode.day1;

/**
 * 该类提供了两个字符串表示的数字相乘的功能
 */
class Multiply {
    /**
     * 实现字符串表示的两个数字的相乘
     *
     * @param num1 第一个乘数，以字符串形式表示
     * @param num2 第二个乘数，以字符串形式表示
     * @return 返回两个乘数的乘积，以字符串形式表示
     */
    public String multiply(String num1, String num2) {
        // 初始化两个字符串的长度
        int n = num1.length(), m = num2.length();
        // 创建两个数组，用于存储字符串数字的整数形式
        int[] A = new int[n], B = new int[m];
        // 将字符串数字反向存储到数组A和B中，以便于后续的计算
        for (int i = n - 1; i >= 0; i--) A[n - 1 - i] = num1.charAt(i) - '0';
        for (int i = m - 1; i >= 0; i--) B[m - 1 - i] = num2.charAt(i) - '0';

        // 创建一个足够大的数组C，用于存储乘积的结果
        int[] C = new int[n + m];
        // 使用两层循环计算乘积，将结果累加到数组C中
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                C[i + j] += A[i] * B[j];
        // 初始化进位变量t
        int t = 0;
        // 处理进位，确保每个位置的数字正确
        for (int i = 0; i < C.length; i++) {
            t += C[i];
            C[i] = t % 10;
            t /= 10;
        }
        // 从数组C的末尾开始，找到第一个非零数字的位置k
        int k = C.length - 1;
        while (k > 0 && C[k] == 0) k--;   // 去除前导0
        // 使用StringBuilder构建最终的乘积字符串
        StringBuilder sb = new StringBuilder();
        // 从位置k开始，将数组C中的数字转换为字符串，并添加到StringBuilder中
        while (k >= 0) sb.append((char)(C[k--] + '0'));
        // 返回最终的乘积字符串
        return sb.toString();
    }

    /**
     * 主函数，用于测试multiply方法
     */
    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        // 测试multiply方法，打印两个字符串数字的乘积
        System.out.println(multiply.multiply("123", "456"));
    }
}
