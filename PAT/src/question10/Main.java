package question10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by fengyuwusong on 2018/3/9 22:35.
 * L1-010. 比较大小
 * 本题要求将输入的任意3个整数从小到大输出。
 * 输入格式：
 * 输入在一行中给出3个整数，其间以空格分隔。
 * 输出格式：
 * 在一行中将3个整数从小到大输出，其间以“->”相连。
 * 输入样例：
 * 4 2 8
 * 输出样例：
 * 2->4->8
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>(3);
        for (int j = 0; j < 3; j++) {
            nums.add(scanner.nextInt());
        }
        Collections.sort(nums);
        for (int i = 0; i < 3; i++) {
            System.out.print(i == 0 ? nums.get(i) : "->" + nums.get(i));
        }
    }
}
