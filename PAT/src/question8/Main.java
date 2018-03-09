package question8;

import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/3/5 22:41.
 * L1-008. 求整数段和
 * 给定两个整数A和B，输出从A到B的所有整数以及这些数的和。
 * 输入格式：
 * 输入在一行中给出2个整数A和B，其中-100<=A<=B<=100，其间以空格分隔。
 * 输出格式：
 * 首先顺序输出从A到B的所有整数，每5个数字占一行，每个数字占5个字符宽度，向右对齐。最后在一行中输出全部数字的和。
 * 输入样例：
 * -3 8
 * 输出样例：
 * -3   -2   -1    0    1
 * 2    3    4    5    6
 * 7    8
 * Sum = 30
 *
 * 陷阱：注意1 5的时候最后一行为满的，则不能回车
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int count = 0, sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
            count++;
            if (count == 5 && i + 1 <= end) {
                System.out.printf("%5d\n", i);
                count = 0;
            } else
                System.out.printf("%5d", i);
        }
        System.out.println();
        System.out.println("Sum = " + sum);
    }
}
