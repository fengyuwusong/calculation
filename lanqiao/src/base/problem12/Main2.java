package base.problem12;

import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/1/31 21:48.
 */
public class Main2 {
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
            if (res[j].charAt(0) == '0')
                System.out.println(res[j].substring(1));
            else
                System.out.println(res[j]);
        }
    }

    private static int[] hexToTow(char[] hex) {
        int[] res = new int[hex.length * 4];
        int j;
        int temp;
        int flag;
        for (int i = 0; i < hex.length; i++) {
//            这样写虽然简短，但是运行时间过长，改变策略
            j = i * 4;
            flag = 8;
            if (hex[i] <= '9') {
                temp = hex[i] - '0';
            } else {
                temp = hex[i] + 10 - 'A';
            }
            while (flag != 0) {
                res[j] = (temp & flag) != 0 ? 1 : 0;
                flag = flag >> 1;
                j++;
            }
        }
        return res;
    }

    private static StringBuilder twoToOtc(int[] two) {
        int sum, j;
        StringBuilder otc = new StringBuilder();
        for (int i = two.length - 1; i >= 0; ) {
//            由于运算时间不够，改用switch
            sum = 0;
            j = 0;
            while (j < 3 && i >= 0) {
                if (two[i] == 1) {
                    sum += Math.pow(2, j);
                }
                i--;
                j++;
            }
            otc = otc.insert(0, sum);
        }
        return otc;
    }
}