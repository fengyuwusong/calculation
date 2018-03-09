package question7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/3/5 11:41.
 * L1-007. 念数字
 * 输入一个整数，输出每个数字对应的拼音。当整数为负数时，先输出“fu”字。十个数字对应的拼音如下：
 * 0: ling
 * 1: yi
 * 2: er
 * 3: san
 * 4: si
 * 5: wu
 * 6: liu
 * 7: qi
 * 8: ba
 * 9: jiu
 * 输入格式：
 * 输入在一行中给出一个整数，如： 1234 。
 * 提示：整数包括负数、零和正数。
 * 输出格式：
 * 在一行中输出这个整数对应的拼音，每个数字的拼音之间用空格分开，行末没有最后的空格。如 yi er san si。
 * 输入样例：
 * -600
 * 输出样例：
 * fu liu ling ling
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if (s.length()==0)
            return;
        char[] chars = s.toCharArray();
        BigInteger integer;
        if (chars[0] == '-') {
            System.out.print("fu ");
            integer = new BigInteger(s.substring(1));
        } else if (chars[0] == '+') {
            System.out.print("zheng ");
            integer = new BigInteger(s.substring(1));
        } else
            integer = new BigInteger(s);
        List<String> list = new ArrayList<>();
        while (!integer.equals(BigInteger.ZERO)) {
            switch (integer.mod(BigInteger.TEN).intValue()) {
                case 0:
                    list.add(0, "ling");
                    break;
                case 1:
                    list.add(0, "yi");
                    break;
                case 2:
                    list.add(0, "er");
                    break;
                case 3:
                    list.add(0, "san");
                    break;
                case 4:
                    list.add(0, "si");
                    break;
                case 5:
                    list.add(0, "wu");
                    break;
                case 6:
                    list.add(0, "liu");
                    break;
                case 7:
                    list.add(0, "qi");
                    break;
                case 8:
                    list.add(0, "ba");
                    break;
                case 9:
                    list.add(0, "jiu");
                    break;
            }
            integer = integer.divide(BigInteger.TEN);
        }
        if (list.size()==0){
            System.out.print("ling");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i) + " ");
            }
        }
    }
}
