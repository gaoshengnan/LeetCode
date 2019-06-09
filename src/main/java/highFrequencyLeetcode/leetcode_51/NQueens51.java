package highFrequencyLeetcode.leetcode_51;

import java.util.ArrayList;
import java.util.List;

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
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * 题解方案topics：
 * backtracking
 *
 * @author li tong
 * @date 2019/6/8 18:38
 * @see Object
 * @since 1.0
 */
public class NQueens51 {

  public static void main(String[] args) {
    System.out.println(solveNQueens(4));

//    int col = 3, row = 2;
//    for (int i = 0, j = col + row; i < row; i++, j--) {
//      System.out.print(i);
//      System.out.print(j);
//      System.out.println();
//    }
  }

  public static List<List<String>> solveNQueens(int n) {
    char[][] chess = new char[n][n];
    // 1 构造初始空间
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        chess[i][j] = '.';
      }
    }
    // 二维数组的长度是其一维的长度 不一定是行还是列 行列的定义是相对的 但默认可理解为行数
//    System.out.println("length" + chess.length);
//    printA(chess);
    List<List<String>> res = new ArrayList<>();
    solve(res, chess, 0);
    return res;
  }

  private static void solve(List<List<String>> res, char[][] chess, int row) {
    if (row == chess.length) {
      res.add(construct(chess));
      return;
    }
    for (int col = 0; col < chess.length; col++) {
      // 难点 这段的实现 先Q 然后递归 然后.
      if (isValid(chess, row, col)) {
        chess[row][col] = 'Q';
        // row + 1 而不是 row++
        solve(res, chess, row + 1);
        chess[row][col] = '.';
      }
//      printA(chess);
//      try {
//        Thread.sleep(100);
//      } catch (Exception e) {
//      }
    }
  }

  /**
   * .Q.Q.Q
   * ..QQQ.
   * x..x.x row2col3 => i0j1,i1j2,i2j3 | i0j5,i1j4,i2j3
   * ..x.x. r3c2 5-4+1 i2j3=5-2
   * 关键：只观察其上面的，不考虑下面的
   *
   * @param chess
   * @param row
   * @param col
   * @return
   */
  private static boolean isValid(char[][] chess, int row, int col) {
    for (int i = 0; i < row; i++) {
      if (chess[i][col] == 'Q') {
        return false;
      }
    }
    for (int i = col - row < 0 ? row - col : 0, j = col - row + i; i < row; i++, j++) {
//      System.out.print("r" + row);
//      System.out.println("c" + col);
//      System.out.print("i" + i);
//      System.out.println("j" + j);
      if (chess[i][j] == 'Q') {
        return false;
      }
    }
    for (int i = col + row >= chess.length ? col + row - chess.length + 1 : 0, j = col + row - i; i < row; i++, j--) {
//      System.out.print("r" + row);
//      System.out.println("c" + col);
//      System.out.print("i" + i);
//      System.out.println("j" + j);
      if (chess[i][j] == 'Q') {
        return false;
      }
    }
    return true;
  }

  private static List<String> construct(char[][] chess) {
    List<String> path = new ArrayList<>();
    for (int i = 0; i < chess.length; i++) {
      path.add(new String(chess[i]));
    }
    return path;
  }

  private static void printA(char[][] array) {
    for (char[] arr : array) {
      for (char a : arr) {
        System.out.print(a);
      }
      System.out.println();
    }
    System.out.println();
  }

}
