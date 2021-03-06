package base.problem8;

/**
 * Created by fengyuwusong on 2018/1/29 21:52.
 * 	回文数
 * 问题描述
 * 1221是一个非常特殊的数，它从左边读和从右边读是一样的，编程求所有这样的四位十进制数。
 * 输出格式
 * 按从小到大的顺序输出满足条件的四位十进制数。
 */
public class Main {
    public static void main(String[] args) {
        int x, y, z, k;
        for (int i = 1000; i <= 9999; i++) {
            x = i / 1000;
            y = i / 100 % 10;
            z = i / 10 % 10;
            k = i % 10;
            if (k == x && z == y) {
                System.out.println(i);
            }
        }
    }
}
