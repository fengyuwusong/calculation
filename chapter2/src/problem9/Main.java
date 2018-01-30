package problem9;

/**
 * Created by fengyuwusong on 2018/1/30 14:50.
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 * 知识点：菲波那切数列、递归、循环
 * 菲波那切数列：       |-     0              n=0
 * f(n)= |      1              n=1
 * |- f(n-1)+f(n-2)     n>2
 * <p>
 * 递归：
 * 优点： 简洁
 * 缺点：  1.递归由于是函数调用自身，而函数的调用是有时间和空间的消耗的：
 * 每一次函数调用，都需要在内存中分配空间以保存参数、返回地址及临时变量，而且往栈里压入数据和弹出数据都需要时间。
 * 故递归不如循环效率高
 * 2.多数计算重复，带来性能损失
 * 3.调用栈溢出，层级过高的时候会超出栈的容量
 */
public class Main {
    //    常用递归解法1 时间复杂度随n的提高指数增加
//    public int Fibonacci(int n) {
//        if (n == 0)
//            return 0;
//        if (n == 1)
//            return 1;
//        return Fibonacci(n-1) + Fibonacci(n - 2);
//    }
//    解法2 将已经计算过的保存备用
//    解法3 从下至上计算到n 时间复杂度O(n)
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int l = 0, ll = 1, now = 0;
        for (int i = 2; i <= n; i++) {
            now = l + ll;
            l = ll;
            ll = now;
        }
        return now;
    }
//    解法4 将斐波那契数列转换成矩阵的乘方 时间复杂度O(logn)  有兴趣百度

    public static void main(String[] args) {
        Main main = new Main();
        int res = main.Fibonacci(3);
        System.out.println(res);
    }

}
