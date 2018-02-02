package problem13;

/**
 * Created by fengyuwusong on 2018/1/31 14:01.
 * 题目： 在O(1)时间删除链表节点
 * 给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间删除该节点。
 * <p>
 * 思路：
 * 解法1：从有遍历找到目标节点，然后删除链接下一节点。时间复杂度O(n)，不符合
 * 解法2：将目标节点下一个节点的值赋值目标节点，然后删除目标节点的下一个节点并链接下下个节点
 * 解法2需要考虑特殊情况：
 * 1.目标节点位于尾部，没有下一个节点。 则必须使用解法1,找到上一节点
 * 2.目标节点必须要位于链表中。必须和面试官考虑这种情况
 * <p>
 * <p>
 * 陷阱：方法中改变参数地址是无效的，只能改变他的成员变量
 */

//链表节点定义
class ListNode {
    Integer value;
    ListNode next;

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListNode listNode = (ListNode) o;

        if (value != listNode.value) return false;
        return next != null ? next.equals(listNode.next) : listNode.next == null;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }
}

public class Main {
    public void deleteNode(ListNode header, ListNode target) {
//        判断是否为空链表
        if (header == null) {
            throw new RuntimeException("链表为空");
        }
//        判断是否为尾部和头结点不等于目标节点(排除链表只有头结点情况且头结点刚好等于目标节点的情况)
        if (target.next == null && !target.equals(header)) {
            deleteNode2(header, target);
            return;
        }
//        直接让将下一节点赋值给他,完成替换  陷阱1，不能单纯改变地址，这样改变是无效的
//        target=target.next;
        if (target.next == null && target.equals(header)) {
            throw new RuntimeException("删除后链表为空~");
        }
        target.value = target.next.value;
        target.next = target.next.next;
    }

    public void deleteNode2(ListNode header, ListNode target) {
        ListNode p = header;
        while (p != null) {
//            需要重写equal方法
            if ((p.next).equals(target)) {
//                下一节点改为下下节点
                ListNode next = p.next;
                p.next = p.next.next;
//                删除该节点
                next = null;
            }
            p = p.next;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        ListNode l1 = new ListNode();
        l1.value = 1;
        ListNode l2 = new ListNode();
        l2.value = 2;
        ListNode l3 = new ListNode();
        l3.value = 3;
        ListNode l4 = new ListNode();
        l4.value = 4;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        main.deleteNode(l1, l3);
        System.out.println(l1);
        main.deleteNode(l1, l4);
        System.out.println(l1);
        main.deleteNode(l1, l1);
        System.out.println(l1);
//        main.deleteNode(null,l1);
        main.deleteNode(l1, l1);
        System.out.println(l1);
    }
}
