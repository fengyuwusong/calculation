package problem4;

/**
 * 相关问题：
 * 有两个排序的数组A1和A2，内存在A1的末尾有足够的空余空间容纳A2。
 * 请事先一个函数，把A2中的所有数字插入到A1中并且所有的数字是排序的。
 * Created by fengyuwusong on 2018/1/16 23:00.
 */
public class Relative {
    //解题思路：从尾到头比较A1和A2中的数字，并把较大的数字复制到A1的合适位置。
    public static int[] merge(int[] a1, int[] a2, int a1Length, int a2Length) {
//        a1的下标
        int a1Index = a1Length - 1;
//        a1的下标
        int a2Index = a2Length - 1;
//        合并后总下标
        int mergeIndex = a1Length + a2Length - 1;
//        判断长度是否足够
        if (a1.length < mergeIndex + 1) {
            System.out.println("a1长度不够");
            return null;
        }
//        进行从后向前循环比较并替换   优势：不用移动前面的数字
        while (a1Index >= 0 && a2Index >= 0) {
            if (a1[a1Index] >= a2[a2Index]) {
                a1[mergeIndex] = a1[a1Index];
                a1Index--;
                mergeIndex--;
            } else {
                a1[mergeIndex] = a2[a2Index];
                a2Index--;
                mergeIndex--;
            }
        }

//        考虑情况a2比a1长度长,此时a1已经没有数字，则将a2剩余数字放在数组前面
//        无需考虑a1情况，因为a2本身已经在数组a1中
        while (a2Index >= 0) {
            a1[mergeIndex] = a2[a2Index];
            a2Index--;
            mergeIndex--;
        }
        return a1;
    }

    public static void show(int[] a1) {
        if (a1 == null) {
            return;
        }
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3, 6, 9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        a2比a1长
        a1 = merge(a1, a2, 5, 9);
        show(a1);
//        a2比a1短
        int[] a3 = {0, 1, 3, 6, 9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] a4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        a1 = merge(a3, a4, 6, 3);
        show(a1);
//        a1长度不够
        int[] a5 = {1, 3, 6, 9, 10};
        int[] a6 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        a1 = merge(a5, a6, 5, 3);
        show(a1);
    }
}
