package problem20;

import java.util.ArrayList;

/**
 * Created by fengyuwusong on 2018/2/5 13:01.
 * 顺时针打印矩阵
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵：
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Main {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null)
            return null;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int start = 0, rows = matrix.length, columns = matrix[0].length;
//        如果行列坐标皆大于start开始坐标*2，则说明可以调用printMatrixInCircle函数打印一周
        while (rows > start * 2 && columns > start * 2) {
            arrayList.addAll(printMatrixInCircle(matrix, columns, rows, start));
            start++;
        }
        return arrayList;
    }

    private ArrayList printMatrixInCircle(int[][] matrix, int columns, int rows, int start) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
//        从左到右打印一行 必须
        for (int i = start; i <= endX; i++) {
            arrayList.add(matrix[start][i]);
//            System.out.print(matrix[start][i]);
        }
//        从上到下打印一行
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                arrayList.add(matrix[i][endX]);
//                System.out.print(matrix[i][endX]);
            }
        }
//        从右到左打印一行
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                arrayList.add(matrix[endY][i]);
//                System.out.print(matrix[endY][i]);
            }
        }
//        从上到下打印一行
        if (start < endX && start < endY - 1) {
            for (int i = endY-1; i >=start+1; i--) {
                arrayList.add(matrix[i][start]);
//                System.out.print(matrix[i][start]);
            }
        }
        return arrayList;
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.printMatrix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
    }
}
