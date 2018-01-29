package base.problem9;

import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/1/29 22:13.
 * 问题描述
 * ，它从左边读和从右边读是一样的。
 * 输入一个正整数n， 编123321是一个非常特殊的数程求所有这样的五位和六位十进制数，满足各位数字之和等于n 。
 * 输入格式
 * 输入一行，包含一个正整数n。
 * 输出格式
 * 按从小到大的顺序输出满足条件的整数，每个整数占一行。
 * 样例输入
 * 52
 * 样例输出
 * 899998
 * 989989
 * 998899
 * 数据规模和约定
 * 1<=n<=54。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int x, y, z, k, l, n;
        for (int i = 10000; i < 999999; i++) {
            if (i < 100000) {
                x = i / 10000;
                y = i / 1000 % 10;
                l = i / 100 % 10;
                z = i / 10 % 10;
                k = i % 10;
                if (k == x && y == z && 2 * (k + y) + l == target) {
                    System.out.println(i);
                }
            } else {
                n = i / 100000;
                x = i / 10000 % 10;
                y = i / 1000 % 10;
                z = i / 100 % 10;
                k = i / 10 % 10;
                l = i % 10;
                if (n == l && x == k && y == z && 2 * (n + x + y) == target) {
                    System.out.println(i);
                }
            }
        }
    }
}
