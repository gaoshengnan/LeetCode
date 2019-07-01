package highFrequencyLeetcode.leetcode_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * </p>
 *
 * @author Seina
 * @version 2019-06-11 23:20:25
 */
public class ThreeSum {

    /**
     * 解法2
     *
     * 排序 + 双指针 + 去重
     *
     * 时间复杂度：O(n²)
     * 空间复杂度：O(n)
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // 去掉重复的起点，继续下一轮循环
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1])
                        left++; // 去掉重复的左点
                    while (left < right && nums[right] == nums[right - 1])
                        right--; // 去掉重复的右点
                    right--; // 进入下一组左右点判断
                    left++;
                } else if (sum > 0) {
                    right--; // sum>0 ,说明和过大了，需要变小，所以向左移动右边指针
                } else {
                    left++; // 同理，需要变大，向右移动左指针
                }
            }
        }
        return result;
    }
}
