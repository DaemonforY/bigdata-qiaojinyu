package com.example.day03;

public class GenericMethodTest
{
    // 泛型方法 printArray
    /*
    * 一个排序方法，能够对整型数组、字符串数组甚至其他任何类型的数组进行排序
    *java 中泛型标记符：
    * E - Element (在集合中使用，因为集合中存放的是元素)
    * T - Type（Java 类）
    * K - Key（键）
    * V - Value（值）
    *  ？ - 表示不确定的 java 类型
    * */
    public static < E > void printArray( E[] inputArray )
    {
        // 输出数组元素
        for ( E element : inputArray ){
            System.out.printf( "%s ", element );
        }
        System.out.println();
    }

        // 比较三个值并返回最大值
        public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
            T max = x; // 假设x是初始最大值
            if (y.compareTo(max) > 0) {
                max = y; //y 更大
            }
            if (z.compareTo(max) > 0) {
                max = z; // 现在 z 更大
            }
            return max; // 返回最大对象
        }
    public static void main( String args[] )
    {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
        System.out.print( "整型数组元素为:" );
        printArray( intArray  ); // 传递一个整型数组
        System.out.print( "\n双精度型数组元素为:" );
        printArray( doubleArray ); // 传递一个双精度型数组
        System.out.print( "\n字符型数组元素为:" );
        printArray( charArray ); // 传递一个字符型数组
        System.out.println("=========================");
        System.out.printf( "%d, %d 和 %d 中最大的数为 %d\n\n",
                3, 4, 5, maximum( 3, 4, 5 ) );
        System.out.printf( "%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n",
                6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );
        System.out.printf( "%s, %s 和 %s 中最大的数为 %s\n","pear",
                "apple", "orange", maximum( "pear", "apple", "orange" ) );
    }

}