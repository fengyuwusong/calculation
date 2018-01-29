package problem6;


/**
 * Created by fengyuwusong on 2018/1/29 12:01.
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 常用知识：
 * 前序遍历：根左右 中序遍历：左根右 后序遍历：左右根
 * 宽度优先遍历：第一层->第二层->第三层...
 */
public class Main {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }


    public TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn)
            return null;

        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
//            判断根节点位置用以递归左右节点
            if (in[i] == pre[startPre]) {
                // 构建左子树 startPre为左子树前序遍历的开始位置 startPre + i - startIn 为左子树前序遍历结束位置
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                // 构建右子树 startPre为右子树前序遍历的开始位置 i - startIn + startPre + 1 为右子树前序遍历结束位置
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, in.length - 1);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] i1 = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] i2 = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = main.reConstructBinaryTree(i1, i2);
        System.out.println(root);
    }
}
