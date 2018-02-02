package problem11;

/**
 * Created by fengyuwusong on 2018/1/31 12:35.
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 不得使用使用Math.pow()方法，不考虑大数问题
 * 知识点：错误处理方式：
 * 1.返回值：   优点 和系统API一致     缺点：不能方便的使用计算结果
 * 2.全局变量： 能够方便的使用计算结果  缺点：用户可能会忘记检查全局变量
 * 3.异常：     可以为不同的出错原因定义不同的异常类型，逻辑清晰明了     缺点：有些语言不支持异常，抛出异常时对性能有负面影响
 * 陷阱&优化：
 * 1.考虑exponent小于0的情况  当指数为小于0时，结果为base的指数的绝对值的次方的倒数
 * 2.考虑base=0的情况         0的0次方在数学上是无意义的，可以输出0或1   exponent>=0时，直接返回0，避免性能浪费
 * 3.base=0,exponent<0时  对0求倒的错误处理(0作为分母出错)
 * 4.exponent=0时    无论base等于多少结果都为1
 * 5.考虑次方计算优化
 * |aⁿ′²*aⁿ′²  n为偶数
 * aⁿ=     |a(ⁿ′²-¹)*a(ⁿ′²-¹)*a  n为奇数
 */

public class Main {
    public double Power(double base, int exponent) {
//        当遇到base == 0 && exponent < 0时抛出异常 陷阱3
        if (base == 0 && exponent < 0) {
            throw new RuntimeException("base为0时，exponent不能小于0！");
        } else if (base == 0) {
//            陷阱2处理
            return 0;
        }
//      必须考虑exponent是否小于0 陷阱1
        int exponent2 = exponent;
        if (exponent < 0) {
//            取绝对值
            exponent2 = exponent * -1;
        }
        double res = PowerWithUnsignedExponent(base, exponent2);
//        取倒
        if (exponent < 0) {
            res = 1 / res;
        }
        return res;
    }

    //    public double PowerWithUnsignedExponent(double base, int exponent) {
////        设置初始值为1 陷阱4
//        double res = 1.0;
//        for (int i = 1; i <= exponent; i++) {
//            res *= base;
//        }
//        return res;
//    }
//  优化 使用递归求出aⁿ′²（a(ⁿ′²-¹)）的结果
    public double PowerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }
//        使用位运算右移1位相当于 除以2，性能更高
        double res = PowerWithUnsignedExponent(base, exponent >> 1);
        res *= res;
//        使用位运算判断最后一位是否为1 即是否为奇数
        if ((exponent & 1) == 1)
            res *= base;
        return res;
    }

    public static void main(String[] args) {
        Main main = new Main();
        double res = main.Power(2, -3);
        System.out.println(res);
    }
}
