package problem44;

import java.util.Random;

/**
 * Created by fengyuwusong on 2018/3/2 23:15.
 * 题目描述
 * 判断数组的数是不是扑克牌的顺子。大小王可以做任意牌，用0表示。
 * 例如 1 3 4 6 5 0 是顺子
 * <p>
 * 思路：
 * 先将数组排序->统计0的个数->统计排序之后数组相邻间的空缺总数->如果空缺数大于0的个数则不是，反之是。
 * 注意点：如果有非零数重复出现则必定不是。
 */
public class Main {
    public boolean isContinuous(int[] numbers) {
        if (numbers==null||numbers.length==0)
            return false;
        quickSort(numbers, 0, numbers.length - 1, numbers.length);
        int countZero = 0;
        int countNot = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0)
                countZero++;
            if (i > 0 && numbers[i - 1] != 0) {
                //   判断是否有对子
                if (numbers[i - 1] == numbers[i])
                    return false;
                if (numbers[i] - 1 != numbers[i - 1])
                    countNot += numbers[i] - numbers[i - 1] - 1;
            }
        }
        return countZero >= countNot;
    }

    //    快排
    public void quickSort(int[] numbers, int start, int end, int len) {
        if (len == 0 || end <= start)
            return;
//        取范围内任意随机数
        int mid = new Random().nextInt(len) + start;
        int small = start;
//        先将中间数置于最后
        swap(numbers, mid, end);
//        找到目标数排序后所在的位置
        for (int i = start; i < end; i++) {
            if (numbers[end] > numbers[i]) {
                if (i != small) {
                    swap(numbers, i, small);
                }
                small++;
            }
        }
        swap(numbers, end, small);
//        递归左右部分
        quickSort(numbers, start, small - 1, small - start);
        quickSort(numbers, small + 1, end, end - small);
    }

    private void swap(int[] numbers, int i, int small) {
        int temp = numbers[i];
        numbers[i] = numbers[small];
        numbers[small] = temp;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] i = new int[]{0, 3, 2, 6, 4};
        System.out.println(main.isContinuous(i));
        int[] i2 = new int[]{1, 3, 0, 7, 0};
        System.out.println(main.isContinuous(i2));
    }
}
