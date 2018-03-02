package problem39;

/**
 * Created by fengyuwusong on 2018/3/2 13:22.
 * 二叉树的深度
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 例如树：         1
 *                /  \
 *               2    3
 *              / \  /
 *             4  5  6
 *            /
 *           7
 * 深度为4
 *
 * 思路：
 * 解法1：深度遍历找出最深深度。
 * 解法2：递归左右子树。
 *
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Main {
    public int TreeDepth(TreeNode root) {
        if (root==null)
            return 0;
        return Math.max(TreeDepth(root.left)+1,TreeDepth(root.right)+1);
    }
}
