package problem35;

/**
 * Created by fengyuwusong on 2018/3/1 10:51.
 * 第一次只出现一次的字符
 * 题目描述
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置。
 * <p>
 * 思路：
 * 解法1：穷举法
 * 解法2：使用哈希表。第一次遍历先记录每个字符出现的次数，第二次遍历找出第一个只出现一次的字符。
 * char的长度为8字节，故由char组成的String共有2的8次方=256种可能，可以创建一个容量为256的int数组记录每个字符的出现次数。
 */
public class Main {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
//        创建哈希表
        int tableSize = 256;
        int[] hashTable = new int[tableSize];
        for (int i = 0; i < tableSize; i++) {
            hashTable[i] = 0;
        }
        char[] chars = str.toCharArray();
        for (char c : chars) {
            hashTable[c]++;
        }
//        需要重新遍历String，找出第一个为1的字符，不能遍历哈希表，因为顺序可能不对
        int i=0;
        for (char c : chars) {
            if (hashTable[c]==1){
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Main main=new Main();
        System.out.println(main.FirstNotRepeatingChar("1232346312"));
    }
}
