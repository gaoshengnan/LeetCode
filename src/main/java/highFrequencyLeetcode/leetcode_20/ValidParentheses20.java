package highFrequencyLeetcode.leetcode_20;

import java.util.Stack;

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
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * 题解方案topics：
 * string、stack
 *
 * @author li tong
 * @date 2019/6/8 11:25
 * @see Object
 * @since 1.0
 */
public class ValidParentheses20 {

  public static void main(String[] args) {
    System.out.println(isValid("()"));
  }

  public static boolean isValid(String s) {
    Stack t = new Stack();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        t.push(c);
      } else {
        if (c == ')' && (t.isEmpty() || !t.peek().equals('('))) {
          return false;
        }
        if (c == ']' && (t.isEmpty() || !t.peek().equals('['))) {
          return false;
        }
        if (c == '}' && (t.isEmpty() || !t.peek().equals('{'))) {
          return false;
        }
        t.pop();
      }
    }
    return t.isEmpty();
  }

}
