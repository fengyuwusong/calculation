package problem42;

/**
 * Created by fengyuwusong on 2018/3/2 21:51.
 * 左旋转字符串
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * 思路：
 * 通过观察我们可以发现abcXYZdef左移3位实际上是
 * 1. 将字符串分为abc 和 XYZdef两部分
 * 2. 分别翻转这两部分得到 cba 和fedZYX
 * 3. 合并两部分得到 cbafedZYX
 * 4. 翻转整个字符串得到 XYZdefabc
 * 陷阱：注意判断界定条件
 */
public class Main {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || n > str.length())
            return null;
        char[] chars=str.toCharArray();
        reverse(chars,0,n-1);
        reverse(chars,n,chars.length-1);
        reverse(chars,0,chars.length-1);
        return String.valueOf(chars);
    }

    //    翻转函数
    public void reverse(char[] chars, int start, int end) {
        if (chars == null || chars.length == 0 || chars.length-1 < end || start > end)
            return;
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.reverse(new char[]{'1', '2', '3'}, 0, 2);
        System.out.println(main.LeftRotateString("123456", 2));
    }
}
