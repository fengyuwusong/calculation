package problem18;

/**
 * Created by fengyuwusong on 2018/2/5 11:59.
 * 树的子结构
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 例如：
 *   树1：   8      树2：   8
 *          / \           / \
 *         8   7         9   2
 *        / \
 *       9   2
 *
 * 树2是树1的子结构
 *
 * 思路：
 * 遍历树1，查找节点与树2根节点的值一样的节点，然后再依次对比该节点的左右节点。
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
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean res=false;
//        先判断是否为空
        if (root1!=null&&root2!=null){
//            节点与根节点一直
            if (root1.val==root2.val){
//                判断子树是否一致
                res=DoesTree1HaveTree2(root1,root2);
            }
//            如果该节点不一致，则分别递归该节点的左右节点
            if (!res)
                res=HasSubtree(root1.left,root2);
            if (!res)
                res=HasSubtree(root1.right,root2);
        }
        return res;
    }

    private boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
//        递归出口
//        如果root2先递归为空，说明子树已经完全递归，包含全部结构
        if (root2==null)
            return true;
//        如果root1递归为空,root2还没为空，说明树1并不包含树2
        if (root1==null)
            return false;
//        如果值不相等则退出递归
        if (root1.val!=root2.val)
            return false;

//       如果值相等则递归该节点的左右节点对比
        return DoesTree1HaveTree2(root1.left,root2.left)&&DoesTree1HaveTree2(root1.right,root2.right);
    }

    public static void main(String[] args) {
        Main main=new Main();
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        TreeNode treeNode4=new TreeNode(4);
        TreeNode treeNode5=new TreeNode(5);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode3.right=treeNode5;

        TreeNode treeNode6=new TreeNode(3);
        TreeNode treeNode7=new TreeNode(5);
        treeNode6.right=treeNode7;
        System.out.println(main.HasSubtree(treeNode1, treeNode6));
        treeNode6.left=treeNode2;
        System.out.println(main.HasSubtree(treeNode1, null));
    }
}
