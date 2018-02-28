package problem27;

/**
 * Created by fengyuwusong on 2018/2/9 23:22.
 * 二叉搜索树与双向链表
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 例如：
 *      10
 *     /  \
 *    6   14         转换后： 4<=>6<=>8<=>10<=>12<=>14<=>16
 *   / \   /\
 *  4  8  12 16
 *  思路：
 *  可以根据中序(左根右)，刚好能够从小到大遍历
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
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null){
            return null;
        }
//        如果节点是叶子节点
        if(pRootOfTree.left==null&&pRootOfTree.right==null){
            return pRootOfTree;
        }
//        递归左节点
        TreeNode left=Convert(pRootOfTree.left);
        TreeNode pCur=left;
//        遍历至最后一个节点
        while (pCur!=null&&pCur.right!=null){
            pCur=pCur.right;
        }
//        拼接左节点<=>根节点
        if (left!=null){
            pCur.right=pRootOfTree;
            pRootOfTree.left=pCur;
        }
//        递归右节点
        TreeNode right=Convert(pRootOfTree.right);
//        拼接根节点<=>右节点
        if (right!=null){
            right.left=pRootOfTree;
            pRootOfTree.right=right;
        }
        return left!=null?left:pRootOfTree;
    }
}
