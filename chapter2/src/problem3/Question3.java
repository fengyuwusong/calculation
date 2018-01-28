package problem3;


/**
 * 二维数组的查找:
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 关键点： 选取数组中比较的数字需要可以准确的排除掉数组的一部分。如选取中间点或左上右下，则无法准确排除数组部分。需选择右上或左下。
 * Created by fengyuwusong on 2018/1/15 22:54.
 */
public class Question3 {

    static boolean find(int[][] ints, int row, int columns, int target) {
        if (ints.length == 0 || ints[0].length == 0) {
            return false;
        }
        for (int i = 0, j = columns - 1; i < row && j >= 0; ) {
            if (target > ints[i][j]) {
                i++;
            } else if (target < ints[i][j]) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] ints = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
//        测试用例编写
//        最大值
        System.out.println(find(ints, ints.length, ints.length, 15));
//        最小值
        System.out.println(find(ints, ints.length, ints.length, 1));
//        在数组中最大最小之间的数字
        System.out.println(find(ints, ints.length, ints.length, 7));
//        大于最大值的数字
        System.out.println(find(ints, ints.length, ints.length, 16));
//        小于最小值的数字
        System.out.println(find(ints, ints.length, ints.length, 0));
//        在数组之间但并不存在
        System.out.println(find(ints, ints.length, ints.length, 5));
//        特殊输入 空
        int[][] test2 = {{}};
        System.out.println(find(test2, test2.length, test2.length, 16));
    }
}
