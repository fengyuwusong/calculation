package problem23;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by fengyuwusong on 2018/2/5 17:40.
 * 从上到下打印二叉树
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 思路：
 * 可以使用队列实现，当打印根节点后，左右节点进入队列，按照队列顺序出队打印，在打印的时候将该节点的左右节点存进入队列。
 * 例如树：
 *       1
 *      / \
 *     2   3
 *    / \  /\
 *   4  5 6  7
 * 1. 打印根节点1，将2、3存入队列.  队列 1 2
 * 2. 1出队，进行打印并且将1的左右节点入队。 队列 2 4 5
 * 3. 2出队，进行打印并且将2的左右节点入队。 队列 4 5 6 7
 * 4. 4出队，进行打印并且将其左右节点（无）入队。 队列 5 6 7
 * 5. 5出队，进行打印并且将其左右节点（无）入队。 队列 6 7
 * 6. 6出队，进行打印并且将其左右节点（无）入队。 队列 7
 * 7. 7出队，进行打印并且将其左右节点（无）入队。 队列 空
 * 8.由于队列为空，循环结束。
 *
 * 相关问题：
 * 广度优先遍历一个有向图。
 * 同样的方法。将起始节点放入队列。接下来从队列中取节点，并将该节点能到达的界定啊都依次放入队列中。
 * 重复这个遍历过程。直到队列中的节点全部被遍历为止。
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
    private ArrayList<Integer> arrayList =new ArrayList<>();
    private LinkedList<TreeNode> linkedList=new LinkedList<>();
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root==null){
            throw new RuntimeException("树不能为空~");
        }
//        添加该节点
        arrayList.add(root.val);
//        将该节点的左右节点入队
        if (root.left!=null) {
            linkedList.add(root.left);
        }
        if (root.right!=null) {
            linkedList.add(root.right);
        }
        if (linkedList.size()!=0){
//            递归队列
            PrintFromTopToBottom(linkedList.pop());
        }
        return arrayList;
    }

    public static void main(String[] args) {
        Main main=new Main();
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        TreeNode treeNode4=new TreeNode(4);
        TreeNode treeNode5=new TreeNode(5);
        TreeNode treeNode6=new TreeNode(6);
        TreeNode treeNode7=new TreeNode(7);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        treeNode3.left=treeNode6;
        treeNode3.right=treeNode7;
        ArrayList arrayList=main.PrintFromTopToBottom(treeNode1);
        System.out.println(arrayList);
    }
}
