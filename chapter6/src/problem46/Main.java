package problem46;

/**
 * Created by fengyuwusong on 2018/3/3 17:02.
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 思路：1+...+n  一般两种方法，循环、递归,循环需要使用for，递归需要使用if，故都不能使用
 * 解法1：利用与短路运算替代if
 * 解法2：用异常代替if退出 (将n作为分母)
 */
public class Main {
    //    解法1
    public int Sum_Solution(int n) {
        int sum = n;
//        利用短路
        boolean flag = (sum > 0) && ((sum += Sum_Solution(--n)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.Sum_Solution(3));
    }
}