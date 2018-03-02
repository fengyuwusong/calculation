package problem40;

import java.util.ArrayList;

/**
 * Created by fengyuwusong on 2018/3/2 20:38.
 * 数组中只出现一次的数字
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 例如数组{2,4,3,6,3,2,5,5} 只有4和6出现了一次
 *
 * 思路：
 * 解法1：哈希遍历。空间时间复杂度都为O(n)
 * 解法2：使用异或运算。二进制下相同为0，不同为1。即2(10)^0(00)=2(10) 2(10)^1(01)=3(11)  2(10)^2(10)=0(00)
 * 故我们可以让数组所有数进行异或运算，最后出现的结果则为两个只出现一次的数的异或结果。
 * 把该结果的二进制最低位是否为1将数组分为两组在进行浴火运算即可得出两个只出现一次的数。
 * 例如{2,4,3,6,3,2,5,5}  4和6异或运算 100⊕110=010 即我们可以按照二进制中第2位是否为1将数组分为两半得到两个数(可以通过与运算得出)。
 *
 * 麻烦点：
 * 1. 得出异或结果1的最低位：右移对每一位与1相与。
 * 2. 通过最低位分割数组：同样右移最低位与1相与。
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Main {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int r=0;
        for (int i : array) {
            r^=i;
        }
        int count=0;
        while ((r&1)!=1){
            count++;
            r>>=1;
        }
        ArrayList<Integer> arrayList1=new ArrayList<>();
        ArrayList<Integer> arrayList2=new ArrayList<>();
        for (int i : array) {
            if (((i>>count)&1)==1)
                arrayList1.add(i);
            else
                arrayList2.add(i);
        }
        for (int i : arrayList1) {
            num1[0]^=i;
        }
        for (int i : arrayList2) {
            num2[0]^=i;
        }
    }

    public static void main(String[] args) {
        Main main=new Main();
        int[] num1=new int[1];
        int[] num2=new int[1];
        main.FindNumsAppearOnce(new int[]{2,4,3,6,3,2,5,5},num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
