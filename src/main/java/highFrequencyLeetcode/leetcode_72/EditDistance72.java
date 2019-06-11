package highFrequencyLeetcode.leetcode_72;

/**
 * Hard
 * (注解文档查看快捷键 选中类名或方法名 按ctrl + Q)
 * <p>
 * 思维全过程记录方案：<p>
 * 1 背基础结构和算法      | 记录在课程笔记<p>
 * 2 看题 -> 悟题 思考过程 | 记录在wiki<p>
 * 3 悟题 -> 写题 实现难点 | 记录在代码注解<p>
 * 4 写题 -> 优化 多种解法 | 记录在leetcode提交
 * <p>
 * 问题：
 * Given two words word1 and word2,
 * find the minimum number of operations required to convert word1 to word2.
 * <p>
 * 题解方案topics：
 * string、dp
 *
 * @author li tong
 * @date 2019/6/11 10:06
 * @see Object
 * @since 1.0
 */
public class EditDistance72 {

  public static void main(String[] args) {
//    String word1 = "abc", word2 = "abc";
//    String word1 = "horse", word2 = "rose";
    String word1 = "rose", word2 = "horse";
    System.out.println(minDistance(word1, word2));
    System.out.println(minDistanceDP(word1, word2));
  }

  /**
   * 递归解法 <p>
   * 自己思考结合题解提示，主干思路：<p>
   * &nbsp;&nbsp;1.先过一遍所有可能的解决方案 找到递归思路 2 用mem优化<p>
   * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
   * &nbsp;&nbsp;1 看题解思路 自己尝试实现代码 写出相似度50% 再看答案
   * &nbsp;&nbsp;2 边界条件处理
   * &nbsp;&nbsp;3 多种路径组合出正确的递归写法
   * &nbsp;&nbsp;4 如何合并到最终结果<p>
   *
   * @param word1
   * @param word2
   * @return
   */
  public static int minDistance(String word1, String word2) {
    char[] w1 = word1.toCharArray();
    char[] w2 = word2.toCharArray();
    int l1 = w1.length, l2 = w2.length;
    int[][] mem = new int[l1][l2];
    return helpWithMem(0, w1, 0, w2, mem);
  }

  private static int helpWithMem(int i, char[] w1, int j, char[] w2, int[][] mem) {
    int insertCnt, deleteCnt, replaceCnt;
    if (i == w1.length) {
      return w2.length - j;
    }
    if (j == w2.length) {
      return w1.length - i;
    }
    if (mem[i][j] > 0) {
      return mem[i][j];
    }
    int res = 0;
    if (w1[i] == w2[j]) {
//      System.out.println("i=" + i);
      res = helpWithMem(i + 1, w1, j + 1, w2, mem);
//      System.out.println("i=" + i);
      return res;
    } else {
      deleteCnt = helpWithMem(i + 1, w1, j, w2, mem);
//      System.out.println(deleteCnt);
      insertCnt = helpWithMem(i, w1, j + 1, w2, mem);
//      System.out.println(insertCnt);
      replaceCnt = helpWithMem(i + 1, w1, j + 1, w2, mem);
//      System.out.println(replaceCnt);
      mem[i][j] = Math.min(insertCnt, Math.min(deleteCnt, replaceCnt)) + 1;
    }
    return mem[i][j];
  }

  /**
   * DP
   * 1 求极值
   * 2 子问题最优解
   * 3 dp和递归不同的是 dp是循环 递归是栈
   * 4 dp倾向于倒序
   * . Ø a b c d
   * Ø 0 1 2 3 4
   * b 1 1 1 2 3
   * b 2 2 1 2 3
   * c 3 3 2 1 2
   *
   * @param word1
   * @param word2
   * @return
   */
  public static int minDistanceDP(String word1, String word2) {
    char[] w1 = word1.toCharArray();
    char[] w2 = word2.toCharArray();
    int l1 = w1.length, l2 = w2.length;
    int[][] dp = new int[l1 + 1][l2 + 1];
    for (int i = 0; i <= l1; ++i) {
      dp[i][0] = i;
    }
    for (int i = 0; i <= l2; ++i) {
      dp[0][i] = i;
    }
    for (int i = 1; i <= l1; ++i) {
      for (int j = 1; j <= l2; ++j) {
        if (w1[i - 1] == w2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        }
      }
    }
    return dp[l1][l2];
  }

}
