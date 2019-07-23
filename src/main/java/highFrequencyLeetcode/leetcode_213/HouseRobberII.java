package highFrequencyLeetcode.leetcode_213;


/**
 * <p>
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 *  给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 *  示例 1:
 *
 *  输入: [2,3,2]
 *  输出: 3
 *  解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 *
 *  示例 2:
 *
 *  输入: [1,2,3,1]
 *  输出: 4
 *  解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * </p>
 *
 * @author Seina
 * @version 2019-07-21 23:26:18
 */
public class HouseRobberII {

    /**
     * 解法1 动态规划
     *
     * 解题思路类似打家劫舍 198，此题在基础上对首尾特殊处理
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums：每个房间现金数
     * @return 可偷最大值
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len < 2) return nums[0];
        int[] dpFirst = new int[len + 1];
        int[] dpSecond = new int[len + 1];

        //dp[i]，如果 i = 1，表示偷第一个累积的最大值
        dpFirst[0] = 0;
        dpFirst[1] = nums[0];//偷第一个
        dpSecond[0] = 0;
        dpSecond[1] = 0;//不偷第一个
        for (int i = 2; i <= len; i++) {
            dpFirst[i] = Math.max(dpFirst[i - 1], dpFirst[i - 2] + nums[i - 1]);//偷第一个
            dpSecond[i] = Math.max(dpSecond[i - 1], dpSecond[i - 2] + nums[i - 1]);//不偷第一个
        }

        /**
         * dfFirst 简称 dpf， dpSecond 简称 dps
         * 例如 nums = {9，1,2,10,15}
         * dpf[0] = 0  dpf[1] = 9  dpf[2] = 9  dpf[3] = 11  dpf[4] = 19  dpf[5] = 26
         * dps[0] = 0  dps[1] = 0  dps[2] = 1  dps[3] = 2   dps[4] = 11  dps[5] = 17
         */
        return Math.max(dpFirst[len - 1], dpSecond[len]);//len - 1 表示第一个偷了，最后一个不能偷

    }
}
