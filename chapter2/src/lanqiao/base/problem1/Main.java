package lanqiao.base.problem1;

import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/1/28 17:45.
 * 问题描述
 * 给定一个年份，判断这一年是不是闰年。
 * <p>
 * 当以下情况之一满足时，这一年是闰年：
 * <p>
 * 1. 年份是4的倍数而不是100的倍数；
 * <p>
 * 2. 年份是400的倍数。
 * <p>
 * 其他的年份都不是闰年。
 * <p>
 * 输入格式
 * 输入包含一个整数y，表示当前的年份。
 * 输出格式
 * 输出一行，如果给定的年份是闰年，则输出yes，否则输出no。
 * 说明：当试题指定你输出一个字符串作为结果（比如本题的yes或者no，你需要严格按照试题中给定的大小写，写错大小写将不得分。
 * <p>
 * 样例输入
 * 2013
 * 样例输出
 * no
 * 样例输入
 * 2016
 * 样例输出
 * yes
 * 数据规模与约定
 * 1990 <= y <= 2050。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if (year % 4 == 0 && year % 100 != 0) {
            System.out.println("yes");
            return;
        }
        if (year % 400 == 0) {
            System.out.println("yes");
            return;
        }
        System.out.println("no");
    }
}
