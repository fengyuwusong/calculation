package problem29;

import java.util.Random;

/**
 * Created by fengyuwusong on 2018/2/11 23:54.
 * 数组中出现次数超过一半的数字
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * <p>
 * 思路：
 * 解法1：先将数组排序，取中间的数字即出现次数超过数组长度一半的数字（中位数）。 排序时间复杂度O(nlogn) 快排事件复杂度
 * 解法2：基于快排的算法。 需要修改原数组顺序
 * 1、随机选择一个数调整位置，比他小的都在左边，比他大的都在右边。
 * 2、如果该数下标刚好是n/2，则是中位数，否则大于n/2的话中位数在左边，小于在右边，继续递归。 时间复杂度O（n）
 * 解法3：
 * 1、遍历数组，记录两个值，数字和次数。
 * 2、当数字相等时，次数+1，反之减1。
 * 3、如果次数等于0，这保存下一个数字，并把数字设为1.
 * 4、最后一个设为1的数字则是出现最多次数的数字。 占用两个空间 时间复杂度O(n)
 * <p>
 * <p>
 * 陷阱：
 * 1. 判断数组是否有效再做运算
 * 2. 判断最终中位数结果是否占数组元素的一半
 */
public class Main {
    //    解法2
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 0) {
//            throw new RuntimeException("参数不能为空");
            return 0;
        }
        int length = array.length;
//        右移取中间值
        int middle = length >> 1;
        int end = length - 1;
        int start = 0;
//        确定一个数的位置
        int index = Partition(array, length, start, end);
        while (index != middle) {
//            位于左边则中位数在右边 确定右边随机一个数字
            if (index < middle) {
                start = index + 1;
                index = Partition(array, end - start + 1, start, end);
            } else {
//            位于左边则中位数在左边 确定左边随机一个数字
                end = index - 1;
                index = Partition(array, end - start + 1, start, end);
            }
        }
//        判断是否超过一半
        if (checkMoreThanHalf(array, length, array[index])) {
            return array[index];
        }
        return 0;
    }
    //    解法3
//    public int MoreThanHalfNum_Solution(int[] array) {
////        记录次数
//        int times = 1;
////        记录数值
//        int target = array[0];
//        for (int i = 1; i < array.length; i++) {
//            if (target != array[i]) {
//                times--;
//            } else {
//                times++;
//            }
//            if (times == 0) {
//                target = array[i];
//                times = 1;
//            }
//        }
////        判断是否超过一半
//        if (checkMoreThanHalf(array, array.length, target)) {
//            return target;
//        }
//        return 0;
//    }

    //    快排-确定位置
    int Partition(int[] data, int length, int start, int end) {
        if (data == null || length <= 0 || start < 0 || (end - start + 1) != length) {
            throw new RuntimeException("参数异常");
        }
//        从start和end之间随机获取一个数字
        int index = end - new Random().nextInt(length);
//        先将该数字置于最右
        swap(data, index, end);
        int small = start - 1;
//        从开始遍历至结尾
        for (index = start; index < end; index++) {
//            将值比end小的置于最左
            if (data[index] < data[end]) {
                small++;
                if (small != index) {
                    swap(data, small, index);
                }
            }
        }
        small++;
        swap(data, small, end);
        return small;
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


    //    判断最终元素是否占数组的一半
    boolean checkMoreThanHalf(int[] array, int length, int num) {
        int times = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] == num) {
                times++;
            }
        }
        return times * 2 > length;
    }


    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}

