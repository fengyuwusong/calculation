package lanqiao.base.problem4;

import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/1/28 22:16.
 * 问题描述
 * 给出n个数，找出这n个数的最大值，最小值，和。
 * <p>
 * 输入格式
 * 第一行为整数n，表示数的个数。
 * <p>
 * 第二行有n个数，为给定的n个数，每个数的绝对值都小于10000。
 * <p>
 * 输出格式
 * 输出三行，每行一个整数。第一行表示这些数中的最大值，第二行表示这些数中的最小值，第三行表示这些数的和。
 * 样例输入
 * 5
 * 1 3 -2 4 5
 * 样例输出
 * 5
 * -2
 * 11
 * 数据规模与约定
 * 1 <= n <= 10000。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] ints = new int[num];
        int max = -10000, min = 10000, sum = 0;
        for (int i = 0; i < num; i++) {
            ints[i] = scanner.nextInt();
            if (i == 1) {
                max = Math.max(ints[0], ints[1]);
                min = Math.min(ints[0], ints[1]);
            } else if (i > 1) {
                max = Math.max(max, ints[i]);
                min = Math.min(min, ints[i]);
            }
            sum += ints[i];
        }
        if (num == 1) {
            max = min = sum = ints[0];
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(sum);

    }
}
