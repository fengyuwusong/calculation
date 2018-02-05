package problem24;

/**
 * Created by fengyuwusong on 2018/2/5 21:55.
 * 二叉搜索树的后续遍历序列
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 知识点：
 * 二叉搜索树：左节点一定比父节点小或相等，右节点一定比父节点大或相等。
 * 后序遍历：左右根   根节点一定在末尾
 * <p>
 * 思路：
 * 例如序列：5 7 6 9 11 10 8
 * 根节点为8
 * 比8小的为左子树 5 7 6 其中6为左子树的根节点
 * 比8大的为右子书 9 11 10 其中10为右子树的根节点
 * 再次递归左子树序列 5 7 6
 * 根节点6 左子树5 右子树7
 * <p>
 * 反例 7 4 6 5
 * 根节点5
 * 由于最左边7比5大，故没有左子树
 * 7 4 6为右子树  但是由于右子树种存在元素4比根节点5小，故该序列不是一颗二叉搜索树
 * <p>
 * 由上述例子可以得知，可以使用递归。
 * 先获取数组最末尾的根节点，然后再划分左右子树，判断左右子树节点与根节点的大小。
 * 然后再将左右子树递归。
 *
 * 相关问题：
 * 前序遍历判断
 */
public class Main {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length==0){
            throw new RuntimeException("数组为空~");
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
//        递归出口
        if (start == end) {
            return true;
        }
        int root = sequence[end];
        int leftStart = start, leftEnd = start, rightStart = end - 1, rightEnd = end - 1;
        for (int i = start; i <= end; i++) {
            if (sequence[i] < root) {
                leftEnd = i;
            } else {
//                一旦有元素比根节点大，则下面的元素全部是右子树
                rightStart = i;
                break;
            }
        }
//        检查右子树是否存在比根节点小的
        for (int i = rightStart; i < rightEnd; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
//        遍历该节点下的左右子树
        return VerifySquenceOfBST(sequence, leftStart, leftEnd) && VerifySquenceOfBST(sequence, rightStart, rightEnd);
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.VerifySquenceOfBST(new int[]{7, 4, 6, 5}));
        System.out.println(main.VerifySquenceOfBST(new int[]{5, 7, 6, 9, 11, 10, 8}));
    }
}
