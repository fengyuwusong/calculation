package problem16;

/**
 * Created by fengyuwusong on 2018/2/4 21:06.
 * 题目描述
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * 思路：
 * 输入链表：1->2->3
 * 反转后：  1<-2<-3
 * 即将每个节点的next节点反向链接，即为反转
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Main {
//    可改用递归
    public ListNode ReverseList(ListNode head) {
        if (head==null){
            throw new RuntimeException("链表为空~");
        }
        ListNode p=head;
        ListNode reHead=null;
        ListNode pPre=null;

        while (p!=null){
            ListNode pNext=p.next;
//            判断尾节点作为反转后的head
            if (pNext==null){
                reHead=p;
            }
            p.next=pPre;
//            记录已经反转的节点
            pPre=p;
            p=pNext;
        }
        return reHead;
    }

    public static void main(String[] args) {
        Main main = new Main();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode p=main.ReverseList(l1);
        while (p!=null){
            System.out.print(p.val);
            p=p.next;
        }
    }
}
