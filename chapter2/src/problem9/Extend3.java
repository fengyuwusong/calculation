package problem9;

/**
 * Created by fengyuwusong on 2018/1/30 16:27.
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 解法：
 * 当使用一格2*1的小矩形去覆盖的时候，有两种方法：
 * 1) 竖着覆盖，则剩下的面积为 (2*n-1) 则接下来求 (2*n-1)的解决方法
 * 2) 横着覆盖，则剩下的面积为 (2*n-2)+一格必须横着覆盖的区域(已经确定) 则接下来求(2*n-2)的解决方法
 * 当n=1时： 只能竖着覆盖 1种方法
 * 当n=2时： 可以选择横着覆盖或竖着覆盖 2种方法
 * 当n=0时： 无解 0
 */
public class Extend3 {
    public int RectCover(int target) {
        if (target == 0)
            return 0;
        else if (target == 1)
            return 1;
        int l = 1, ll = 1, sum = 0;
        for (int i = 2; i <= target; i++) {
            sum = l + ll;
            l = ll;
            ll = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Extend3 extend3 = new Extend3();
        int res = extend3.RectCover(3);
        System.out.println(res);
    }
}
