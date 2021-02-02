package array;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 ture ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author peter
 * date 2021/2/2 11:37
 */
public class Lesson_6 {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) return false;
        String str = String.valueOf(x);
        int length = str.length();
        for (int i = 0; i <= length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome1(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        return rev == x || rev / 10 == x;
    }
}
