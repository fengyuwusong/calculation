package problem26;

/**
 * Created by fengyuwusong on 2018/2/6 17:00.
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 例如有复杂链表：
 *    ↓¯¯¯¯¯|
 * A->B->C->D->E
 * |__|__↑     ↑
 *    |________|
 *
 * 指向null的成员没有划出
 *
 * 思路：
 * 解法1：先遍历一遍链表，复制该next指针连接，如 A->B->C->D->E,在遍历一遍赋值random。
 * (注意：不能在第一遍直接赋值random，否则赋值的将是原链表的引用)，时间复杂度O(n²)
 * 解法2：时间复杂度O(n)
 * 1. 复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
 * 2. 重新遍历一次新链表，给random赋值，random的值=random原本节点的next节点
 * 3. 把链表拆开
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Main {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead==null){
            return null;
        }
//        复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
        RandomListNode pCur=pHead;
        while (pCur!=null){
            RandomListNode p=copy(pCur);
            pCur.next=p;
            pCur=p.next;
        }
        pCur=pHead;
        //复制random pCur是原来链表的结点 pCur.next是复制pCur的结点
        while (pCur!=null){
            if (pCur.random!=null){
                pCur.next.random=pCur.random.next;
            }
//            跳一个节点
            pCur=pCur.next.next;
        }
        RandomListNode head=pHead.next;
        RandomListNode cur=head;
        pCur = pHead;
//        拆分链表
//        不理解为啥这种写法通过不了oj
//        while (cur.next!=null){
//                cur.next = cur.next.next;
//                cur = cur.next;
//        }
        while (pCur!=null){
            pCur.next=pCur.next.next;
            if (cur.next!=null)
                cur.next=cur.next.next;
            cur=cur.next;
            pCur=pCur.next;
        }
        return head;
    }
//    复制方法
    private RandomListNode copy(RandomListNode p){
        RandomListNode node=new RandomListNode(p.label);
        node.next=p.next;
        node.random=p.random;
        return node;
    }

    public static void main(String[] args) {
        Main main=new Main();
        RandomListNode r1=new RandomListNode(1);
        RandomListNode r2=new RandomListNode(2);
        RandomListNode r3=new RandomListNode(3);
        RandomListNode r4=new RandomListNode(4);
        r1.next=r2;
        r1.random=r3;
        r2.next=r3;
        r3.next=r4;
        r3.random=r1;
        r4.random=r2;
        RandomListNode r=main.Clone(r1);
        System.out.println(r.label);
        System.out.println(r.random.label);
        System.out.println(r.next.label);
        System.out.println(r.next.next.label);
        System.out.println(r.next.next.random.label);
        System.out.println(r.next.next.next.random.label);
    }
}
