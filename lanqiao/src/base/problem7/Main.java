package base.problem7;

/**
 * Created by fengyuwusong on 2018/1/29 21:20.
 * 特殊的数字
 * 问题描述
 * 153是一个非常特殊的数，它等于它的每位数字的立方和，即153=1*1*1+5*5*5+3*3*3。编程求所有满足这种条件的三位十进制数。
 * 输出格式
 * 按从小到大的顺序输出满足条件的三位十进制数，每个数占一行。
 */
public class Main {
    public static void main(String[] args) {
        int x, y, z;
        for (int i = 100; i < 1000; i++) {
            x = i / 100;
            y = i % 100 / 10;
            z = i % 100 % 10;
            if (x * x * x + y * y * y + z * z * z == i) {
                System.out.println(i);
            }
        }
    }
}
