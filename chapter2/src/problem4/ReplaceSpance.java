package problem4;

/**
 * 题目： 替换空格
 * 请实现一个函数，吧字符串中的每个空格替换成 “%20”。例如输入 “We are happy.” ， 这输出“We%20arehappy.”。(不使用replace&insert方法和必须在原串中改变)
 * Created by fengyuwusong on 2018/1/16 14:57.
 */
public class ReplaceSpance {
    //    复杂度O(n²)，遍历所有字符并添加后移动(不推荐)
    public static StringBuilder replace1(StringBuilder target) {
        if (target == null) {
            return null;
        }
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == ' ') {
                StringBuilder template = new StringBuilder(target);
                //改变原来String的长度，增加2
                target.setLength(target.length() + 2);
                target.setCharAt(i, '%');
                target.setCharAt(i + 1, '2');
                target.setCharAt(i + 2, '0');
                for (int j = i + 3; j < target.length(); j++) {
                    target.setCharAt(j, template.charAt(j - 2));
                }
                i += 2;
            }
        }
        return target;
    }

    //    复杂度O(n)，先记录空格个数在进行替换移动。
    public static StringBuilder replace2(StringBuilder target) {
        if (target == null) {
            return null;
        }
//        记录空格个数
        int spaceNum = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == ' ') {
                spaceNum++;
            }
        }
//        以前下标
        int oldIndex = target.length() - 1;
//        新的长度
        int newLength = target.length() + spaceNum * 2;
//        新下标
        int newIndex = newLength - 1;
        target.setLength(newLength);
//        这里注意:
//          1.循环是从后往前，这样可以避免重复移动
//          2.判断条件：oldIndex < newIndex && newIndex >= 0 则无需全部遍历，若oldIndex<newIndex则代表所有空格已经被替换
        for (; oldIndex < newIndex && newIndex >= 0; oldIndex--) {
            if (target.charAt(oldIndex) == ' ') {
//                这里由于是从后向前循环，所以插入字符也应该倒插
                target.setCharAt(newIndex--, '0');
                target.setCharAt(newIndex--, '2');
                target.setCharAt(newIndex--, '%');
            } else {
                target.setCharAt(newIndex--, target.charAt(oldIndex));
            }
        }

        return target;
    }


    public static void main(String[] args) {
//        编写测试用例
//        第一个方法
//        开头空
        System.out.println(replace1(new StringBuilder(" 2354")));
//        结尾空
        System.out.println(replace1(new StringBuilder("2345 ")));
//        中间空
        System.out.println(replace1(new StringBuilder("23 56")));
//        全部情况一起
        System.out.println(replace1(new StringBuilder(" 2 34 ")));
//        空
        System.out.println(replace1(null));
        System.out.println(replace1(new StringBuilder("")));
//        单独空格
        System.out.println(replace1(new StringBuilder(" ")));
//        连续空格
        System.out.println(replace1(new StringBuilder("   ")));
        System.out.println("----------------------");
//        第二个
//        开头空
        System.out.println(replace2(new StringBuilder(" 2354")));
//        结尾空
        System.out.println(replace2(new StringBuilder("2345 ")));
//        中间空
        System.out.println(replace2(new StringBuilder("23 56")));
//        全部情况一起
        System.out.println(replace2(new StringBuilder(" 2 34 ")));
//        空
        System.out.println(replace2(null));
        System.out.println(replace2(new StringBuilder("")));
//        单独空格
        System.out.println(replace2(new StringBuilder(" ")));
//        连续空格
        System.out.println(replace2(new StringBuilder("   ")));
    }

}
