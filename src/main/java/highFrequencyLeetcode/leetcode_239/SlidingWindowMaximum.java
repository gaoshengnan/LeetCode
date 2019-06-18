package highFrequencyLeetcode.leetcode_239;

/**
 * <p>
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 *
 *  返回滑动窗口最大值。
 *
 *  示例:
 *
 *  输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * 
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *  注意：
 *
 *  你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
 *
 *  进阶：
 *
 *  你能在线性时间复杂度内解决此题吗？
 *
 * </p>
 * @author Seina
 * @version 2019-06-16 22:18:03
 */
public class SlidingWindowMaximum {


    /**
     * 
     * 循环内，先给当前窗口赋值，然后开始求下一个窗口最大值
     *
     * 时间复杂度：最坏 O(n²) 最好 O(n)
     * 空间复杂度：O(1)
     * 
     * @param nums
     * @param k 窗口大小
     * @return 滑动过程中的每个窗口最大元素集合
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) return new int[]{};
        //length - k + 1: 随着滑动窗口的移动，result 数组可以装多少个最大值
        int[] result = new int[length - k + 1];
        //得到窗口第一次所在位置最大值
        int max = findMax(nums, 0, k - 1);
        for (int i = 0, j = k; j < length; i++, j++) {
            //结果下标 = 移动窗口的开始元素下标
            result[i] = max;

            //nums[i] 表示将要挪掉的元素，如果是上一个窗口的 max，那么就重新找一个 max（查找范围不包含即将加入的元素）
            if (nums[i] == max) {
                max = findMax(nums, i + 1, j);
            //nums[j] 表示即将要加进来的元素，如果它比上一个窗口 max 还要大，那么直接替换 max
            } else if (nums[j] > max) {
                max = nums[j];
            }
            //如果即将挪掉的元素比上一个窗口 max 还小，新增的元素也没有 max 大，那么直接 max值不变，直接滑倒下一个窗口位置
        }
        //给最后一个窗口赋值
        result[length - k] = max;
        return result;
    }
    /**
     * 
     * 返回窗口中最大值
     * 
     * @param nums 
     * @param i: 窗口左边界
     * @param j: 窗口右边界
     * @return 窗口中最大值
     */
    private int findMax(int[] nums, int i, int j){
        int max = Integer.MAX_VALUE;
        for (int m = i; m < j; m++) max = Math.max(max, nums[m]);
        return max;
    }
}
