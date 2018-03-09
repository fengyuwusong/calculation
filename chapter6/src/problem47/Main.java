package problem47;

/**
 * Created by fengyuwusong on 2018/3/3 20:39.
 * 不用加减乘除做加法
 * 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 思路：对两个数每一位进行或运算，如果都为1进1位。
 * 例如5(101) 17(10001)
 * 1. 相加不计进位  两个数做异或运算 10100
 * 2. 记下进位      两个数做与运算   00001
 * 3. 两个步骤得到的数相加 重复步骤1 2
 */
public class Main {
    //    过于复杂，不能通过oj
//    public int Add(int num1, int num2) {
////        当前位数
//        int r = 0;
////        进位标志
//        boolean j = false;
////        结果
//        int sum = 0;
//        while (num1 != 0 || num2 != 0) {
////            都为1
//            if ((num1 & 1) == 1 && (num2 & 1) == 1) {
////                判断是否有进位
//                if (j) {
//                    sum |= (1<<r);
//                }
//                j = true;
//            } else if (((num1 & 1) ^ (num2 & 1) & 1) == 1) {
//                if (!j)
//                    sum |= (1<<r);
//            } else if (j) {
//                sum |= (1<<r);
//                j = false;
//            }
//            num1>>=1;
//            num2>>=1;
//            r++;
//        }
//        if (j){
//            sum |= (1<<r);
//        }
//        return sum;
//    }
    public int Add(int num1, int num2) {
        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return num1;
    }


    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.Add(2000001, 200123));
    }
}
