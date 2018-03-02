package problem43;

/**
 * Created by fengyuwusong on 2018/3/2 23:20.
 * n个骰子的点数
 * 题目描述：
 * 把n个骰子扔在地上，所有的骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 例如 3个骰子 出现3的概率为 和为3的情况只有1种 3个骰子的全排列有6³ 结果1/216
 * <p>
 * 思路：根据题目描述可知，我们必须求出n个骰子下和为s的全排列个数。
 * 解法1：利用递归。
 * 可以将骰子分为两堆，一堆只有一个，剩余的是 n-1个 则我们可以得到剩余的值为 s-该骰子的所有可能的值
 * 循环上个步骤。
 * 例如3个骰子求和为4.
 * 1. 骰子1 值 1 剩余值3 递归骰子2
 * 2. 骰子2 值 1 剩余值2 递归骰子3
 * 3. 骰子3 值只能为2 得到一种排列 返回上级
 * 4. 骰子2 值 2 剩余值1 递归骰子3
 * 5. 骰子3 值只能为1 得到一种排列 返回上级
 * 6. 骰子2 值 3 剩余值0 不成立 返回上级
 * 7. 。。。
 */
public class Main {

    public int possible(int n, int s) {
//        不成立条件
        if (n < 0 || s < 0 || (n == 1 && s > 6))
            return 0;
//        成立条件
        if (n == 0 && s == 0)
            return 1;
        int p1=possible(n - 1, s - 1);
        int p2=possible(n - 1, s - 2);
        int p3=possible(n - 1, s - 3);
        int p4=possible(n - 1, s - 4);
        int p5=possible(n - 1, s - 5);
        int p6=possible(n - 1, s - 6);
        return p1+p2+p3+p4+p5+p6;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.possible(2, 4));
    }
}
