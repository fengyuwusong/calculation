package problem21;

/**
 * Created by fengyuwusong on 2018/2/5 15:22.
 * 包含min函数的栈
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 陷阱：
 * 需要额外定义一个辅助栈存储min，不能单纯使用一个变量int存储，因为如果出栈的是最小元素，则无法知道第2小元素是多少。
 * 例如栈内有元素
 * 5 4 3 2 1
 * 其中最小元素用int存储为min=1
 * 假设1出栈，则无法min变量无法知道第2小元素，故需要用另一个栈来存储大小顺序.
 * 假设一个空栈进行一下步骤：
 * 1. 压入5,则最小值为5，辅助栈也压入5。 栈 和辅助栈都为 5
 * 2. 压入4,则最小值是4，辅助栈也压入4。 栈 和辅助栈都为 5 4
 * 3. 压入6,因为当前辅助栈顶是4，小于6，则辅助栈压入4。   栈 和辅助栈分别为 5 4 6 | 5 4 4  （由此可知辅助栈顶为当前最小值）
 * 4. 弹出，则此时辅助栈和栈都正常弹出。  辅助栈顶则为当前最小值。栈 和辅助栈分别为 5 4 | 5 4
 * 5. 弹出，则此时辅助栈和栈都正常弹出。  辅助栈顶则为当前最小值。栈 和辅助栈分别为 5 | 5
 * 故采用这种方法可以避免上述问题。
 */
public class Main {
    private int[] arr=new int[10000];
    private int index=-1;
    private int[] min=new int[10000];
    public void push(int node) {
        if (index==9999){
            throw new RuntimeException("栈满了~");
        }
        index++;
        if (index==0){
            min[index]=node;
        }else{
            min[index]=min[index-1]<node?min[index-1]:node;
        }
        arr[index]=node;
    }

    public void pop() {
        if (index==-1){
            throw new RuntimeException("栈内还没有任何元素~");
        }
        index--;
    }

    public int top() {
        if (index==-1){
            throw new RuntimeException("栈内还没有任何元素~");
        }
        return arr[index];
    }

    public int min() {
        if (index==-1){
            throw new RuntimeException("栈内还没有任何元素~");
        }
        return min[index];
    }

    public static void main(String[] args) {
        Main main=new Main();
        main.push(3);
        System.out.println(main.min());
        main.push(4);
        System.out.println(main.min());
        main.push(2);
        System.out.println(main.min());
        main.push(3);
        System.out.println(main.min());
        main.pop();

    }
}
