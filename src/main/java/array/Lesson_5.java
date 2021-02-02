package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author peter
 * date 2021/2/1 16:51
 */
public class Lesson_5 {
    public static String convert(String s, int numRows) {
        if (s == null || s.length() == 0) return "";
        if (numRows <= 1) return s;
        int len = s.length();
        //存储器
        List<StringBuilder> builders = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            builders.add(new StringBuilder());
        }
        //计数器
        int count = 0, maxCount = numRows - 1,
                col = 0;//当前列
        boolean flag = false;//标志位
        for (int i = 0; i < len; i++) {
            char at = s.charAt(i);
            builders.get(count).append(at);
            if (count == maxCount) {
                flag = true;
                count--;
            } else if (count < maxCount) {
                if (count == 0) {
                    flag = false;
                }
                if (flag) {
                    count--;
                } else {
                    count++;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder builder : builders) {
            stringBuilder.append(builder);
        }
        return stringBuilder.toString();
    }

    public static String convertOptimize(String s, int numRows) {
        if (s == null || s.length() == 0) return "";
        if (numRows <= 1) return s;
        int len = s.length();
        //存储器
        List<StringBuilder> builders = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            builders.add(new StringBuilder());
        }
        //计数器
        int count = 0, maxCount = numRows - 1;
        boolean flag = false;//标志位
        for (int i = 0; i < len; i++) {
            char at = s.charAt(i);
            builders.get(count).append(at);
            if (count == 0 || count == maxCount) flag = !flag;
            count += flag ? 1 : -1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder builder : builders) {
            stringBuilder.append(builder);
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        System.out.println(convertOptimize("PAYPALISHIRING", 3));

    }
}
