package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author peter
 * date 2021/2/3 15:03
 */
public class Lesson_11 {


    public static List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) return new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> ls = new ArrayList<>();
        for (char aChar : digits.toCharArray()) {
            String s = map.get(aChar);
            char[] chars = s.toCharArray();
            if (ls.size() == 0) {
                for (char c : chars) {
                    ls.add(String.valueOf(c));
                }
            } else {
                List<String> temp = new ArrayList<>(ls.size() * chars.length);
                for (String l : ls) {
                    for (char c : chars) {
                        temp.add(l + c);
                    }
                }
                ls = temp;
            }
        }
        return ls;
    }

    public static List<String> letterCombinationsImprove(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] strs = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //1.先算出一共有几种
        int len = 1;
        for (int i = 0; i < digits.length(); i++) {
            int c = digits.charAt(i) - '0';
            len *= strs[c].length();
        }

        //再用求余方法拿到每一种
        for (int i = 0; i < len; i++) {
            int last = i;
            StringBuilder sb = new StringBuilder();
            for (int j = digits.length() - 1; j >= 0; j--) {
                int c = digits.charAt(j) - '0';
                int pos = last % strs[c].length();
                sb.append(strs[c].charAt(pos));
                last = last / strs[c].length();
            }
            result.add(sb.reverse().toString());
        }


        return result;
    }

    public static List<String> letterCombinations11(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }


    public static void main(String[] args) {
        String digits = "23345679784323";
        long l = System.currentTimeMillis();
        List<String> strings = letterCombinations(digits);
        long l1 = System.currentTimeMillis();
        List<String> strings1 = letterCombinationsImprove(digits);
        long l2 = System.currentTimeMillis();
        List<String> strings2 = letterCombinations11(digits);
        long l3 = System.currentTimeMillis();
        System.out.println(l1-l);
        System.out.println(strings.size());
        System.out.println("===>");
        System.out.println(l2-l1);
        System.out.println(strings1.size());
        System.out.println("===>");
        System.out.println(l3-l2);
        System.out.println(strings2.size());
    }

}
