package problem25;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by fengyuwusong on 2018/2/6 16:10.
 * 二叉树中和为某一值的路径
 * 题目描述
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 例如：
 * 10
 * /  \
 * 5   12
 * / \
 * 4   7
 * <p>
 * 二叉树中有两条和为22的路径：一条路径经过节点10、5、7 另一条经过10、12。
 * 思路：
 * 有上述例子可以发现，路径是由总是根节点出发到叶节点的。因此我们需要首先遍历根节点。
 * 在前中后三种遍历方式中，只有前序遍历是首先访问根节点的。
 * 那我们可以使用前序遍历的方式将遍历的节点存入栈获取路径。
 * 例如：
 * 1. 前序遍历 栈 10
 * 2. 前序遍历 栈 10 5 由于5没有指向父节点的成员且不是叶子节点，继续往下走。
 * 3. 前序遍历 栈 10 5 4  叶子节点，总值19 不符合。4 出栈
 * 4. 前序遍历 栈 10 5 7  叶子节点，总值22 符合。  输出，7出栈 5 左右节点遍历完毕 出栈 栈 10
 * 5. 前序遍历 栈 10 12   叶子节点，总值22 符合。输出。遍历完毕
 * 故可以使用递归解决
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
//    用于存储结果
    private ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
//    用于记录过程
    private Stack<Integer> stack =new Stack<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root==null){
            throw new RuntimeException("root不能为空~");
        }
        FindPath2(root,target);
        return lists;
    }

    private void FindPath2(TreeNode root, int target) {
//        递归出口
        if (root==null){
            return;
        }
//        入栈
        stack.push(root.val);
//        叶子节点判断
        if (root.left==null&&root.right==null){
            if (root.val==target){
//                记录符合条件
                ArrayList<Integer> list = new ArrayList<>(stack);
                lists.add(list);

            }
//            出栈
            stack.pop();
            return;
        }
//        不是叶子节点 递归左右节点
        FindPath2(root.left,target-root.val);
        FindPath2(root.right,target-root.val);
//        出栈
        stack.pop();
    }

    public static void main(String[] args) {
        Main main=new Main();
        TreeNode treeNode1=new TreeNode(10);
        TreeNode treeNode2=new TreeNode(5);
        TreeNode treeNode3=new TreeNode(12);
        TreeNode treeNode4=new TreeNode(4);
        TreeNode treeNode5=new TreeNode(7);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        System.out.println(main.FindPath(treeNode1, 22));
    }
}
