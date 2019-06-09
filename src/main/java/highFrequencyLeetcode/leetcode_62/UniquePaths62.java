package highFrequencyLeetcode.leetcode_62;

/**
 * Medium
 * (注解文档查看快捷键 选中类名或方法名 按ctrl + Q)
 * <p>
 * 思维全过程记录方案：<p>
 * 1 背基础结构和算法      | 记录在课程笔记<p>
 * 2 看题 -> 悟题 思考过程 | 记录在wiki<p>
 * 3 悟题 -> 写题 实现难点 | 记录在代码注解<p>
 * 4 写题 -> 优化 多种解法 | 记录在leetcode提交
 * <p>
 * 题解方案topics：
 * array、dp
 *
 * @author li tong
 * @date 2019/6/4 11:36
 * @see Object
 * @since 1.0
 */
public class UniquePaths62 {

    /**
     * 观察时间复杂度
     */
    private static int count = 0;

    public static void main(String[] args) {
        System.out.println(recursive(0, 0));
        System.out.println(recursive(1, 1));
        System.out.println(recursive(1, 2));
        System.out.println(recursive(2, 2));
        System.out.println(recursive(3, 2));
        System.out.println(recursive(3, 3));
        System.out.println("RECURSIVE=" + recursive(10, 10));
        System.out.println();

        System.out.println("RECURSIVE_MEM=" + recursiveMem(10, 10, new int[11][11]));
        System.out.println();

        System.out.println("TRY_DP_ONE=" + tryDPOne(10, 10));
        System.out.println();

        System.out.println("[LC PASS]DP_ONE=" + dpOne(51, 9));
        System.out.println();

        System.out.println("[LC PASS]DP_TWO=" + dpTwo(10, 10));
        System.out.println();

        System.out.println("[LC PASS]MATH=" + math(23, 12));
        System.out.println("Count=" + count);
    }

    /**
     * 解法1 递归<p>
     * 注：本解法时间复杂度高，无法通过leetcode(在较大参数时超时)，
     * 但是，是一种可以求得正解的解法和推理的重要思路，故保留方法
     * <p>
     * 自己思考，主干思路：<p>
     * &nbsp;&nbsp;脑图图像<p>
     * 1  1  1  1<p>
     * 1  2  3  4<p>
     * 1  3  6 10 15<p>
     * +  +  +  +<p>
     * 3  6 10 15<p>
     * + 3  4  5<p>
     * <p>
     * &nbsp;&nbsp;总结规律，发现：f(m,n) = f(m-1,n) + f(m,n-1)
     *
     * @param m 棋盘长度
     * @param n 棋盘高度
     * @return
     */
    public static int recursive(int m, int n) {
        count++;
        if (m < 1 || n < 1) {
            return 0;
        } else if (m == 1 || n == 1) {
            return 1;
        }
        return recursive(m - 1, n) + recursive(m, n - 1);
    }

    /**
     * 解法2 缓存递归<p>
     * 注：同样因为加了参数无法通过leetcode提交，但是可以求得正解，
     * 也是承前启后的推理思路，同时温习老师介绍的缓存思想，故保留
     *
     * @param m
     * @param n
     * @param mem
     * @return
     */
    public static int recursiveMem(int m, int n, int[][] mem) {
        count++;
        if (m < 1 || n < 1) {
            return 0;
        } else if (m == 1 || n == 1) {
            return 1;
            // if (mem[m][n] == 0)非常重要 表示只有=0 才递归计算 否则就走缓存
        } else if (mem[m][n] == 0) {
            mem[m][n] = recursiveMem(m - 1, n, mem) + recursiveMem(m, n - 1, mem);
        }
        return mem[m][n];
    }

    /**
     * 解法3 伪DP<p>
     * 注：<p>
     * 1.没有缓存，无法通过leetcode提交，实质和解法1相同<p>
     * 2.是从递归过渡到DP的尝试过程，试图寻找DP方程，故保留
     *
     * @param m
     * @param n
     * @return
     */
    public static int tryDPOne(int m, int n) {
        count++;
        int[][] dp = new int[m + 1][n + 1];
        if (m < 1 || n < 1) {
            return 0;
        } else if (m == 1 || n == 1) {
            return 1;
            // f22 = dp11 == 0 -> dp11 = f12 + f21 = 2
        } else if (dp[m][n] == 0) {
            dp[m][n] = tryDPOne(m - 1, n) + tryDPOne(m, n - 1);
        }
        return dp[m][n];
    }

    /**
     * 解法4 伪DP 不可用<p>
     * 注：<p>
     * 1.没找到循环公式，结果错误<p>
     * 2.是从递归过渡到DP的尝试过程，试图寻找DP方程，故保留
     * @param m
     * @param n
     * @return
     */
    public static int tryDPTwo(int m, int n) {
        count++;
        int[][] dp = new int[m + 1][n + 1];
        if (m < 1 || n < 1) {
            return 0;
        } else if (m == 1 || n == 1) {
            return 1;
            // f22 = dp11 == 0 -> dp11 = dp01 + dp10
        } else if (dp[m][n] == 0) {
            dp[m][n] = dp[m - 1][n] + dp[m - 1][n - 1];
        }
        return dp[m][n];
    }

    /**
     * 解法5 DP 已通过leetcode提交<p>
     * 自己思考结合题解提示，主干思路：<p>
     * &nbsp;&nbsp;1.经过解法3、4的尝试，发现DP实现主路径<p>
     * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
     * &nbsp;&nbsp;1 从递归到DP，不知道for循环怎么写<p>
     * &nbsp;&nbsp;2 循环内的判断条件<p>
     * @param m
     * @param n
     * @return
     */
    public static int dpOne(int m, int n) {
        count++;
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    // f22 = dp11 == 0 -> dp11 = dp01 + dp10
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
//                    System.out.print("i" + i);
//                    System.out.print(", j" + j + ", ");
//                    System.out.println(dp[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 解法6 DP优化 已通过leetcode提交<p>
     * 注：实际复杂度提升效果有限(leetcode已验证)，只是代码层面看起来简洁了一些<p>
     * 看题解，提取主干思路：<p>
     * &nbsp;&nbsp;将二维DP降为一维<p>
     * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
     * &nbsp;&nbsp;1.想不到降维<p>
     * &nbsp;&nbsp;2.降维之后，这个一维DP代表的是什么东西？想了半天，画图，后面弄懂了<p>
     * 图像 斜角对称性<p>
     * 1  1  1  1<p>
     * 1  2  3  4<p>
     * 1  3  6 10 15<p>
     * +  +  +  +<p>
     * 3  6 10 15<p>
     * + 3  4  5<p>
     *
     * @param m
     * @param n
     * @return
     */
    public static int dpTwo(int m, int n) {
        count++;
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[j] = 1;
                } else {
                    // 1 2 3 4 6 10 15 20 35 70
                    dp[j] += dp[j - 1];
//                    System.out.print("i" + i);
//                    System.out.print(", j" + j + ", ");
//                    System.out.println(dp[j]);
                }
            }
        }
        return dp[n - 1];
    }

    /**
     * 解法7 数学解法 已通过leetcode提交<p>
     * 看题解，提取主干思路：<p>
     * &nbsp;&nbsp;发现数据规律：排列组合定理<p>
     * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
     * &nbsp;&nbsp;1.排列组合公式都忘了，因此把公式复习了一遍，并且做题验证<p>
     * &nbsp;&nbsp;2.如何把公式套用到程序里<p>
     * &nbsp;&nbsp;3.double int<p>
     * 图像<p>
     * 1  1  1  1<p>
     * 1  2  3  4<p>
     * 1  3  6  10 15<p>
     * 1  4  10 20 35<p>
     * · · · 15 35 70<p>
     * <p>
     * 公式 C(4, 3) = A(4,3)/ A(3,3) = 4*3*2 / 3*2*1 = 4<p>
     * 证明 abcd => abc abd acd bcd<p>
     * 公式 C(4, 2) = 4 * 3 / 2 = 6<p>
     * 证明 abcd => ab ac ad bc bd cd<p>
     * <p>
     * 证明 C5,3 = C5,5-3 = C5,2<p>
     * abcde<p>
     * C53 = abc abd abe acd ace ade + C43 = 10<p>
     * C52 = 5*4/2 = 10<p>
     * <p>
     * n > k<p>
     * C(n, k) = A(n,k) / A(k,k) = C(n, n-k) = A(n,n-k)  / A(n-k,n-k)<p>
     * C52     = 5 * 4  / 2!     = C53       = 5 * 4 * 3 / 3!<p>
     * = (n * n-1 * n-2 ... * n - k + 1) / k!<p>
     *
     * @param m
     * @param n
     * @return
     */
    public static int math(int m, int n) {
        // 总步数
        int t = n + m - 2;
        // 单单往下(或往右)的步数
        int k = m - 1;
        double res = 1;
        for (int i = 1; i <= k; i++) {
//            System.out.print("i" + i);
//            System.out.print(", res=" + res + ", ");
//            System.out.print((t - k + i));
            // C = ((t - k + 1) * (t - k + 2) * ... * t) / k!
            res = res * (t - k + i) / i;
//            System.out.println(", res=" + res + ", ");
        }
        return (int)res;
    }

    // DFS

}
