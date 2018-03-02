package problem38;

/**
 * Created by fengyuwusong on 2018/3/2 11:43.
 * 数字在排序数组中出现的次数
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 * 例如数组{1,2,3,3,3,3,4,5}和数字3  3在数组中出现了4次，因此输出4
 * 思路：
 * 解法1：按照顺序遍历数组，定义一个count记录最大出现次数。时间复杂度O(n)
 * 解法2：利用二分查找找到第一个k和最后一个k。
 * 1. 先是找到第一个k，先拿数组中间的数与k对比，
 * 假如比k大，说明k在前半段区域，反之后半段。
 * 如果相等则判断该数的前一个数是否为k，假如是，则说明该数不是第一个k，如果不是这说明该数是第一个k。
 * 2. 找到最后一个k，在一个k和数组最后一个数区域间做对半查找，同上。
 * 3. 两个k所在索引相减。
 */
public class Main {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;
        int first = getFirstK(array, k, 0, array.length - 1);
        if (first == -1) {
            return 0;
        }
//        不能从first+1开始 当该数次数只有1的时候回出现错误
        int last = getLastK(array, k, first, array.length - 1);
        return last - first + 1;
    }

    public int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        if (array[mid] > k) {
            return getFirstK(array, k, start, mid - 1);
        } else if (array[mid] == k) {
            if (0 <= mid - 1 && array[mid - 1] == k) {
                return getFirstK(array, k, start, mid);
            } else {
                return mid;
            }
        } else {
            return getFirstK(array, k, mid + 1, end);
        }
    }

    public int getLastK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        if (array[mid] > k) {
            return getLastK(array, k, start, mid - 1);
        } else if (array[mid] == k) {
            if (array.length - 1 >= mid + 1 && array[mid + 1] == k) {
                return getLastK(array, k, mid + 1, end);
            } else {
                return mid;
            }
        } else {
            return getLastK(array, k, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.GetNumberOfK(new int[]{1, 3, 3, 3, 3, 4, 5}, 2));
        System.out.println(main.GetNumberOfK(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3));
        System.out.println(main.GetNumberOfK(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 0));
        System.out.println(main.GetNumberOfK(new int[]{1, 2, 3, 3, 3, 3}, 3));
        System.out.println(main.GetNumberOfK(new int[]{3}, 3));
    }
}
