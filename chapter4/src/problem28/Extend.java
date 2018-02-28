package problem28;

import java.util.Stack;

/**
 * Created by fengyuwusong on 2018/2/11 21:46.
 * 求输入字符串的组合
 * 如ABC  输出 A AB AC ABC B BC C
 */
public class Extend {
    public void group(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] cs = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        group(cs, 0, stack);
    }

    private void group(char[] cs, int start, Stack<Character> stack) {
        if (start == cs.length) {
            if (stack.size() != 0) {
                System.out.println(stack);
            }
            return;
        }
//        不包含第一个字符串
        group(cs, start + 1,  stack);
//        包含第一个字符串
        stack.push(cs[start]);
        group(cs, start + 1, stack);
        stack.pop();
    }

    public static void main(String[] args) {
        Extend extend = new Extend();
        extend.group("ABC");
    }
}
