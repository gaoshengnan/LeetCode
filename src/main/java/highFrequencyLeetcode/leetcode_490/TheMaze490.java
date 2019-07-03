package highFrequencyLeetcode.leetcode_490;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
 * 问题：
 * There is a ball in a maze with empty spaces and walls.
 * The ball can go through empty spaces by rolling up, down, left or right,
 * but it won't stop rolling until hitting a wall. When the ball stops,
 * it could choose the next direction.
 * <p>
 * Given the ball's start position, the destination and the maze,
 * determine whether the ball could stop at the destination.
 * <p>
 * The maze is represented by a binary 2D array.
 * 1 means the wall and 0 means the empty space.
 * You may assume that the borders of the maze are all walls.
 * The start and destination coordinates are represented by row and column indexes.
 * <p>
 * Example 1
 * <p>
 * Input 1: a maze represented by a 2D array
 * <p>
 * 0 0 1 0 0<p>
 * 0 0 0 0 0<p>
 * 0 0 0 1 0<p>
 * 1 1 0 1 1<p>
 * 0 0 0 0 0
 * <p>
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
 * <p>
 * Output: true
 * Explanation: One possible way is :
 * left -> down -> left -> down -> right -> down -> right.
 * <p>
 * Note:
 * <li>The number of stones is ≥ 2 and is < 1,100.</li>
 * <li>Each stone's position will be a non-negative integer < 231.</li>
 * <li>The first stone's position is always 0.</li>
 * <p>
 * 题解方案topics：
 * dfs bfs
 * <p>
 * 参考
 * https://blog.csdn.net/magicbean2/article/details/78706612/<p>
 * https://www.cnblogs.com/grandyang/p/6381458.html<p>
 * https://blog.csdn.net/K346K346/article/details/51289478
 *
 * @author li tong
 * @date 2019/6/26 16:27
 * @see Object
 * @since 1.0
 */
public class TheMaze490 {

  public static void main(String[] args) {
    int[][] maze = new int[5][5];
    maze[0][2] = 1;
    maze[2][3] = 1;
    maze[3][0] = 1;
    maze[3][1] = 1;
    maze[3][3] = 1;
    maze[3][4] = 1;
    int[] start = new int[]{0, 4};
    // destination测试样本 1,2 ok | 2,4 ok | 3,2 no
    int[] destination = new int[]{3, 2};
    System.out.println(hasPath(maze, start, destination));
  }

  public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
    if (maze == null || maze[0] == null) return true;
    int m = maze.length, n = maze[0].length;
    boolean[][] dp = new boolean[m][n];
    bfs_refer_official_and_magicbean(maze, dp, start, destination);
    return dfs_refer_official_and_magicbean(maze, dp, start, destination);
//    return dfs_refer_magicbean(maze, start, destination, dp);
//    return dfs_by_official(maze, dp, start, destination);
//    return dfs_refer_grandyang(maze, dp, start[0], start[1], destination[0], destination[1]);
  }

  private static boolean bfs_refer_official_and_magicbean(int[][] maze, boolean[][] visited, int[] start, int[] destination) {
    if (maze == null || maze[0] == null) {
      return false;
    }
    LinkedList<int[]> queue = new LinkedList<>();
    queue.addLast(start);
    while (!queue.isEmpty()) {
      int[] top = queue.removeFirst();
      if (!visited[top[0]][top[1]]) {
        if (top[0] == destination[0] && top[1] == destination[1]) {
          return true;
        } else {
          visited[top[0]][top[1]] = true;
          for (Integer[] dir : getDir()) {
            int[] next = roll(maze, top, dir);
            queue.push(next);
          }
        }
      }
    }
    return false;
  }

  /**
   * 方向 难点 方向的构造在整个题目里是一块难点
   */
  private static List<Integer[]> getDir() {
    List<Integer[]> dirs = new ArrayList<>(4);
    Integer[] up = new Integer[]{-1, 0};
    dirs.add(up);
    Integer[] right = new Integer[]{0, 1};
    dirs.add(right);
    Integer[] down = new Integer[]{1, 0};
    dirs.add(down);
    Integer[] left = new Integer[]{0, -1};
    dirs.add(left);
    return dirs;
  }

  /**
   * 滚动
   *
   * @param maze
   * @param start
   * @param direction
   * @return
   */
  private static int[] roll(int[][] maze, int[] start, Integer[] direction) {
    System.out.print(Arrays.toString(direction) + "->");
    int[] next = {start[0] + direction[0], start[1] + direction[1]};
    int row_len = maze.length, col_len = maze[0].length;
    if (next[0] < 0 || next[0] >= row_len || next[1] < 0 || next[1] >= col_len
            || maze[next[0]][next[1]] == 1) {
      return start;
    }
    return roll(maze, next, direction);
  }

  /**
   * 参考官方和博客后修正
   */
  private static boolean dfs_refer_official_and_magicbean(int[][] maze, boolean[][] visited, int[] start, int[] destination) {
    // 放在visited判断之上 因为 可以重复经过
    if (start[0] == destination[0] && start[1] == destination[1])
      return true;
    if (visited[start[0]][start[1]]) {
      return false;
    }
    visited[start[0]][start[1]] = true;
    for (Integer[] dir : getDir()) {
      int[] next = roll(maze, start, dir);
      if (next == destination || dfs_refer_official_and_magicbean(maze, visited, next, destination)) {
        return true;
      }
    }
    return false;
  }

  /**
   * https://blog.csdn.net/magicbean2/article/details/78706612/
   */
  private static boolean dfs_refer_magicbean(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
    if (start[0] == destination[0] && start[1] == destination[1])
      return true;
    if (visited[start[0]][start[1]]) {
      return false;
    }
    visited[start[0]][start[1]] = true;
    List<Integer[]> dirs = getDir();
    for (int i = 0; i < 4; ++i) {
      int[] next = roll(maze, start, dirs.get(i));
      if (next == destination || dfs_refer_magicbean(maze, next, destination, visited)) {
        return true;
      }
    }
    return false;
  }

  /**
   * https://leetcode.com/articles/the-maze/
   */
  private static boolean dfs_by_official(int[][] maze, boolean[][] visited, int[] start, int[] destination) {
    if (visited[start[0]][start[1]]) {
      return false;
    }
    if (start[0] == destination[0] && start[1] == destination[1])
      return true;
    visited[start[0]][start[1]] = true;
    // to left
    int left = start[1] - 1;
    while (left >= 0 && maze[start[0]][left] == 0) {
      System.out.print("L->");
      left--;
    }
    if (dfs_by_official(maze, visited, new int[]{start[0], left + 1}, destination))
      return true;
    // to up
    int up = start[0] - 1;
    while (up >= 0 && maze[up][start[1]] == 0) {
      System.out.print("U->");
      up--;
    }
    if (dfs_by_official(maze, visited, new int[]{up + 1, start[1]}, destination)) {
      return true;
    }
    // to right
    int right = start[1] + 1;
    while (right < maze[0].length && maze[start[0]][right] == 0) {
      System.out.print("R->");
      right++;
    }
    if (dfs_by_official(maze, visited, new int[]{start[0], right - 1}, destination)) {
      return true;
    }
    // to down
    int down = start[0] + 1;
    while (down < maze.length && maze[down][start[1]] == 0) {
      System.out.print("D->");
      down++;
    }
    if (dfs_by_official(maze, visited, new int[]{down - 1, start[1]}, destination)) {
      return true;
    }
    return false;
  }

  /**
   * https://www.cnblogs.com/grandyang/p/6381458.html
   */
  private static boolean dfs_refer_grandyang(int[][] maze, boolean[][] dp, int i, int j, int di, int dj) {
    if (i == di && j == dj) return true;
    if (dp[i][j]) return dp[i][j];
    boolean res = false;
    int m = maze.length, n = maze[0].length;
    maze[i][j] = -1;
    for (Integer[] dir : getDir()) {
      int x = i, y = j;
      while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
        x += dir[0];
        y += dir[1];
      }
      x -= dir[0];
      y -= dir[1];
      if (maze[x][y] != -1) {
        res |= dfs_refer_grandyang(maze, dp, x, y, di, dj);
      }
    }
    dp[i][j] = res;
    return res;
  }

  private static void printArr(boolean[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(i + " : ");
      for (int j = 0; j < arr.length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private static void printArr(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(i + " : ");
      for (int j = 0; j < arr.length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

}
