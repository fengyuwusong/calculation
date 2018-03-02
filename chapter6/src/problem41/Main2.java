package problem41;

import java.util.ArrayList;

/**
 * Created by fengyuwusong on 2018/3/2 21:52.
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 例如数组{1,2,4,7,11,15} 和数字15 则有4 11
 * <p>
 * 此题解法同上.乘积最小也说明了必须从数组的两旁开始
 */
public class Main2 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (array == null || array.length < 2) {
            return null;
        }
        int smallIndex = 0;
        int bigIndex = array.length - 1;
        while (smallIndex != bigIndex) {
            if (array[smallIndex] + array[bigIndex] == sum) {
                ArrayList<Integer> arrayList = new ArrayList<>(2);
                arrayList.add(array[smallIndex]);
                arrayList.add(array[bigIndex]);
                return arrayList;
            } else if (array[smallIndex] + array[bigIndex] < sum) {
                smallIndex++;
            } else {
                bigIndex--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Main2 main2=new Main2();
        System.out.println(main2.FindNumbersWithSum(new int[]{1, 2, 4, 7, 11, 15}, 15));
    }
}
