package array;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * @author peter
 * date 2021/2/2 15:08
 */
public class Lesson_7 {

    public static int maxArea(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int area = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int tempArea = (j - i) * Math.min(height[i], height[j]);
                area = Math.max(tempArea, area);
            }
        }
        return area;
    }

    /**
     * 优化双端指针
     *
     * @param height
     * @return
     */
    public static int maxAreaOptimize(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int left = 0, right = height.length - 1, area = 0;
        while (left < right) {
            int tempArea = (right - left) * Math.min(height[right], height[left]);
            area = Math.max(tempArea, area);
            if (height[right] > height[left]) {
                left++;
            } else if (height[right] < height[left]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return area;
    }

    public static void main(String[] args) {

        int x = maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        int x1 = maxAreaOptimize(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(x);
        System.out.println(x1);
    }
}
