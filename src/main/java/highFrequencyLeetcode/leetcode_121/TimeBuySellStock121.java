package highFrequencyLeetcode.leetcode_121;

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
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * 题解方案topics：
 * array、dp
 *
 * @author li tong
 * @date 2019/6/8 15:25
 * @see Object
 * @since 1.0
 */
public class TimeBuySellStock121 {

  public static void main(String[] args) {

//    int[] prices = new int[]{7, 1};
//    int[] prices = new int[]{1, 7, 5};
//    int[] prices = new int[]{7, 6, 5};
    int[] prices = new int[]{7, 1, 5, 3, 6, 4};
    System.out.println(maxProfit(prices));

  }

  /**
   * @param prices
   * @return maximum profit
   */
  public static int maxProfit(int[] prices) {
    if (prices.length < 2) {
      return 0;
    }
    int dp = 0;
    int min = prices[0];
    for (int i = 1; i < prices.length; i++) {
      min = Math.min(prices[i], min);
      dp = Math.max(prices[i] - min, dp);
    }
    return dp;
  }

}
