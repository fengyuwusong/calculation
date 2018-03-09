package problem51;

/**
 * Created by fengyuwusong on 2018/3/3 22:25.
 * 数组中重复的数字
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * <p>
 * 思路：
 * 解法1：哈希记录
 * 解法2：排序后前后相减
 * 解法3：由于数组长度都在0到n-1的范围，如果数组没有重复数字，那么排序之后的数字将会出现在对应的下标i位置，
 * 由于数组有重复数字，也可能有多对，所以可能有些位置没有数字
 * 所以我们可以按照该特点进行数组重排。例如数组{2,3,1,0,2,5,3}
 * 1. 按照上述规律，下标0的值应该为0，2与下标值不等。判断其与下标2的值相不相等，2与1不等，将其与下标值为2的数字替换，得到数组{1,3,2,0,2,5,3}
 * 2. 同上，1与0不等，1与3不等，替换得到{3,1,2,0,2,5,3}
 * 3. 同上，替换得到 {0,1,2,3,2,5,3}
 * 4. 相等后索引向前移动，移动至下标为4的2，发现索引2已经有对应的值，则第一个重复的是2
 */
public class Main {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length < 2)
            return false;
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    private void swap(int[] numbers, int i, int number) {
        int temp = numbers[i];
        numbers[i] = numbers[number];
        numbers[number] = temp;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] res = new int[1];
        main.duplicate(new int[]{2, 3, 1, 0, 2, 5, 3}, 7, res);
        System.out.println(res[0]);
    }
}
