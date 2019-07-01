package highFrequencyLeetcode.leetcode_69;

/**
 * <p>
 *
 *  实现 int sqrt(int x) 函数。
 *
 *  计算并返回 x 的平方根，其中 x 是非负整数。
 *
 *  由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 *  示例 1:
 *
 *  输入: 4
 *  输出: 2
 *
 *
 *  示例 2:
 *
 *  输入: 8
 *  输出: 2
 *  说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * </p>
 *
 * @author Seina
 * @version 2019-06-27 22:42:59
 */
public class Sqrtx {

    /**
     * 解法1 二分查找
     *
     * 例如发现 x < m²，假设 x = 8，m = 3，m² = 9，那么要找的数 8 的平方根是 2.82842... = 2 一定在 3 的左边，弄掉了右边一半的数
     *
     * 总体来看匹配条件就是要找到一个符合这样条件的数：result² <= x <= (result + 1)²，那么 result 就是 x 的平方根
     *
     * 比如： 2² < 8 < 3²，2 就是 8 要找的平方根
     *
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     *
     * @param x：非负整数
     * @return x 的平方根
     */
    public static int mySqrt (int x) {
        if (x == 0) return 0;
        int l = 1, r = Integer.MAX_VALUE;
        while (true) {
            int m = l + (r - l) / 2;
            if (x / m < m)  r = m - 1; // x / m < m等同于 x < m²，这个时候说明 m 太大了，舍弃右半部分，直接进入左半部分继续匹配
            else {//如果 m² < x，在右半部分查找，一旦发现同时 x < (m + 1)² ，m 就是我们要找的值
                if (m + 1 > x / (m + 1)) return m;
                l = m + 1;//否则就是 (m + 1)² <= x，那么还得继续移动左指针 l
            }
        }
    }
}
