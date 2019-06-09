package highFrequencyLeetcode.leetcode_10;

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
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * 题解方案topics：
 * string、dp、backtracking
 *
 * @author li tong
 * @date 2019/6/8 16:16
 * @see Object
 * @since 1.0
 */
public class RegularExpression10 {

  public static void main(String[] args) {
//    String s = "mississippi", p = "mis*is*p*.";
//    String s = "aab", p = "c*a*b";
//    String s = "aab", p = "aa*b";
//    String s = "aaa", p = "aaaa";
//    String s = "aa", p = "a";
//    String s = "aa", p = "a*";
//    String s = "ab", p = "a";
//    String s = "ab", p = "ab";
//    String s = "ab", p = ".*";
//    String s = "aaa", p = "ab*ac*a";
//    String s = "aaa", p = "ab*a*c*a";
//    String s = "", p = "";
//    String s = "", p = ".*";
//    String s = "", p = "abc";
//    String s = "bbba", p = ".*a*a";
//    String s = "aaca", p = "ab*a*c*a"; // aa*c*a
    String s = "aasdfasdfasdfasdfas", p = "aasdf.*asdf.*asdf.*asdf.*s";
    System.out.println(isMatch(s, p));
    System.out.println(dp2(s, p));
  }

  /**
   * 解法2 DP<p>
   * 看题解，主干思路：<p>
   * &nbsp;&nbsp;二维DP<p>
   * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
   * &nbsp;&nbsp;边界条件 *号时候的处理
   *
   * @return
   */
  public static boolean dp2(String s, String p) {
    if (s == null || p == null) {
      return false;
    }
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true; // s, p

    // 这里
    for (int i = 0; i < p.length(); i++) {
      if (p.charAt(i) == '*' && dp[0][i - 1]) {
        dp[0][i + 1] = true;
      }
    }

    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < p.length(); j++) {
        if (p.charAt(j) == '.') {
          // 往下走一步 和现在结果一样
          dp[i + 1][j + 1] = dp[i][j];
        }
        if (p.charAt(j) == s.charAt(i)) {
          dp[i + 1][j + 1] = dp[i][j];
        }
        if (p.charAt(j) == '*') {
          // 这里
          if (s.charAt(i) != p.charAt(j - 1) && p.charAt(j - 1) != '.') {
            dp[i + 1][j + 1] = dp[i + 1][j - 1];
          } else {
            dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
          }
        }
      }
    }
    return dp[s.length()][p.length()];
  }

  /**
   * 解法1 递归<p>
   * 看题解，主干思路：<p>
   * &nbsp;&nbsp;借助递归处理*号时的情况<p>
   * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
   * &nbsp;&nbsp;边界条件处理
   *
   * @return
   */
  public static boolean isMatch(String text, String pattern) {
    if (pattern.isEmpty()) return text.isEmpty();
    boolean first_match = (!text.isEmpty() &&
            (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
    if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
      return (isMatch(text, pattern.substring(2)) ||
              (first_match && isMatch(text.substring(1), pattern)));
    } else {
      return first_match && isMatch(text.substring(1), pattern.substring(1));
    }
  }

}
