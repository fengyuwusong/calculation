package base.problem12;

import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/1/31 21:48.
 * 基础练习 十六进制转八进制
 * 问题描述
 * 给定n个十六进制正整数，输出它们对应的八进制数。
 * <p>
 * 输入格式
 * 输入的第一行为一个正整数n （1<=n<=10）。
 * 接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。
 * <p>
 * 输出格式
 * 输出n行，每行为输入对应的八进制正整数。
 * <p>
 * 【注意】
 * 输入的十六进制数不会有前导0，比如012A。
 * 输出的八进制数也不能有前导0。
 * <p>
 * 样例输入
 * 2
 * 39
 * 123ABC
 * <p>
 * 样例输出
 * 71
 * 4435274
 * <p>
 * 【提示】
 * 先将十六进制数转换成某进制数，再由某进制数转换成八进制。
 * <p>
 * 思路：
 * 由于16进制转2进制每一位对应4位，2进制转8进制1位对应3位，
 * 故可以通过这种关系先转为16再转8.
 * 陷阱：
 * 1.不可以用int、long，因为数据规模很大（每个十六进制数长度不超过100000）
 * 2.16进制转2进制后的位数可能不能被3整除，需要补0，恰好能够for循环完毕
 * 3.使用switch，不要使用位运算，否则会运行超时  位运算解法看Main2
 * 4.使用StringBuilder不要用String，由于字符串不同在做插入工作
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        scanner.nextLine();
        char[] s;
        StringBuilder[] res = new StringBuilder[i];
        for (int j = 0; j < i; j++) {
            s = scanner.nextLine().toCharArray();
            res[j] = twoToOtc(hexToTow(s));
        }
        scanner.close();
        for (int j = 0; j < i; j++) {
            System.out.println(res[j]);
        }
    }

    private static StringBuilder hexToTow(char[] hex) {
        StringBuilder res = new StringBuilder(hex.length * 4);
        int j;
        for (int i = 0; i < hex.length; i++) {
            j = i * 4;
            switch (hex[i]) {
                case '0':
                    res.append("0000");
                    break;
                case '1':
                    res.append("0001");
                    break;
                case '2':
                    res.append("0010");
                    break;
                case '3':
                    res.append("0011");
                    break;
                case '4':
                    res.append("0100");
                    break;
                case '5':
                    res.append("0101");
                    break;
                case '6':
                    res.append("0110");
                    break;
                case '7':
                    res.append("0111");
                    break;
                case '8':
                    res.append("1000");
                    break;
                case '9':
                    res.append("1001");
                    break;
                case 'A':
                    res.append("1010");
                    break;
                case 'B':
                    res.append("1011");
                    break;
                case 'C':
                    res.append("1100");
                    break;
                case 'D':
                    res.append("1101");
                    break;
                case 'E':
                    res.append("1110");
                    break;
                case 'F':
                    res.append("1111");
                    break;
            }
        }
        return res;
    }

    private static StringBuilder twoToOtc(StringBuilder two) {
//        判断是否为3的倍数 如果不是补全0
        int len = two.length();
        if (len % 3 == 1)
            two.insert(0, "00");
        else if (len % 3 == 2)
            two.insert(0, "0");
//        去前面无意义的0
        int i;
        if (two.substring(0, 3).equals("000"))
            i = 3;
        else
            i = 0;
        StringBuilder otc = new StringBuilder();
        for (; i <= two.length() - 2; i += 3) {
            switch (two.substring(i, i + 3)) {
                case "000":
                    otc.append("0");
                    break;
                case "001":
                    otc.append("1");
                    break;
                case "010":
                    otc.append("2");
                    break;
                case "011":
                    otc.append("3");
                    break;
                case "100":
                    otc.append("4");
                    break;
                case "101":
                    otc.append("5");
                    break;
                case "110":
                    otc.append("6");
                    break;
                case "111":
                    otc.append("7");
                    break;
            }
        }
        return otc;
    }
}