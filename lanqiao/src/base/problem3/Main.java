package base.problem3;

import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/1/28 21:57.
 * 字母图形
 * 问题描述
 * 利用字母可以组成一些美丽的图形，下面给出了一个例子：
 * <p>
 * ABCDEFG
 * <p>
 * BABCDEF
 * <p>
 * CBABCDE
 * <p>
 * DCBABCD
 * <p>
 * EDCBABC
 * <p>
 * 这是一个5行7列的图形，请找出这个图形的规律，并输出一个n行m列的图形。
 * <p>
 * 输入格式
 * 输入一行，包含两个整数n和m，分别表示你要输出的图形的行数的列数。
 * 输出格式
 * 输出n行，每个m个字符，为你的图形。
 * 样例输入
 * 5 7
 * 样例输出
 * ABCDEFG
 * BABCDEF
 * CBABCDE
 * DCBABCD
 * EDCBABC
 * 数据规模与约定
 * 1 <= n, m <= 26。
 */
public class Main {
    //需要额外添加if判断Z之后返回A
    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int x = scanner.nextInt();
//        int y = scanner.nextInt();
//        char[] chars = new char[y];
//        for (int j = 0; j < y; j++) {
//            chars[j] = (char) ('A' + j);
//        }
//        System.out.println(new String(chars));
//        for (int i = 0; i < x - 1; i++) {
//            for (int j = y - 1; j > 0; j--) {
//                chars[j] = chars[j - 1];
//            }
//            chars[0] += 1;
//            System.out.println(new String(chars));
//        }
//    }
    //更简便的方法
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        char[] chars = new char[y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print((char) ('A' + Math.abs(i - j)));
            }
            System.out.println();
        }
    }
}
