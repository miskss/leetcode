package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author peter
 * date 2021/2/3 17:15
 */
public class Lesson_12 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            int a = nums[i];
            if (i > 0 && a == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                int b = nums[j];
                if (j > i + 1 && b == nums[j - 1]) continue;
                int l = j + 1, r = nums.length - 1;
                for (; l < nums.length - 1; l++) {
                    if (l > j + 1 && nums[l] == nums[l - 1]) continue;
                    int c = nums[l];
                    if (a + b + c + nums[r] < target) {
                        continue;
                    }
                    while (r > l && a + b + c + nums[r] > target) {
                        --r;
                    }
                    if (r == l) continue;
                    int sum = a + b + c + nums[r];
                    if (sum != target) continue;
                    List<Integer> ls = new ArrayList<>();
                    ls.add(a);
                    ls.add(b);
                    ls.add(c);
                    ls.add(nums[r]);
                    lists.add(ls);
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
