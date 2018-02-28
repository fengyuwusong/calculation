package problem28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

/**
 * Created by fengyuwusong on 2018/2/10 0:04.
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Main {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (str != null && str.length() > 0) {
            char[] chars = str.toCharArray();
            PermutationHelper(chars, 0, arrayList);
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    private static void PermutationHelper(char[] cs, int i, ArrayList<String> list) {
        if (i == cs.length - 1) { //解空间的一个叶节点
            list.add(String.valueOf(cs)); //找到一个解
        } else {
            for (int j = i; j < cs.length; ++j) {
                if (j == i || cs[j] != cs[i]) {
                    swap(cs, i, j);
                    PermutationHelper(cs, i + 1, list);
                    swap(cs, i, j); //复位
                }
            }
        }
    }

    private static void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.Permutation("ABC");
        LinkedHashMap<String,String> treeMap=new LinkedHashMap<>();
        treeMap.put(null,"?");
    }
}
