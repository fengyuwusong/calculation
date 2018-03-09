package problem49;

/**
 * Created by fengyuwusong on 2018/3/3 21:35.
 * 把字符串转换成整数
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * +2147483647
 * 1a33
 * 输出
 * 2147483647
 * 0
 * <p>
 * 思路：
 * 注意处理正负号，获得位数，将对应的位的值乘以对应的10的倍数相加
 */
public class Main {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        char[] chars = str.toCharArray();
        int start = 0;
        boolean isF = false;
        if (chars[0] == '+') {
            start++;
        } else if (chars[0] == '-') {
            isF = true;
            start++;
        }
        int r = (int) Math.pow(10, chars.length - start - 1);
        int sum = 0;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9')
                return 0;
            sum += r * (chars[i] - '0');
            r/=10;
        }
        return isF ? -1 * sum : sum;
    }

    public static void main(String[] args) {
        Main main=new Main();
        System.out.println(main.StrToInt("+123"));
        System.out.println(main.StrToInt("-123"));
        System.out.println(main.StrToInt(" 123"));
    }
}
