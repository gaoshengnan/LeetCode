package highFrequencyLeetcode.leetcode_213;

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
         * 例如 nums = {9，1，2，10，15}
         * dpf[0] = 0  dpf[1] = 9  dpf[2] = 9  dpf[3] = 11  dpf[4] = 19  dpf[5] = 26
         * dps[0] = 0  dps[1] = 0  dps[2] = 1  dps[3] = 2   dps[4] = 11  dps[5] = 17
         */
        return Math.max(dpFirst[len - 1], dpSecond[len]);//len - 1 表示第一个偷了，最后一个不能偷

    }
}
