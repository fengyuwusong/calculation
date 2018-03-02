package problem41;

import java.util.ArrayList;

/**
 * Created by fengyuwusong on 2018/3/2 21:14.
 * 输出所有和为S的连续正数序列
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 例如输入数字15 可以得到 1-5 4-6 7-8
 * <p>
 * 思路：
 * 解法1：遍历1-（n/2），将当前数与后面数相加，时间复杂度O(n²)
 * 解法2：初始化两个索引，small=1,big=2
 * 当small+...+big小于n时，增大big
 * 当small+...+big大于big时，增大small
 * 当small=(1+s)/2(一半位置)为止
 * <p>
 * 例如9
 * 1. small=1 big=2 small+...+big=3<9 big+1
 * 2. small=1 big=3 small+...+big=6<9 big+1
 * 3. small=1 big=4 small+...+big=10>9 small+1
 * 4. small=2 big=4 small+...+big=9=9 得出序列2 3 4
 * 5. big+1 small=2 big=5 small+...+big=14>9 small+1
 * 6. small=3 big=5 small+...+big=12>9 small+1
 * 7. small=4 big=5 small+...+big=9=9 得到序列 4 5
 * 8. big+1 small=4 big=6 small+...+big=15>9 small+1
 * 9. small=5=(s+1)/2 循环结束
 */
public class Main {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int small = 1;
        int big = 2;
        int res;
        while (small < (sum + 1) / 2) {
            res=0;
            for (int i = small; i <= big; i++) {
                res += i;
            }
            if (res == sum) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    arrayList.add(i);
                }
                list.add(arrayList);
                big++;
            } else if (res > sum) {
                small++;
            } else {
                big++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Main main=new Main();
        System.out.println(main.FindContinuousSequence(9));
    }
}
