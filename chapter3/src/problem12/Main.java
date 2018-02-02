package problem12;

import java.math.BigInteger;

/**
 * Created by fengyuwusong on 2018/1/31 13:45.
 * 题目:打印1到最大的n位数
 * 输入数字n，按顺序打印出1到最大的n位十进制数。比如输入3，则打印1,2,3...999
 * <p>
 * 陷阱
 * 考虑int 或long类型溢出必须使用字符模拟加减操作或使用java包
 * <p>
 * 解法：
 * 1.使用BigInteger等类
 * 2.使用数组进行递归操作   new char[n] char int都行 每一位进行+1打印
 */

public class Main {
    public void PrintToMaxOfNDigits(int n) {
//        边界判断
        if (n < 0) {
            throw new RuntimeException("参数n不能小于0");
        }
        BigInteger bigInteger = BigInteger.ZERO;
        int target = 1;
        while (n != 0) {
            target *= 10;
            n--;
        }
        for (int i = 1; i < target; i++) {
            bigInteger = bigInteger.add(BigInteger.ONE);
            System.out.println(bigInteger);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.PrintToMaxOfNDigits(1);
    }
}
