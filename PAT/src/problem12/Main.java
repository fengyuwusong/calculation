package problem12;

import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/3/9 22:58.
 * L1-012. 计算指数
 * 真的没骗你，这道才是简单题 —— 对任意给定的不超过10的正整数n，要求你输出2n。不难吧？
 * 输入格式：
 * 输入在一行中给出一个不超过10的正整数n。
 * 输出格式：
 * 在一行中按照格式“2^n = 计算结果”输出2n的值。
 * 输入样例：
 * 5
 * 输出样例：
 * 2^5 = 32
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.print(2 + "^" + i + " = " + (2 << i-1));
    }
}
