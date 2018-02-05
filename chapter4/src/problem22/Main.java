package problem22;

import java.util.Stack;

/**
 * Created by fengyuwusong on 2018/2/5 15:45.
 * 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * 思路：
 * 建立辅助栈进行模拟压入弹出操作
 * 由 1 2 3 4 5 压入顺序和弹出顺序4 5 3 2 1 ，可以得知
 * 1. 因为4是第一个弹出来的，故4必须在栈顶，那么相应的在4压入之前的1 2 3 也是已经压入。此时栈内元素为 1 2 3 4
 * 2. 5是第二个弹出来的，由于5之前的所有元素都已经入栈，故5即是压入栈后立马弹出，此时栈内元素为 1 2 3 4 5
 * 3. 剩余的3 2 1同理
 * 根据弹出顺序4 3 5 1 2可以得知：
 * 1. 因为4是第一个弹出来的，故4必须在栈顶，那么相应的在4压入之前的1 2 3 也是已经压入。此时栈内元素为 1 2 3 4
 * 2. 3是第二个弹出来的，此时栈内元素为 1 2 3
 * 3. 5是第三个弹出来的，由于5之前的所有元素都已经入栈，故5即是压入栈后立马弹出，此时栈内元素为 1 2 3 5
 * 4. 弹出1，但是由于此时栈元素顺序为 1 2 ，故1不可能弹出。
 *
 *
 * 由上述推断，我们可以得知，当弹出一个元素时，该元素在压入顺序的前面的元素都必须按照压入顺序入栈。
 * 故我们可以通过该方法模拟栈的操作，判断该顺序是否是可以弹出的序列。
 */
public class Main {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack=new Stack<>();
        int index=0,flag;
        for (int i = 0; i < popA.length; i++) {
//            如果弹出元素已经是栈顶元素，则直接出栈
            if (stack.size()>0&&stack.peek()==popA[i])
                stack.pop();
//            否则循环压入顺序，将还没入栈到目标元素的全部入栈，
            else {
//                是否找到对应元素标识
                flag=0;
                for (int j = index; j < pushA.length; j++) {
                    stack.push(pushA[j]);
                    if (popA[i] == pushA[j]) {
                        stack.pop();
                        index = j+1;
                        flag=1;
                        break;
                    }
                }
                if (flag!=1){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Main main=new Main();
        int[] i1=new int[]{1,2,3,4,5};
        int[] i2=new int[]{4,5,3,2,1};
        int[] i3=new int[]{4,3,5,1,2};
        System.out.println(main.IsPopOrder(i1, i2));
        System.out.println(main.IsPopOrder(i1, i3));
    }
}
