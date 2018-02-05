package problem15;

/**
 * Created by fengyuwusong on 2018/2/4 20:29.
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 思路：
 * 解法1：先遍历一次链表，确定有多少个节点 n，然后再遍历一次获得倒数第k个节点(n-k+1) 需要遍历两次，不够好
 * 解法2：设置两个指针，让指针1先走k-1，然后两个指针再一起走，当指针1走向尾部时，指针2也到达了n-k+1  (n-(k-1))
 *
 * 陷阱：
 * 注意代码健壮性,例如：
 * 1.k比节点n大
 * 2.k=0
 * 3.head=null
 *
 * 相关问题：
 * 1.求链表的中间节点：两个指针，一个走1步，一个走两步。当走两步的指针到达链尾时，走一步的刚好在中间。
 * 2.判断链表是否首尾相连：同上，当走两步的追上走一步的时候则为环形链表。
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head==null){
            throw new RuntimeException("链表为空~");
        }
        if (k<=0){
            throw new RuntimeException("参数k不能小于0~");
        }
//        从节点1(head)开始
        int flag=1;
        ListNode target=null,p=head;
        while (p!=null){
            if (flag<k){
                flag++;
            }else if (flag==k){
                target=head;
                flag++;
            }else{
                target=target.next;
            }
            p=p.next;
        }
        if (flag<k){
            throw new RuntimeException("倒数数k比链表节点长度还要大~");
        }else{
            return target;
        }
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
        System.out.println(main.FindKthToTail(l1, 1).val);
        System.out.println(main.FindKthToTail(l1, 2).val);
    }
}
