package problem33;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by fengyuwusong on 2018/2/28 21:12.
 * 把数组排成最小的数
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * <p>
 * 思路：
 * 解法1：求数组的全排列比较，时间复杂度高  共有n!个排列
 * <p>
 * 解法2：找出规律
 * 例如{123,213,321}
 * 1.先找出首数字最小的数，填充进目标
 * 2.假如相等则比较第二位
 * 3.如果全部都相等，则比较位数，位数长的优先
 * 4.重复上述步骤直到所有数用完
 * <p>
 * 上述步骤可以使用String的compareTo方法
 * <p>
 * <p>
 * 陷阱：
 * 可能存在int溢出，需要转换字符串拼接
 */
public class Main {

    public String PrintMinNumber(int[] numbers) {
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int x : numbers) {
            arrayList.add(x);
        }
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        for (int num : arrayList) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }
}
