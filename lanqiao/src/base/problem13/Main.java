package base.problem13;

import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/2/2 22:26.
 * 基础练习 数列排序
 * 问题描述
 * 给定一个长度为n的数列，将这个数列按从小到大的顺序排列。1<=n<=200
 * 输入格式
 * 第一行为一个整数n。
 * 第二行包含n个整数，为待排序的数，每个整数的绝对值小于10000。
 * 输出格式
 * 输出一行，按从小到大的顺序输出排序后的数列。
 * 样例输入
 * 5
 * 8 3 6 4 9
 * 样例输出
 * 3 4 6 8 9
 */
public class Main {
    //    冒泡排序 时间复杂度O(nlogn)
    private static void bubbling(int[] ints) {
        int temp;
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i] > ints[j]) {
                    temp = ints[j];
                    ints[j] = ints[i];
                    ints[i] = temp;
                }
            }
        }
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] ints = new int[num];
        for (int i = 0; i < num; i++) {
            ints[i] = scanner.nextInt();
        }
        bubbling(ints);
    }
}
