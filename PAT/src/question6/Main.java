package question6;

import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/3/4 23:27.
 * <p>
 * 一个正整数N的因子中可能存在若干连续的数字。例如630可以分解为3*5*6*7，其中5、6、7就是3个连续的数字。
 * 给定任一正整数N，要求编写程序求出最长连续因子的个数，并输出最小的连续因子序列。
 * 输入格式：
 * 输入在一行中给出一个正整数N（1<N<2³¹）。
 * 输出格式：
 * 首先在第1行输出最长连续因子的个数；然后在第2行中按“因子1*因子2*……*因子k”的格式输出最小的连续因子序列，其中因子按递增顺序输出，1不算在内。
 * 输入样例：
 * 630
 * 输出样例：
 * 3
 * 5*6*7
 * <p>
 * 思路：
 * 解法1：使用暴力破解的方法，可以发现12!>2³¹次方，那么连续因子最多只有12个，那么我们可以按照因子的个数从长到短 12-1开始遍历，
 * 遍历的数值则从2到该数的开方遍历，如果有两个连续的数可以求余=0，则说明具有连续因子
 * 特殊情况：当n时素数的时候，是没有解的，则返回她本身.
 * 解法2：转Main2
 */
public class Main {
    //    最长序列长度
    public static final int max = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        int lim = (int) Math.sqrt(num);
//        是否具有因子
        boolean flag = false;
//        因子序列的开头
        int startOfSequence = 2;
//        因子长度
        int len = 0;
//        因子由长到短遍历
        for (len = max; len > 0; len--) {
//            值由小到大遍历
            for (startOfSequence = 2; startOfSequence < lim; startOfSequence++) {
//                保存遍历的阶层
                long ans = 1;
//                startOfSequence+len-1即最长序列的最后一个数
                for (int k = startOfSequence; k <= startOfSequence + len - 1; k++) {
                    ans *= k;
                }
                if (num % ans == 0) {
                    flag = true;
                    break;
                }
            }
//            已经具有最小的连续因子
            if (flag) {
                break;
            }
        }
        if (flag) {
            System.out.println(len);
            for (int i = startOfSequence; i <= startOfSequence + len - 1; i++) {
                System.out.print(i == startOfSequence ? i : "*" + i);
            }
        } else {
            System.out.println(1);
            System.out.println(num);
        }
    }
}
