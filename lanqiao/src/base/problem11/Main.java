package base.problem11;

import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/1/29 23:27.
 * 问题描述
 * 从键盘输入一个不超过8位的正的十六进制数字符串，将它转换为正的十进制数后输出。
 * 注：十六进制数中的10~15分别用大写的英文字母A、B、C、D、E、F表示。
 * 样例输入
 * FFFF
 * 样例输出
 * 65535
 * 陷阱:也是出在数据范围上，不超过8位的十六进制数，所以计算总和的sum应该声明为long型，而不是int型，否则会出错。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] target = scanner.nextLine().toCharArray();
        long sum = 0;
        for (int i = 0; i < target.length; i++) {
            if (target[i] <= '9') {
//                两种方法
//                1.使用内置方法
//                sum+=(Character.getNumericValue(target[i])*Math.pow(16,target.length-1-i));
//                2.减去0
                sum += (target[i] - '0') * Math.pow(16, target.length - 1 - i);
            } else {
                sum += (target[i] + 10 - 'A') * Math.pow(16, target.length - 1 - i);
            }
        }
        System.out.println(sum);
    }
}
