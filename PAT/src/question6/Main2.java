package question6;

import java.util.*;

/**
 * Created by fengyuwusong on 2018/3/5 10:49.
 * 思路：首先可以想到以O(sqrt(n))的复杂度求出所有因子。
 * 然后排序，这样问题就转化为求一个数组的最长连续子数组了。一开始想到的是用简单的DP，定义DP[i]为以i结尾的最长连续子数组的长度。
 * 则动态规划转移方程为
 * if a[i]==a[i-1]+1 dp[i]=dp[i-1]+1;
 * else dp[i]=1;
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        int lim = (int) Math.sqrt(num);
        List<Long> list = new ArrayList<>();
//        求出所有因子
        for (long i = 2; i < lim; i++) {
            if (num % i == 0) {
                if (num == i * i) list.add(i);
                else {
                    list.add(i);
//                    将其另外一个因子也放进去
                    list.add(num / i);
                }
            }
        }
//        将因子排序
        Collections.sort(list);
//        如果是素数则没有因子，直接输出
        if (list.size()==0){
            System.out.println(1);
            System.out.println(num);
            return;
        }
//        len保存最长因子，p保存起始位置
        int len = 1, p = 0;
//        遍历所有因子O(n²)
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (judge(list, i, j, num)) {//如连续，看是否可以更新最优解
                    if (j - i + 1 > len) {
                        len = j - i + 1;
                        p = i;//可以更新就更新最优解
                    }
                }
            }
        }
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(i == 0 ? list.get(p) : "*" + (list.get(p) + i));
        }
        System.out.println();

    }

    //  判断是否连续，并且相乘后能否整除
    private static boolean judge(List<Long> list, int i, int j, long num) {
        long ans = list.get(i);
        for (int k = i + 1; k <= j; k++) {
            if (list.get(k - 1) + 1 != list.get(k)) {
                return false;
            }
            ans *= list.get(k);
        }
        if (num % ans == 0)
            return true;
        return false;
    }
}
