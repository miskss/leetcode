package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author peter
 * date 2021/1/29 17:17
 */
public class lesson_1 {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * 你可以按任意顺序返回答案。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] targets = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int len1 = len - 1; len1 > i; len1--) {
                if (nums[i] + nums[len1] == target) {
                    targets[0] = i;
                    targets[1] = len1;
                    return targets;
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> table = new HashMap<>(len - 1);
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int y = target - x;
            if (table.containsKey(y)) {
                return new int[]{table.get(y), i};
            }
            table.put(x, i);
        }
        return null;
    }

}
