package array;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author peter
 * date 2021/2/1 11:52
 */
public class Lesson_3 {

    //滑动窗口
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;//最长子串长度
        int left = 0;//滑动窗口左下标，i相当于滑动窗口右下标
        for (int i = 0; i < len; i++) {
            //当发现重复元素时
            if (map.containsKey(s.charAt(i))) {
                //窗口左指针右移==>到重复元素的下一位
                left = Math.max(left, map.get(s.charAt(i)) + 1);
                //当之前找出的子串的最大长度 >= 现左指针到字符串尾部的长度,即：左指针与右指针的最大值{(len-1) - left + 1}差值 则不需要在比较了，已经是最大串了
                if (max >= len - left) {
                    return max;
                }
            }
            map.put(s.charAt(i), i);      //再更新map中映射的下标
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("sajargapa"));
    }
}
