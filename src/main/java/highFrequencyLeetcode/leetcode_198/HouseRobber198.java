package highFrequencyLeetcode.leetcode_198;

/**
 * Easy
 * (注解文档查看快捷键 选中类名或方法名 按ctrl + Q)
 * <p>
 * 思维全过程记录方案：<p>
 * 1 背基础结构和算法      | 记录在课程笔记<p>
 * 2 看题 -> 悟题 思考过程 | 记录在wiki<p>
 * 3 悟题 -> 写题 实现难点 | 记录在代码注解<p>
 * 4 写题 -> 优化 多种解法 | 记录在leetcode提交
 * <p>
 * 问题：
 * Given n non-negative integers representing an elevation map 
 * where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * <p>
 * 题解方案topics：
 * dp
 *
 * @author li tong
 * @date 2019/6/7 9:41
 * @see Object
 * @since 1.0
 */
public class HouseRobber198 {

  public static void main(String[] args) {
    int[] test = new int[]{2, 7, 1, 4, 9, 3};
    System.out.println(rob(test));
  }

  /**
   * 解法1 dp<p>
   * 看题解，主干思路：<p>
   * &nbsp;&nbsp; DP用来记录结果<p>
   * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
   * &nbsp;&nbsp; 对每个屋子来说 不关心后面的所有情况 只要保证自己和前后不相邻
   * 可以有一个子函数专门处理相邻问题
   * 暴力法 把所有可用的路径找出来 并计算结果 然后比较
   * 如 2 1 9 | 2 1 3 | 2 4 3 | 2 9 | 2 3 || 7 。。。
   * dp法 只记录总和
   * 思考DP时失败的误区
   * 1 不用计算过程 因为此题只要结果
   * 2 没有简化问题并求解前几步
   * 3 没有倒推 如果倒推就很容易得到DP方程
   * max(fn-1, fn-2 + n) + fn-1 ? fn+1 : fn
   *
   * @param nums
   * @return
   */
  static int rob(int[] nums) {
    int res = 0;
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return nums[0];
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      System.out.println(dp[i - 2]);
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
      System.out.println("AFTER" + dp[i]);
      System.out.println();
    }
    return dp[nums.length - 1];
  }

}
