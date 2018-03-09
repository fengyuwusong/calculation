package question2;

import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/3/4 20:41.
 * L1-002. 打印沙漏
 * 本题要求你写个程序把给定的符号打印成沙漏的形状。例如给定17个“*”，要求按下列格式打印
 * *****
 *  ***
 *   *
 *  ***
 * *****
 * 所谓“沙漏形状”，是指每行输出奇数个符号；各行符号中心对齐；相邻两行符号数差2；
 * 符号数先从大到小顺序递减到1，再从小到大顺序递增；首尾符号数相等。
 * 给定任意N个符号，不一定能正好组成一个沙漏。要求打印出的沙漏能用掉尽可能多的符号。
 * 输入格式：
 * 输入在一行给出1个正整数N（<=1000）和一个符号，中间以空格分隔。
 * 输出格式：
 * 首先打印出由给定符号组成的最大的沙漏形状，最后在一行中输出剩下没用掉的符号数。
 * 输入样例：
 * 19 *
 * 输出样例：
 * *****
 *  ***
 *   *
 *  ***
 * *****
 * 2
 *
 * 思路：
 * 由于沙漏形状是由奇数个数组成，分别是1+(3+..+n)*2,那我们可以通过输入的数字倒置获得最高层个数
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        char c=scanner.next().toCharArray()[0];
//        考虑特殊情况 小于0
        if (num<=0){
            System.out.println(c);
            System.out.println(num-1);
            return;
        }
        int top=3;
        int temp=num-1;
        int l=0;
        while (temp>top*2){
            l=temp-top*2;
            temp-=top*2;
            top+=2;
        }
        top-=2;
        temp=top;
        int space=0;
        while (top>1){
            for (int i = 0; i < space; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < top; i++) {
                System.out.print(c);
            }
            System.out.println();
            top-=2;
            space++;
        }
        for (int i = 0; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(c);
        while (top<temp){
            space--;
            top+=2;
            for (int i = 0; i < space; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < top; i++) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println(l);
    }
}
