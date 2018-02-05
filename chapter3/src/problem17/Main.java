package problem17;

/**
 * Created by fengyuwusong on 2018/2/4 21:53.
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 例如：
 * 链表1:1->3->5->7
 * 链表2:2->4->6->8
 * 合并后:1->2->3->4->5->6->7->8
 * 思路：
 * 逐个判断两个参数节点大小，选取小的节点作为头结点，然后再将较小的节点填入同一方法参数，
 * 返回值为头结点的下一节点，形成递归排序。
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    public ListNode Merge(ListNode list1, ListNode list2) {
//        递归出口
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        ListNode head=null;
        if (list1.val<list2.val){
            head=list1;
            head.next=Merge(list1.next,list2);
        }else{
            head=list2;
            head.next=Merge(list1,list2.next);
        }
        return head;
    }

    public static void main(String[] args) {
        Main main = new Main();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(6);
        ListNode l8 = new ListNode(8);
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        ListNode p=main.Merge(l1,l5);
        while (p!=null){
            System.out.print(p.val);
            p=p.next;
        }
    }
}
