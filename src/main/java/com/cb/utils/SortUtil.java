package com.cb.utils;

/**
 * Created by mt on 2018/8/21.
 */
public class SortUtil {
    /*
    * 冒泡排序
     */
    public static int[] BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {//外层循环控制排序趟数
            for (int j = 0; j < arr.length - 1 - i; j++) {//内层循环控制每一趟排序多少次
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 求解斐波拉契数
     * 使用动态规划，避免重复求解子问题（f(10) 需要计算 f(9) 和 f(8)，计算 f(9) 需要计算 f(8) 和 f(7)，可以看到 f(8) 被重复计算了。）
     * @param n
     */
    public static int Fibonacci1(int n){
        if (n<=1){
            return n;
        }
        int[] fib = new int[n-1];
        fib[0] = 0;
        fib[1] =1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i-1]+fib[i-2];
        }
        return fib[n];
    }
    //第 i 项只与第 i-1 和第 i-2 项有关，因此只需要存储前两项的值就能求解第 i 项，从而将空间复杂度由 O(N) 降低为 O(1)。
    public static int Fibonacci2(int n){
        if (n <= 1)
            return n;
        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for (int i = 2; i <=n; i++) {
            fib = pre1+pre2;
            pre2 = pre1;
            pre1 = fib;
        }
        return  fib;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 9, 1};
        System.out.println("排序前数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        BubbleSort(arr);
    }


}
