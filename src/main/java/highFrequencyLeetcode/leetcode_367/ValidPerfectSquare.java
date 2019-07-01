package highFrequencyLeetcode.leetcode_367;

/**
 * <p>
 *
 *  给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 *  说明：不要使用任何内置的库函数，如 sqrt。
 *
 *  示例 1：
 *
 *  输入：16
 *  输出：True
 *
 *  示例 2：
 *
 *  输入：14
 *  输出：False
 *
 * </p>
 *
 * @author Seina
 * @version 2019-06-28 19:59:18
 */
public class ValidPerfectSquare {

    /**
     * 解法1 二分法
     *
     * 在有序的数据范围内二分搜索 num 的完全平方根
     *
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     *
     * @param num：正整数
     * @return num 的完全平方根
     */
    public static boolean isPerfectSquare(int num) {
        if (num <= 0) return false;
        int l = 1, r = num;
        while (l < r) {
            int m = l + (r - l) / 2 + 1;
            if (num / m >= m) l = m;
            else r = m - 1;
        }
        return l * l == num;
    }

    /**
     * 解法2 牛顿迭代法
     *
     * 使用牛顿迭代法推出 x + num / x 公式 带入代码中
     *
     * @param num：正整数
     * @return num 的完全平方根
     */
    public static boolean isPerfectSquare2(int num) {//16
        long x = num;
        //x² > m 就不停循环，逐渐减小 x
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        //x² <= m 的时候退出循环
        return x * x == num;
    }
}
