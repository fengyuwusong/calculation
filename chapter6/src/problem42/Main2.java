package problem42;

/**
 * Created by fengyuwusong on 2018/3/2 23:03.
 * 翻转单词顺序
 * 题目描述
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * <p>
 * 思路：
 * 同上题，找规律。"I am a student." ->"student. a am I" 可以发现是经过以下步骤得出的：
 * 1. 先将所有字符翻转得到.tneduts a ma I
 * 2. 再分别将每个单词翻转得到 student. a am I
 */
public class Main2 {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0)
            return "";
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);
//        翻转每个单词
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }
//        因为最后一个单词没有空格间隔 将最有一个单词翻转回去
        reverse(chars, start, chars.length - 1);
        return String.valueOf(chars);
    }

    //    翻转函数
    public void reverse(char[] chars, int start, int end) {
        if (chars == null || chars.length == 0 || chars.length - 1 < end || start > end)
            return;
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        System.out.println(main2.ReverseSentence("I am a student."));
        System.out.println(main2.ReverseSentence("Wonderful"));
        System.out.println(main2.ReverseSentence("Hello World!"));
    }
}
