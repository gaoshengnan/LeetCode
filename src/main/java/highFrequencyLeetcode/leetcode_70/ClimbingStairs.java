package highFrequencyLeetcode.leetcode_70;

/**
 *
 * <p>
 *
 *  假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 *  每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 *  注意：给定 n 是一个正整数。
 *
 *  示例 1：
 *
 *  输入： 2
 *  输出： 2
 *  解释： 有两种方法可以爬到楼顶。
 *  1.  1 阶 + 1 阶
 *  2.  2 阶
 *
 *  示例 2：
 *
 *  输入： 3
 *  输出： 3
 *  解释： 有三种方法可以爬到楼顶。
 *  1.  1 阶 + 1 阶 + 1 阶
 *  2.  1 阶 + 2 阶
 *  3.  2 阶 + 1 阶
 *
 * </p>
 *
 * @author Seina
 * @version 2019-04-09 22:15:25
 *
 */
public class ClimbingStairs {

    /**
     * 解法1 暴力法
     * 时间复杂度： O(2ⁿ) 树形递归总节点数
     * 空间复杂度： O(n) 树的深度
     * 
     * 这种暴力破解会超出时间限制，显然不是我们想要的，但是可以理解一下代码
     * 多实践递归代码：找到一级递归，再找到终止条件，并拒绝在中间过程进行人肉递归
     */
    public int climbingStairs1(int n) {
        return climb1(0, n);
    }

    /**
     * 递归模拟爬楼梯在每层每次走一步或者两步的所有情况
     * 
     * @param i：当前台阶数
     * @param n：总的台阶数
     * @return 总共有多少种走法
     */
    private int climb1(int i, int n) {
        //表示当前台阶数大于总台阶数，很显然这种情况不符合，走不通，记为 0
        if (i > n) {
            return 0;
        }
        //表示当前台阶数正好等于总的台阶数，那么这种情况符合，记为 1
        if (i == n) {
            return 1;
        }
        //总的可能性主要取决于在 0 层的时候迈 1 步还是迈 1 步
        //举例一共有 2 个台阶
        //我先迈 2 步，（2，2），退出递归返回 1
        //或者我先迈 1 步，(1,2)，来到第 1 层台阶，再迈 1 步（2，2），退出循环返回 1；也可以再迈 2 步，（3，2），退出循环返回 0 
        //所以当台阶数为 2 时，有两种走法，（2，2）或 （1，2）-> (2,2)
        return climb1(i + 1, n) + climb1(i + 2, n);
    }


    /**
     * 解法2 记忆化递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 
     * @param n：台阶总数
     * @return 总共多少种走法
     */
    public int climbStairs2(int n) {
        int memo[] = new int[n + 1];
        return climb2(0, n, memo);
    }

    private int climb2(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        //也可以理解成是 i < n
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb2(i + 1, n, memo) + climb2(i + 2, n, memo);
        return memo[i];
    }


    /**
     * 解法3 动态规划
     * 时间复杂度：O(n) 单循环到 n
     * 空间复杂度：O(n) dp 数组用了 n 空间
     * 
     * 到达第 i 阶的方法总数 = 第 i -1 阶方法数 + 第 i -2 阶方法数
     */
    public int climbStairs3(int n) {
        if ( n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i -2];
        }
        return dp[n];
    }

    /**
     * 解法4 斐波那契数
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int climbStairs4(int n) {
        if ( n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    
}
