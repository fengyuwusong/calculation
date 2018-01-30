package problem9;

/**
 * Created by fengyuwusong on 2018/1/30 15:18.
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 知识点：菲波那切数列
 * 假设青蛙跳上n个台阶，那么他有两种跳法
 * 1.跳一格  剩余 n-1格
 * 2.跳两格  剩余 n-2格
 * 则剩下的问题变成解决 n-1 格和n-2格台阶有多少种跳法
 * 当n=2时，则跳法有2种 一格一格的条或两格一起跳
 * 当n=1时，则有跳法1种
 * 当n<=0时，则跳法为0种
 * 故该题可看为斐波那契数列的变种
 */
public class Extend {
    public int JumpFloor(int target) {
        if (target <= 0)
            return 0;
        else if (target == 1)
            return 1;
        else if (target == 2)
            return 2;
        int l = 1, ll = 2, sum = 0;
        for (int i = 3; i <= target; i++) {
            sum = l + ll;
            l = ll;
            ll = sum;
        }
        return sum;
    }
}
