package problem30;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by fengyuwusong on 2018/2/18 21:53.
 * 思路：
 * 先创建一个容量为k大的数据容器存储最小的k个数，遍历输入数组，如果未填容器满则填入。如果已经填满则操作一下步骤：
 * 1.找到容器中最大的数l
 * 2.比较数组中的下一个数与他的大小，如果小则替换
 * 3.反之抛弃
 * <p>
 * 我们可以选择不同的二叉树来实现这个数据容器 例如最大堆或红黑树：
 * 最大堆：在最大堆中，根节点的值总是大于他的子树中任意节点的值。
 * 所以使用最大堆我们每次都可以在O(1)得到已有k个数字中的最大值，但需要O(logk)的时间完成删除及插入操作
 * <p>
 * 红黑树：红黑树通过吧节点分为红黑两种颜色并根据一些规则确保树在一定程度上是平衡的。
 * 从而保证在红黑树中查找、删除、插入操作都只需要O(logk)时间
 */
public class Main2 {
//    解法3

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int length = input.length;
        if (k > length || k == 0) {
            return result;
        }
//        创建容量为k的最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
//            降序
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
//            容量不足时
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
//                容量充足时且遍历数小于最大值 替换
                Integer temp = maxHeap.poll();
//                数据量大时赋值null可以加快gc回收
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        result.addAll(maxHeap);
        return result;
    }
}
