package problem8;

/**
 * Created by fengyuwusong on 2018/1/29 15:09.
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 陷阱：
 * 1. 把一个数组最开始的若干个元素搬到数组的末尾 若干个包括0 级排序数组本身
 * 2. {1,0,1,1,1} 和{1,1,1,0,1}都可以视为 {0,1,1,1,1}的旋转
 */
public class Main {
    // 解法1：遍历  时间复杂度O(n) 不考虑
    // 解法2：二分查找 时间复杂度 O(logn)
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int startIndex, endIndex, midIndex;
        startIndex = 0;
        endIndex = array.length - 1;
//        预防陷阱1
        midIndex = array[startIndex];

        while (array[startIndex] >= array[endIndex]) {
//            跳出循环条件 如果start和end索引相邻
            if (endIndex - startIndex == 1) {
                midIndex = endIndex;
                break;
            }
//            找出中间 并移动坐标
            midIndex = (startIndex + endIndex) / 2;
//            预防陷阱2 如果start end mid值相等 则只能按照顺序查找
            if (array[startIndex] == array[endIndex] && array[startIndex] == array[midIndex]) {
                return MinInOrder(array, startIndex, endIndex);
            }
            if (array[midIndex] >= array[startIndex]) {
                startIndex = midIndex;
            } else if (array[midIndex] <= array[endIndex]) {
                endIndex = midIndex;
            }
        }
        return array[midIndex];
    }

    private int MinInOrder(int[] array, int startIndex, int endIndex) {
        int min = array[startIndex];
        for (int i = startIndex; i <= endIndex; i++) {
//            优化遍历 观察可发现一旦后面小于前面第一个则该值最小
            if (array[startIndex] >= array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int min = main.minNumberInRotateArray(new int[]{3, 4, 5, 1, 2});
        System.out.println(min);
    }
}
