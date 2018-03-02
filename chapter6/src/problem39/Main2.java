package problem39;

/**
 * Created by fengyuwusong on 2018/3/2 13:31.
 * 平衡二叉树
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 平衡二叉树：二叉树的任意节点的左右子树的深度相差不超过1。
 * <p>
 * 思路：
 * 解法1：分别遍历树左右子树的最大深度  会造成重复节点浪费
 * 解法2：后序遍历记录左右子树深度并比较，避免节点浪费。
 */
public class Main2 {
    //    解法1
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
//        分别求左右子树最大深度
        int l = TreeDepth(root.left);
        int r = TreeDepth(root.right);
        if (Math.abs(l - r) >= 2) {
            return false;
        }
//        遍历左右子树
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    //    解法2
    private boolean isBalanced = true;

    public boolean IsBalanced_Solution2(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }

    private int getDepth(TreeNode root) {
//        减少不必要的递归次数
        if (root == null || isBalanced == false)
            return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1)
            isBalanced = false;
//        比较两者返回深度最大的值即该子树最大深度
        return left > right ? left + 1 : right + 1;
    }


    //    求最大深度
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(TreeDepth(root.left) + 1, TreeDepth(root.right) + 1);
    }
}
