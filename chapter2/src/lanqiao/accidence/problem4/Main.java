package lanqiao.accidence.problem4;

import java.util.Scanner;

/**
 * 问题描述
 * Fibonacci数列的递推公式为：Fn=F(n-1)+F(n-2)，其中F1=F2=1。
 * 当n比较大时，Fn也非常大，现在我们想知道，Fn除以10007的余数是多少。
 * 输入格式
 * 输入包含一个整数n。
 * 输出格式
 * 输出一行，包含一个整数，表示Fn除以10007的余数。
 * 说明：在本题中，答案是要求Fn除以10007的余数，因此我们只要能算出这个余数即可，而不需要先计算出Fn的准确值，再将计算的结果除以10007取余数，直接计算余数往往比先算出原数再取余简单。
 * 样例输入
 * 10
 * 样例输出
 * 55
 * 样例输入
 * 22
 * 样例输出
 * 7704
 * 数据规模与约定
 * 1 <= n <= 1,000,000。
 * Created by fengyuwusong on 2018/1/28 0:14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int fib[] = new int[n + 2];
        fib[1] = fib[2] = 1;
        for (int i = 3; i <= n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % 10007;
        }
        System.out.print(fib[n]);
    }
}


/**
 * 下面是迭代实现的<pre name="code" class="java">import java.util.*;
 * public class Main //迭代实现，耗时耗内存更多不及上面的方法，直接%10007后再存入数组中好
 * {
 * public static void main(String args[])
 * {
 * Scanner input = new Scanner(System.in);
 * int n = input.nextInt();
 * System.out.print(fibRemain(n));
 * }
 * public static int fibRemain(int n)
 * {
 * if(n == 0) return 0;
 * if(n == 1) return 1;
 * int re1 = 0;
 * int re2 = 1;
 * int re = 0;
 * for(int i = 2;i <= n;i++)
 * {
 * re = (re1 + re2) % 10007;
 * re1 = re2;
 * re2 = re;
 * }
 * return re;
 * }
 * }
 **/