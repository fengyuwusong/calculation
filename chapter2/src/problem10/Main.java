package problem10;


/**
 * Created by fengyuwusong on 2018/1/30 16:50.
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 知识点：
 * 1) 与、或、异或的运算规律
 * 与(&)     0&0=0       1&0=0   0&1=0       1&1=1
 * 或(|)     0|0=0       1|0=1   0|1=1       1|1=1
 * 异或(^)   0^0=0       1^0=1   0^1=1       1^1=0     相同为0 不同为1
 * 2) m<< n
 * 表示把m左移n位。左移n位的时候，最左边的n位将被抛弃，同时在最右边不上n个0.比如：
 * 00001010<<2=00101000
 * 10001010<<3=01010000
 * m>>n
 * 表示把m右移n位。右移n位的时候，
 * 如果数值是一个无符号数值，则用0填补最左边的n位。
 * 如果数值是一个有符号数值，则用数值的符号位填补最左边的n位。
 * 即正数右移补0，负数右移补1，例如：
 * 00001010>>2=00000010
 * 10001010>>3=11110001
 * 使用位运算解法：
 * 将该数与1做与运算，则可以知道其二进制最右边的位数的值是否为1
 * 则每与1运算一次，将数二进制像右移一位再作比较即可比较完全部位数
 * 当数==0时跳出循环。
 * 特例：
 * 假如该数为负数，由于要补1，则该数值不可能为0，并且会不准确。
 * 故正确做法应该是将1左移与目标的位数进行比较。
 * <p>
 * 陷阱&难点：
 * 1. 跳出循环条件
 * 2. 与操作之后判断时候为1的条件是他的结果是否等于flag 而不是等于1
 * <p>
 * 缺点：
 * 对于int类型的二进制数需要进行32次循环
 * <p>
 * <p>
 * <p>
 * <p>
 * 最优解：
 * 思路：
 * 我们可以通过分析下面算数发现：
 * 1100-1=1011  1010-1=1001
 * 通过分析可知，一个二进制数-1 得到的结果是最右边的1变为0（1100->1011 第二个1变为0）
 * 最右边左边的数字不变，最右边的值取反 （1100->1011 第一个1不变  00 变成11）
 * 则对1100 和 1011进行与操作， 1100&1011=1000  1000-1=0111 1000&0111=0
 * 总结起来可以得知：
 * 一个二进制数有多少个1，则可以进行多少次减1后结果相与的操作
 * 优点：
 * 无需进行额外的循环
 */
public class Main {
    //    基本解法
//    public int NumberOf1(int n) {
//        int count = 0;
//        int flag = 1;
////        当flag左移到大于Integer.MAX_VALUE -2的32--2的32次方-1时
////        int的二进制最小值为10000000000000000000000000000000
////        再进行左移值为0
//        while (flag!=0) {
////            与操作之后等于flag本身 例如 1100100 与 4（100） 则结果为100 （4）
////            也可以判断为不等于0
//            if ((n & flag) != 0) {
//                count++;
//            }
//            flag = flag << 1;
//        }
//        return count;
//    }
//    最优解
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n = (n - 1) & n;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int res = main.NumberOf1(-2147483648);
        System.out.println(res);
        System.out.println(Integer.toBinaryString(20));
        System.out.println(Integer.toBinaryString(13));
        System.out.println(Integer.toBinaryString(20 ^ 13));
    }
}

//相关题目：
//1.用一条语句判断一个整数是否为2的整数平方
//  思路：如果为2的整数平方，则其二进制只有一个位数为1，其余为0，则上述最优解做法只能使用一遍：
//  即条件为    (n-1)&n==0
//2.输入两个整数m和n，计算需要改变m的二进制表示中的多少位才能得到n。
//  例如：10的二进制1010 13的二进制1101 则1010需改变3位才能得到1101
// 思路：
// 1.先求两个二进制的异或 1010^1101=0111
// 2.统计结果中1的个数    3