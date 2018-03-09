package question9;

import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/3/6 10:03.
 * L1-009. N个数求和
 * 本题的要求很简单，就是求N个数字的和。麻烦的是，这些数字是以有理数“分子/分母”的形式给出的，你输出的和也必须是有理数的形式。
 * 输入格式：
 * 输入第一行给出一个正整数N（<=100）。随后一行按格式“a1/b1 a2/b2 ...”给出N个有理数。题目保证所有分子和分母都在长整型范围内。另外，负数的符号一定出现在分子前面。
 * 输出格式：
 * 输出上述数字和的最简形式 —— 即将结果写成“整数部分 分数部分”，其中分数部分写成“分子/分母”，要求分子小于分母，且它们没有公因子。如果结果的整数部分为0，则只输出分数部分。
 * 输入样例1：
 * 5
 * 2/5 4/15 1/30 -2/60 8/3
 * 输出样例1：
 * 3 1/3
 * 输入样例2：
 * 2
 * 4/3 2/3
 * 输出样例2：
 * 2
 * 输入样例3：
 * 3
 * 1/3 -1/6 1/8
 * 输出样例3：
 * 7/24
 * 思路：先将输入的字符串按/分割，然后计算分子、分母大小，然后看分子是否大于分母计算整数部分、然后再遍历分子看是否能规约
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num==0)
            return;
        int x = 0, y = 0, z = 0;
        for (int i = 0; i < num; i++) {
            String[] s = scanner.next().split("/");
            int t = Integer.valueOf(s[0]);
            int l = Integer.valueOf(s[1]);
            y = i == 0 ? t : y * l + t * z;
            z = i == 0 ? l : z * l;
        }
        while (y >= z) {
            x++;
            y -= z;
        }
        for (int i = 2; i <= y; i++) {
            if (y % i == 0 && z % i == 0) {
                y /= i;
                z /= i;
                i--;
            }
        }
        if (x == 0) {
            System.out.println(y + "/" + z);
        } else {
            if (y == 0) {
                System.out.println(x);
            } else {
                System.out.println(x + " " + y + "/" + z);
            }
        }
    }
}
