package problem30;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by fengyuwusong on 2018/2/18 20:39.
 * 最小的k个数
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 例如输入 4 5 1 6 2 7 3 8 这8个数字，其中最小的4个数字分别是1 2 3 4
 * <p>
 * 思路：
 * 解法1：先排序 时间复杂度O（nlogn）
 * 解法2：基于29题的快排思路，确定数字的位置来确定范围 时间复杂度O(n) 需要改变原有数组顺序
 * 解法3: 如果是海量数据需采取解法3，因为解法2是一下将数组全部加在，占用内存高    看Main2
 * <p>
 * <p>
 * 陷阱：
 * 注意特殊边界条件：k=0 || k>input.lenth
 */
public class Main {
    //    解法2
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (input == null || input.length <= 0 || k > input.length || k == 0) {
            return arrayList;
//            throw new RuntimeException("参数错误~");
        }
        int length = input.length;
        int start = 0;
        int end = length - 1;
        int index = partition(input, length, start, end);
        while (index != k - 1) {
            if (index < k - 1) {
                start = index + 1;
                index = partition(input, end - start + 1, start, end);
            } else {
                end = index - 1;
                index = partition(input, end - start + 1, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }
        return arrayList;
    }

    public int partition(int[] array, int length, int start, int end) {
        if (array == null || array.length <= 0 || length != end - start + 1) {
            return 0;
//            throw new RuntimeException("参数错误~");
        }
//        范围内随机获取一个数字
        int index = end - new Random().nextInt(length);
        swap(array, index, end);
        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (array[i] < array[end]) {
                small++;
                if (small != i) {
                    swap(array, small, i);
                }
            }
        }
        small++;
        swap(array, small, end);
        return small;
    }

    private void swap(int[] array, int index, int end) {
        int temp = array[index];
        array[index] = array[end];
        array[end] = temp;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 10));
    }
}
