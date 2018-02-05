package problem14;

/**
 * Created by fengyuwusong on 2018/2/4 20:07.
 * 题目描述 调整数组顺序使奇数位于偶数前面(相对剑指offer有所修改)
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 思路：
 * 解法1： 判断奇偶，如果是奇数则调至前面，该位置后面的数全都往后挪。时间复杂度O(n²)
 * 解法2： 判断奇偶，如果是偶数在奇数前面，则替换两者位置。时间复杂度O(n)
 */
public class Main {
//    解法2
    public void reOrderArray(int [] array) {
//        记录偶数个数
        int flag=0,temp;
        for (int i = 0; i < array.length; i++) {
            if (array[i]%2==0){
                flag++;
            }else{
                if (flag>0){
                    temp=array[i];
                    array[i]=array[--i];
                    array[i]=temp;
                    i--;
                    flag--;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main main=new Main();
        int[] ints=new int[]{1,2,3,4,5};
        main.reOrderArray(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
