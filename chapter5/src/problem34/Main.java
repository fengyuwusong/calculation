package problem34;

import java.util.ArrayList;

/**
 * Created by fengyuwusong on 2018/2/28 21:36.
 * 丑数
 * 题目描述
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * <p>
 * 思路：
 * 解法1：因子即整除，取余为0。只包含因子2,3,5说明当对三者取余=0时可以不停对三者做除法，当最后的结果为1时说明这个数是丑数。
 * 可以使用穷举法。
 * <p>
 * 解法2：既然丑数的因子只有2,3,5 那可以从1出发，获取其他丑数，该解法的关键是得出的丑数必须是按顺序的保存进数组内。
 * 如果要顺序找出丑数，要知道下面几个特点。
 * 对于任何丑数p：
 * （一）那么2*p,3*p,5*p都是丑数，并且2*p<3*p<5*p
 * （二）如果p < q, 那么2*p<2*q,3*p<3*q,5*p<5*q
 * 即我们可以从1开始 获得丑数 2 3 5  然后选取最小的丑数2，  又可以获得丑数 4 6 10
 * 并且与之前的未选上的丑数一起做比较min(3,5,4,6,10)。如此循环。
 * 这种做法并不好，我们换一种方法。
 * 既然p< q,则2*p<2*q,3*p<3*q,5*p<5*q，说明p都还没选上，则无需将q放进去比较，我们可以给2,3，5三个位置做定位，例如
 * m2=0,m3=0,m5=0 //所有都初始化为在数组索引0的位置，最初的丑数1
 * 当比较 三者分别*2 3 5之后的数后得出最小丑数，添加进数组，索引为1，由于*2最小，所以更新m2+1=1。
 * 第二轮比较：
 * 由于m2=1 ,则选取 2*2  1*3 1*5 进行比较，获得最小丑数3，将3存入数组，索引为2，m3+1=1
 * 。。。
 * 如此则只需比较三个数据则可获得最小丑数。
 */
public class Main {
    //    解法2
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (arrayList.size() < index) {
            int m2 = arrayList.get(i2) * 2;
            int m3 = arrayList.get(i3) * 3;
            int m5 = arrayList.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            arrayList.add(min);
//            有可能m2 m3 m5相等，不能使用else
            if (m2 == min) i2++;
            if (m3 == min) i3++;
            if (m5 == min) i5++;
        }
        return arrayList.get(arrayList.size() - 1);
    }

    //    判断是否为丑数
    boolean isUgly(int number) {
        while (number % 2 == 0)
            number /= 2;
        while (number % 3 == 0)
            number /= 3;
        while (number % 5 == 0)
            number /= 5;
        return number == 1;
    }
}
