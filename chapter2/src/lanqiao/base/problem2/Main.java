package lanqiao.base.problem2;

/**
 * Created by fengyuwusong on 2018/1/28 19:27.
 * 问题描述
 * 对于长度为5位的一个01串，每一位都可能是0或1，一共有32种可能。它们的前几个是：
 * <p>
 * 00000
 * <p>
 * 00001
 * <p>
 * 00010
 * <p>
 * 00011
 * <p>
 * 00100
 * <p>
 * 请按从小到大的顺序输出这32种01串。
 * <p>
 * 输入格式
 * 本试题没有输入。
 * 输出格式
 * 输出32行，按从小到大的顺序每行一个长度为5的01串。
 * 样例输出
 * 00000
 * 00001
 * 00010
 * 00011
 * <以下部分省略>
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        for (int m = 0; m < 2; m++) {
                            System.out.printf("%d%d%d%d%d\n", i, j, k, l, m);
                        }
                    }
                }
            }
        }
    }
}
