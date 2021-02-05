package array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author peter
 * date 2021/2/4 9:50
 */
public class Lesson_14 {

    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) return false;
        String left = "({[";
        String right = ")}]";
        char[] chars = s.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        for (char c : chars) {
            int r = right.indexOf(c);
            if (r >= 0) {
                //右边
                if (deque.isEmpty()) return false;
                char c1 = left.charAt(r);
                Character pop = deque.pop();
                if (c1 != pop) {
                    return false;
                }
            } else {
                deque.push(c);
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[{}]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("[[[]"));
        System.out.println(isValid("[({])}"));
        System.out.println(isValid("[{{}}]"));
    }

}
