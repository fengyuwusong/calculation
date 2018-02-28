package problem31;

/**
 * Created by fengyuwusong on 2018/2/18 22:12.
 * 连续子数组的最大和
 * 题目：输入一个整型数据组，数组中有正数也有负数。数组中一个或连续多个正数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度O(n)
 * 例如：输入数组{1,-2,3,10,-4,7,2,-5} 最大子数组为{3,10,-4,7,2,-5} 和为18
 * <p>
 * 思路：
 * 解法1：枚举所有子数组之和 时间复杂度O(n²)
 * 解法2：找规律，从头到尾逐步累加数组中的每个数字，如：
 * 1. 初始化为0， 加1=1，再加-2=-1，再加3=2，比三本身还小。
 * 2. 由上述例子可知加入加上一个数后和比本身还小，则抛弃该数值之前的数字之和，从第2个数字开始。
 * 3. 基于2继续，-2+3=1，不符合，所以我们从3开始。
 * 4. 3+10=13 13+-4=9 由于-4是一个负数，加上去的和比之前还小，故我们保存当前最大和13.
 * 5. 9+7=16,16大于13，故将最大值更新为16,
 * 6. 16+2=18 最大值更新为18 18+-5=13 小于存储的最大值
 * 故返回子数组{3,10,-4,7,2,-5} 和为18
 * <p>
 * 解法3：使用动态规划
 * 由解法2可以得到递归公式：
 * F(i) |   pData[i]            i=0|f(i-1)<=0  当之前的和最大值为负数或0  或者  i=0时  解法2步骤2
 *      |   f(i-1)+pData[i]     i!=0并且F(i-1)>0
 * res：存储当前最大值
 * res=max（res，F（i））
 * <p>
 * 如数组[6, -3, -2, 7, -15, 1, 2, 2]
 * 初始状态：
 *     F（0）=6
 *     res=6
 * i=1：
 *     F（1）=max（F（0）-3，-3）=max（6-3，3）=3
 *     res=max（F（1），res）=max（3，6）=6
 * i=2：
 *     F（2）=max（F（1）-2，-2）=max（3-2，-2）=1
 *     res=max（F（2），res）=max（1，6）=6
 * i=3：
 *     F（3）=max（F（2）+7，7）=max（1+7，7）=8
 *     res=max（F（2），res）=max（8，6）=8
 * i=4：
 *     F（4）=max（F（3）-15，-15）=max（8-15，-15）=-7
 *     res=max（F（4），res）=max（-7，8）=8
 * 以此类推
 * 最终res的值为8
 */
public class Main {
    //    解法2 O（n）
//    public int FindGreatestSumOfSubArray(int[] array) {
//        if (array == null || array.length <= 0) {
//            return 0;
//        }
////        如需返回子数组则记录start和end
////        int start=0;
////        int end=0;
//        int sum = 0;
//        int max = -1;
//        int index = 0;
//        for (int i = 0; i < array.length; i++) {
//            sum += array[i];
//            max = max > sum ? max : sum;
//            if (sum < array[i]) {
//                i = ++index;
//                sum = 0;
//            }
//        }
//        return max;
//    }
//    解法3 动态规划
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = array[0];
        int max = -1;
        for (int i = 1; i < array.length; i++) {
            sum = sum <= 0 ? array[i] : sum + array[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.FindGreatestSumOfSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));
        System.out.println(main.FindGreatestSumOfSubArray(new int[]{-1, -2, -3, -10, -4, -7, -2, -5}));
    }
}
