package problem36;

/**
 * Created by fengyuwusong on 2018/3/1 22:31.
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 * 示例1
 * 输入
 * 1,2,3,4,5,6,7,0
 * 输出
 * 7
 * <p>
 * <p>
 * 逆序对： 例如数组 {7,5,6,4} 一共存在5个逆序对 {7,6}{7,5}{7,4}{6,4}{5,4}
 * <p>
 * 思路：
 * 解法1：遍历整个数组，单个比较，时间复杂度O(n²)
 * 借法2：
 * 借鉴归并排序
 * 例如 {7 5 6 4}
 * 1. 分割成四个 {7} {5} {6} {4}
 * 2. {7}和{5}、{6}和{4} 分别比较计算逆序对并排序，得到 {5,7} {4,6}
 * 3. {5,7} {4,6}分别使用索引指向最后一个数字 7 6 比较大小，由于7>6 所以可以得知该步骤中由7开头的逆序对有该索引向后的所有数。7 6,7 4。数字7赋值进copy数组 7
 * 4. 7比较完毕，索引向后移。 5比6小，数组2索引向后移，数字6赋值进copy数组， 6,7。5比4大，得到逆序对5 4，将5添加入copy数组。得到5 6 7
 * 5. 数组{5,7}全部处理完毕。将两边没添加进copy数组的数字添加入索引，得到copy数组 4 5 6 7。
 * 6. 重复上述步骤
 */
public class Main {
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
//        用来存储排序后的数组
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array, copy, 0, array.length - 1);
        return count;
    }

    private int InversePairsCore(int[] array, int[] copy, int low, int height) {
        if (low == height)
            return 0;
        int mid = (low + height) >> 1;
//        递归分割
        int leftCount = InversePairsCore(array, copy, low, mid) % 1000000007;
        int rightCount = InversePairsCore(array, copy, mid + 1, height) % 1000000007;
        int count = 0;
        int i = mid;
        int j = height;
        int locCopy = height;
        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
//                左边数组索引之后的都是逆序对
                count += j - mid;
                copy[locCopy--] = array[i--];
//                数值过大求余
                count = count >= 1000000007 ? count % 1000000007 : count;
            } else
                copy[locCopy--] = array[j--];
        }
//        将剩余数字赋值进copy数组中
        for (; i >= low; i--) {
            copy[locCopy--] = array[i];
        }
        for (; j > mid; j--) {
            copy[locCopy--] = array[j];
        }
//        将copy赋值给array
        for (int s = low; s <=height; s++) {
            array[s]=copy[s];
        }
        return (leftCount+rightCount+count)%1000000007;
    }

    public static void main(String[] args) {
        Main main=new Main();
        System.out.println(main.InversePairs(new int[]{7, 5, 6, 4}));
    }
}
