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
 * 缺点 递归会造成很多计算重复
 * <p>
 * 解法2：用两个数组来存储骰子点数的每一个总数出现的次数。例如：
 * 在一次循环中，第一个数组中的第n个数字表示骰子和为n出现的次数。
 * 在下一次循环中，我们加上一个新的骰子，此时和为n的骰子出现的次数应该等于上一次循环中骰子点数和n-1、n-2、n-3、n-4、n-5、n-6的次数的总和
 * 所以我们吧另一个数组的第n个数字设为前一个数组对应的第n-1、n-2、n-3、n-4、n-5、n-6之和。
 * 例如3个骰子
 * 1. 先初始化两个数组分别记录这次和上次的数据，长度为3个骰子能投的范围(3*6+1=19,0不做存储)
 * 2. 由于第一个骰子的数据为1-6各一次，故数组1赋值为{0,1,1,1,1,1,1,0...} 对应1-6位为1
 * 3. 投掷第二个骰子，最小值为2，故先将第二个数组小于2的索引置为0.然后从第二个骰子的范围开始遍历2-12
 * 4. 遍历第二个骰子出现的6个数，将范围内的值-第一次数组索引，即可以得到范围内每个数出现的次数。
 * 5. 第三个骰子同理。。。
 * 该思想为递归的反向，自底向上的动态规划方法。
 */
public class Main {

    //    解法1
    private int max = 6;

    public void test1(int n) {
        for (int i = n; i <= n * 6; i++) {
            System.out.println(i + "出现的概率：" + possible(n, i) + "/" + Math.pow(max, n));
        }
    }

    //    递归所有排列可能
    public int possible(int n, int s) {
//        不成立条件
        if (n < 0 || s < 0 || (n == 1 && s > 6) || (n == 0 && s > 0))
            return 0;
//        成立条件
        if (n == 0 && s == 0)
            return 1;
        int sum = 0;
        for (int i = 1; i <= max; i++) {
            sum += possible(n - 1, s - i);
        }
        return sum;
    }


    //解法2 基于循环求骰子点数
    public void test2(int number) {
        if (number < 1) {
            return;
        }
        int[][] pProbabilities = new int[2][max * number + 1];
        for (int i = 0; i < max; i++) {//初始化数组
            pProbabilities[0][i] = 0;
            pProbabilities[1][i] = 0;
        }
        int flag = 0;
        for (int i = 1; i <= max; i++) {//当第一次抛掷骰子时，有6种可能，每种可能出现一次
            pProbabilities[flag][i] = 1;
        }
        //从第二次开始掷骰子，假设第一个数组中的第n个数字表示骰子和为n出现的次数，
        //在下一循环中，我们加上一个新骰子，此时和为n的骰子出现次数应该等于上一次循环中骰子点数和为n-1,n-2,n-3,n-4,n-5，
        //n-6的次数总和，所以我们把另一个数组的第n个数字设为前一个数组对应的n-1,n-2,n-3,n-4,n-5，n-6之和
        for (int k = 2; k <= number; k++) {
            for (int i = 0; i < k; i++) {//第k次掷骰子，和最小为k，小于k的情况是不可能发生的！所以另不可能发生的次数设置为0！
                pProbabilities[1 - flag][i] = 0;
            }
            for (int i = k; i <= max * k; i++) {//第k次掷骰子，和最小为k，最大为max*k
                pProbabilities[1 - flag][i] = 0;//初始化，因为这个数组要重复使用，上一次的值要清0
                for (int j = 1; j <= i && j <= max; j++) { //第k个骰子分别出现[1，max]的情况 当j>i时 即最大值超过骰子数*6或j>max时退出循环
                    pProbabilities[1 - flag][i] += pProbabilities[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        double total = Math.pow(max, number);
        for (int i = number; i <= max * number; i++) {
            double ratio = pProbabilities[flag][i] / total;
//            System.out.println("sum: " + i + " ratio: " + ratio);
            System.out.println("sum: " + i + " ratio: " + pProbabilities[flag][i] + "/" + total);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
//        main.test1(2);
        main.test2(2);
    }
}
