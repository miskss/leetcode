package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author peter
 * date 2021/2/2 16:29
 */
public class Lesson_9 {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            int a = nums[i];
            // 需要和上一次枚举的数不相同
            if (i > 0 && a == nums[i - 1]) {
                continue;
            }
            if (a > 0) break;
            int target = -a;
            int right = nums.length - 1, left = i + 1;
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                if (j > left && nums[j - 1] == b) {
                    continue;
                }
                while (b + nums[right] > target && j < right) {
                    --right;
                }
                if (j >= right) break;
                if (b + nums[right] == target) {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(a);
                    list.add(b);
                    list.add(nums[right]);
                    lists.add(list);
                    --right;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});

    }
}
