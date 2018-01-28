package base.problem6;

import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/1/28 22:38.
 * 问题描述
 * 杨辉三角形又称Pascal三角形，它的第i+1行是(a+b)i的展开式的系数。
 * <p>
 * <p>
 * 它的一个重要性质是：三角形中的每个数字等于它两肩上的数字相加。
 * <p>
 * <p>
 * 下面给出了杨辉三角形的前4行：
 * <p>
 * <p>
 * 1
 * <p>
 * <p>
 * 1 1
 * <p>
 * <p>
 * 1 2 1
 * <p>
 * <p>
 * 1 3 3 1
 * <p>
 * <p>
 * 给出n，输出它的前n行。
 * <p>
 * 输入格式
 * 输入包含一个数n。
 * <p>
 * 输出格式
 * 输出杨辉三角形的前n行。每一行从这一行的第一个数开始依次输出，中间使用一个空格分隔。请不要在前面输出多余的空格。
 * 样例输入
 * 4
 * 样例输出
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 数据规模与约定
 * 1 <= n <= 34。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int[][] ints = new int[i][i];
        for (int j = 0; j < i; j++) {
            for (int k = 0; k <= j; k++) {
                if (k == 0 || j == 0) {
                    ints[j][k] = 1;
                    System.out.print(ints[j][k]);
                } else if (k == j) {
                    ints[j][k] = 1;
                    System.out.print(" " + ints[j][k]);
                } else {
                    ints[j][k] = ints[j - 1][k - 1] + ints[j - 1][k];
                    System.out.print(" " + ints[j][k]);
                }
            }
            System.out.println();
        }
    }
}
