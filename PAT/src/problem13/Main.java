package problem13;

import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/3/9 23:01.
 * 对于给定的正整数N，需要你计算 S = 1! + 2! + 3! + ... + N!。
 * 输入格式：
 * 输入在一行中给出一个不超过10的正整数N。
 * 输出格式：
 * 在一行中输出S的值。
 * 输入样例：
 * 3
 * 输出样例：
 * 9
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int sum = 0;
//        存储阶乘
        int temp = 1;
        for (int j = 1; j <= i; j++) {
            temp *= j;
            sum += temp;
        }
        System.out.println(sum);
    }

}
