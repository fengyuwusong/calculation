package base.problem10;

import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/1/29 22:29.
 * 十进制转十六进制
 * 问题描述
 * 十六进制数是在程序设计时经常要使用到的一种整数的表示方式。
 * 它有0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F共16个符号，分别表示十进制数的0至15。
 * 十六进制的计数方法是满16进1，所以十进制数16在十六进制中是10，而十进制的17在十六进制中是11，
 * 以此类推，十进制的30在十六进制中是1E。
 * 给出一个非负整数，将它表示成十六进制的形式。
 * 输入格式
 * 输入包含一个非负整数a，表示要转换的数。0<=a<=2147483647
 * 输出格式
 * 输出这个整数的16进制表示
 * 样例输入
 * 30
 * 样例输出
 * 1E
 */
public class Main {
    //直接使用内部方法
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int target = scanner.nextInt();
//        System.out.println(Integer.toHexString(target).toUpperCase());
//    }
//    循环取余
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        String s = "";
        int i;
        while (target >= 16) {
            i = target % 16;
            if (i < 10) {
                s = i + s;
            } else {
                s = (char) (i % 10 + 'A') + s;
            }
            target = target / 16;
        }
        if (target < 10) {
            s = target + s;
        } else {
            s = (char) (target % 10 + 'A') + s;
        }
        System.out.println(String.valueOf(s));
    }
}
