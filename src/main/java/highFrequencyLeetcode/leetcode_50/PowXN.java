package highFrequencyLeetcode.leetcode_50;

/**
 * <p>
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 *  示例 1:
 *
 *  输入: 2.00000, 10
 *  输出: 1024.00000
 *
 *
 *  示例 2:
 *
 *  输入: 2.10000, 3
 *  输出: 9.26100
 *
 *
 *  示例 3:
 *
 *  输入: 2.00000, -2
 *  输出: 0.25000
 *  解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 *  说明:
 *
 *
 *  -100.0 < x < 100.0
 *  n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * </p>
 *
 * @author Seina
 * @version 2019-06-26 07:07:09
 */
public class PowXN {

    /**
     * 解法1 快速幂 - 递归 - 分织
     *
     * 假设 n = 4, 如果计算 x⁴，只需要计算出 x²，然后 x⁴ = x² * x²
     * 假设 n = 5，如果计算 x⁵，也先计算出 x²，然后 x⁵ = x² * x² * x
     *
     * 时间复杂度：O(logn)
     * 空间复杂度：O(logn) 每一次计算都要存储 half = x ⁿ⁄² 的结果
     *
     * @param x：底数值
     * @param n：幂数值
     * @return 返回 xⁿ
     */
    public double myPow (double x, int n) {

        //如果 n 是负数，要求 【x 分之一】 的 n 次方
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fasPow(x, n);
    }

    private double fasPow (double x, int n) {

        //任何数的 0 次方都等于 1
        if (n == 0) return 1.0;

        // 5 / 2 = 2 -> 2 / 2 = 1 -> 1 / 2 = 0
        // 4 / 2 = 2 -> 2 / 2 = 1 -> 1 / 2 = 0
        // 所以无论奇数偶数，通过 n / 2 下坠，都会来到递归终止条件 n == 0
        double half = fasPow(x, n/2);

        // 然后通过判断当前所在层 n 是奇数还是偶数
        // 当前所在层: 它的下一层是遇到终止条件的那一层递归，half 等于那一层返回结果
        // 1 % 2 = 1 奇数
        // 2 % 2 = 0 偶数
        return n % 2 == 0 ? half * half : half * half * x;
    }
}
