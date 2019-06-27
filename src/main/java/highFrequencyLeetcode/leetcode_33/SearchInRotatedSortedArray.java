package highFrequencyLeetcode.leetcode_33;

/**
 * <p>
 *
 *  假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 *  ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 *  搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 *  你可以假设数组中不存在重复的元素。
 *
 *  你的算法时间复杂度必须是 O(log n) 级别。
 *
 *  示例 1:
 *
 *  输入: nums = [4,5,6,7,0,1,2], target = 0
 *  输出: 4
 *
 *
 *  示例 2:
 *
 *  输入: nums = [4,5,6,7,0,1,2], target = 3
 *  输出: -1
 *
 * </p>
 *
 * @author Seina
 * @version 2019-06-27 20:44:33
 */
public class SearchInRotatedSortedArray {

    /**
     * 解法1 二分法（指针遍历）
     *
     * 注意：有序数组旋转后，总是有一半数组是有序的
     *
     * 外层 if 判断用于锁定有序的半部分，内层的 if 用于锁定 target 是否在有序的部分，一次类推，直到 l 和 r 相遇
     *
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     *
     * @param nums：有序数组在翻转之后的数组
     * @param target：搜索的元素
     * @return 返回 target 的索引下表或者 -1
     */
    public int search (int[] nums, int target) {
        if (nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;//l: 左指针 r: 右指针
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[l] <= nums[m]) {//说明左半部分 l - m 有序
                if (target >= nums[l] && target <= nums[m]) r = m; //锁定 target 在 l - m 之间，移动 r 到 m 位置
                else l = m + 1;//否则在 m - r 之间，移动 l 到 m + 1
            }
            else {//否则右半部分 m - r 有序
                if (target > nums[m] && target <= nums[r]) l = m + 1; //锁定 target 在 m - r 之间，移动 l 到 m + 1 位置
                else r = m; //否则在 l - m 之间，移动 r 到 m 的位置
            }
        }
        return nums[l] == target ? l : -1;
    }
}
