package problem37;

/**
 * Created by fengyuwusong on 2018/3/1 23:17.
 * 两个链表的第一个公共节点
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。
 * <p>
 * 思路：
 * 解法1：蛮力遍历时间复杂度O(mn)
 * 解法2：由于两个链表具有公共节点，那么在公共节点之后的节点都是相同的。其结构类似于Y形。如下所示：
 * 1->2->3
 * \
 * 5->6->7
 * 11->22 /
 * 故我们可以使用两个辅助栈，将两个链表压入栈中，从尾部开始比较，当遍历到最后一个相同的节点的时候即为第一个公共节点。时间复杂度O(n+m)
 * <p>
 * 解法3：由解法2思路，我们可以先分别遍历两个链表，记录两个链表的长度差，让较长的链表先走n（差值）步，然后再一起走。
 * 当遇到第一个相同的节点即为第一个公共节点。 相比解法2节省空间，不需要使用辅助栈。
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int len1 = 0, len2 = 0;
        ListNode cur = pHead1;
        while (cur != null) {
            len1++;
            cur = cur.next;
        }
        cur = pHead2;
        while (cur != null) {
            len2++;
            cur = cur.next;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (len1 > len2) {
            p1 = p1.next;
            len1--;
        }
        while (len2 > len1) {
            p2 = p2.next;
            len2--;
        }
        while (len1 > 0) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Main main=new Main();
        ListNode p1=new ListNode(1);
        ListNode p2=new ListNode(2);
        ListNode p3=new ListNode(3);
        ListNode p4=new ListNode(4);
        ListNode p5=new ListNode(5);
        ListNode p6=new ListNode(6);
        p1.next=p2;
        p2.next=p3;
        p4.next=p5;
        p5.next=p3;
        p3.next=p6;
        System.out.println(main.FindFirstCommonNode(p1, p4).val);
    }
}
