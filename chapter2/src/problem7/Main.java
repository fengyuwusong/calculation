package problem7;

import java.util.Stack;

/**
 * Created by fengyuwusong on 2018/1/29 14:55.
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Main {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
//        关键点，先判断是否已经为空在压入，否则由于之前的还存在会引起错乱
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.empty()) {
            throw new RuntimeException("此时为空~，不能获取");
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.push(1);
        main.push(2);
        System.out.println(main.pop());
        main.push(6);
        System.out.println(main.pop());
    }
}
