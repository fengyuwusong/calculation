package begin.problem3;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/1/28 16:59.
 * 	圆的面积
 * 问题描述
 * 给定圆的半径r，求圆的面积。
 * 输入格式
 * 输入包含一个整数r，表示圆的半径。
 * 输出格式
 * 输出一行，包含一个实数，四舍五入保留小数点后7位，表示圆的面积。
 * 说明：在本题中，输入是一个整数，但是输出是一个实数。
 * <p>
 * 对于实数输出的问题，请一定看清楚实数输出的要求，比如本题中要求保留小数点后7位，则你的程序必须严格的输出7位小数，输出过多或者过少的小数位数都是不行的，都会被认为错误。
 * <p>
 * 实数输出的问题如果没有特别说明，舍入都是按四舍五入进行。
 * <p>
 * 样例输入
 * 4
 * 样例输出
 * 50.2654825
 * 数据规模与约定
 * 1 <= r <= 10000。
 * 提示
 * 本题对精度要求较高，请注意π的值应该取较精确的值。你可以使用常量来表示π，比如PI=3.14159265358979323，也可以使用数学公式来求π，比如PI=atan(1.0)*4。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        DecimalFormat df = new DecimalFormat("###.0000000");
        System.out.println(df.format(Math.PI * i * i));
    }
}
