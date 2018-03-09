package problem54;

/**
 * Created by fengyuwusong on 2018/3/4 11:57.
 * 表示数字的字符串
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * <p>
 * 思路：
 * 先判断一个数是否为正负数，当遇到符号E(e)的时候在进行二次判断是否为正负数,
 * 并且判断第一个数是否大于10,如果大于，则判断是否有小数点，如果没有则返回false
 */
public class Main {
    public boolean isNumeric(char[] str) {
        boolean res = true, flag = true;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'E' || str[i] == 'e') {
                res = isNumeric(str, 0, i - 1) && isNumeric(str, i + 1, str.length - 1);
                flag = false;
                break;
            }
        }
        if (flag) {
            return isNumeric(str, 0, str.length - 1);
        }
        return res;
    }

    //    判断一个数是否是正负数
    public boolean isNumeric(char[] str, int start, int end) {
        if (end < start)
            return false;
        if (str[start] == '+' || str[start] == '-')
            start++;
        boolean isFloat = false;
        for (int i = start; i <= end; i++) {
            if (str[i] == '.' && !isFloat) {
                isFloat = true;
            } else if (str[i] > '9' || str[i] < '0') {
                return false;
            }
        }
        if (start == 0 && end != str.length-1 && end > 0)
            return isFloat;
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.isNumeric("100".toCharArray()));
        System.out.println(main.isNumeric("12e+4.3".toCharArray()));
        System.out.println(main.isNumeric("12.1e+4.3".toCharArray()));
        System.out.println(main.isNumeric("5e2".toCharArray()));
    }
}
