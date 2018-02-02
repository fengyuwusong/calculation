package algo.problem1;

import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/2/2 22:40.
 * 问题描述
 * 给定一个序列，每次询问序列中第l个数到第r个数中第K大的数是哪个。
 * <p>
 * 输入格式
 * 第一行包含一个数n，表示序列长度。
 * <p>
 * 第二行包含n个正整数，表示给定的序列。
 * <p>
 * 第三个包含一个正整数m，表示询问个数。
 * <p>
 * 接下来m行，每行三个数l,r,K，表示询问序列从左往右第l个数到第r个数中，从大往小第K大的数是哪个。序列元素从1开始标号。
 * <p>
 * 输出格式
 * 总共输出m行，每行一个数，表示询问的答案。
 * 样例输入
 * 5
 * 1 2 3 4 5
 * 2
 * 1 5 2
 * 2 3 2
 * 样例输出
 * 4
 * 2
 * 数据规模与约定
 * 对于30%的数据，n,m<=100；
 * <p>
 * 对于100%的数据，n,m<=1000；
 * <p>
 * 保证k<=(r-l+1)，序列中的数<=106。
 */
public class Main {
    //    冒泡排序 时间复杂度O(nlogn)
    private static int bubbling(int[] ints, int start, int end, int big) {
        int temp;
        for (int i = start - 1; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (ints[i] > ints[j]) {
                    temp = ints[j];
                    ints[j] = ints[i];
                    ints[i] = temp;
                }
            }
        }
        return ints[end - big];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] ints = new int[num];
        for (int i = 0; i < num; i++) {
            ints[i] = scanner.nextInt();
        }
        int num2 = scanner.nextInt();
        int start, end, big;
        int[] ints2 = new int[num2];
        for (int i = 0; i < num2; i++) {
            start = scanner.nextInt();
            end = scanner.nextInt();
            big = scanner.nextInt();
//            这里使用复制对象，因为数组是对象，方法中改变值则main方法里也对应改变
            ints2[i] = bubbling(ints.clone(), start, end, big);
        }
        for (int i = 0; i < num2; i++) {
            System.out.println(ints2[i]);
        }

    }
}
