package problem5;

import java.util.ArrayList;

/**
 * Created by fengyuwusong on 2018/1/28 23:38.
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


public class Main {
//    使用Collections的reverse
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> arrayList=new ArrayList<>();
//        if (listNode != null) {
//            arrayList.add(listNode.val);
//            while (listNode.next != null) {
//                listNode=listNode.next;
//                arrayList.add(listNode.val);
//            }
//        }
//        Collections.reverse(arrayList);
//        return arrayList;
//    }

    //    巧用add方法
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> arrayList=new ArrayList<>();
//        if (listNode != null) {
//            arrayList.add(listNode.val);
//            while (listNode.next != null) {
//                listNode=listNode.next;
//                arrayList.add(0,listNode.val);
//            }
//        }
//        return arrayList;
//    }
//    巧妙使用递归
    private ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        Main main = new Main();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ArrayList<Integer> arrayList = main.printListFromTailToHead(listNode1);
        System.out.println(arrayList);
    }
}
