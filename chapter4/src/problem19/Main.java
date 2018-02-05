package problem19;

/**
 * Created by fengyuwusong on 2018/2/5 12:20.
 * 二叉树的镜像
 * 题目描述
 操作给定的二叉树，将其变换为源二叉树的镜像。
 输入描述:
 二叉树的镜像定义：源二叉树
     8
    /  \
   6   10
  / \  / \
 5  7 9 11
 镜像二叉树
     8
    /  \
   10   6
  / \  / \
 11 9 7  5


 思路：
 由观察可以发现，镜像即每个子树的左右节点替换位置,则可以遍历源二叉树，对每个节点的左右子树进行替换。
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
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
public class Main {
    public void Mirror(TreeNode root) {
        if (root==null)
            return;
        if (root.left!=null||root.right!=null) {
            swap(root);
//            分别对左右节点操作
            Mirror(root.left);
            Mirror(root.right);
        }
    }
    public void swap(TreeNode root){
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
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
        main.Mirror(treeNode1);
        System.out.println(treeNode1);
    }
}
