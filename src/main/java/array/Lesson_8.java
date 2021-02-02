package array;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * @author peter
 * date 2021/2/2 15:55
 */
public class Lesson_8 {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (strs[0].length() > idx) {
            Character t = null;
            for (String str : strs) {
                if (str.length() <= idx || (t != null && str.charAt(idx) != t)) {
                    return sb.toString();
                }
                if (t == null)
                    t = str.charAt(idx);
            }
            sb.append(t);
            ++idx;
        }
        return sb.toString();
    }
}
