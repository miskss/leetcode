package array;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * @author peter
 * date 2021/2/3 9:53
 */
public class Lesson_10 {

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        Integer closest = null;
        for (int i = 0; i <= nums.length - 3; i++) {
            int a = nums[i];
            for (int j = i + 1; j <= nums.length - 2; j++) {
                int b = nums[j];
                Integer temp = null;
                for (int k = j + 1; k < nums.length; k++) {
                    int c = nums[k];
                    int sum = a + b + c;
                    if (temp == null) {
                        temp = sum;
                        continue;
                    }
                    int abs = Math.abs(target - sum);
                    if (abs == 0) {
                        return sum;
                    }
                    int close = Math.abs(target - temp);
                    if (close > abs) {
                        temp = sum;
                    } else {
                        if (sum > 0)
                            break;
                    }
                }
                if (closest == null || Math.abs(target - closest) > Math.abs(target - temp)) {
                    closest = temp;
                }
            }
        }
        return closest;
    }

    public static int threeSumClosestImprove(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int close = nums[0] + nums[1] + nums[2];//最接近的值
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int a = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                int sum = a + b + c;
                if (sum == target) return sum;
                if (Math.abs(target - close) > Math.abs(target - sum)) {
                    close = sum;
                }
                if (sum > target) {
                    --right;
                    while (left < right && c == nums[right]) {
                        --right;
                    }
                } else {
                    ++left;
                    while (left < right && b == nums[left]) {
                        ++left;
                    }
                }
            }
        }

        return close;

    }


    public static void main(String[] args) {
        int i = threeSumClosestImprove(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82);
        System.out.println(i);
        System.out.println(threeSumClosestImprove(new int[]{-1, 2, 1, -4}, 1));
    }

}
