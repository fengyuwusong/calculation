package problem52;

/**
 * Created by fengyuwusong on 2018/3/3 23:19.
 * 构建乘积数组
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * <p>
 * 思路：
 * 解法1：穷举
 * 解法2：动态规划,将B[i]的所有绘制成矩形图可以得到：
 * B0     1   A₁  A₂ ... An-2 An-1   ₃
 * B1     A0  1   A2 ... An-2 An-1
 * ...
 * Bn-2   A0  A1  ... An-3  1  An-1
 * Bn-1   A0  A1  ... An-3  An-2  1
 * <p>
 * 则可以发现乘法由两部分构成， C[i]=A[1]*A[2]*...*A[i-1] 和D[i]=A[i+1]*A[i+2]*...*A[n-1]
 * 第一部分可以由底向上得出，第二部分可以由顶向下得出。
 * C[i]=C[i-1]*A[i-1]  D[i]=D[i+1]*A[i+1]
 * C[0]=1 C[1]=C[0]*A[i-1]=1*0 ...
 * D[n-1]=1 D[n-2]=D[n-1]*A[n-1]
 *
 * 解法3：该题如果第一个数固定为0的话，那么出i=0的时候，后面的数全部都是乘以0，那么只需要计算 1到n-1即可。
 */
public class Main {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0)
            return null;
        int[] b = new int[A.length];
//        先计算前半段
        b[0] = 1;
        for (int i = 1; i < b.length; i++) {
            b[i] = b[i - 1] * A[i - 1];
        }
//        计算后半段并相乘
        int temp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            temp *= A[i + 1];
            b[i] *= temp;
        }
        return b;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] b = main.multiply(new int[]{0, 1, 2, 3, 4, 5});
        for (int i : b) {
            System.out.print(i + ",");
        }

    }

}
