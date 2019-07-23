package highFrequencyLeetcode.leetcode_63;

/**
 * <p>
 *
 *  一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 *  机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 *  现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *  网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 *  说明：m 和 n 的值均不超过 100。
 *
 *  示例 1:
 *
 *  输入:
 *  [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 *  ]
 *  输出: 2
 *  解释:
 *  3x3 网格的正中间有一个障碍物。
 *  从左上角到右下角一共有 2 条不同的路径：
 *  1. 向右 -> 向右 -> 向下 -> 向下
 *  2. 向下 -> 向下 -> 向右 -> 向右
 *
 * </p>
 *
 * @author Seina
 * @version 2019-07-23 17:01:38
 */
public class UniquePathsII {

    /**
     * 解法1 动态规划
     *
     * 解题思路类似不同路径将 62，这里需要特殊处理的是，要将障碍物的位置变成 0
     *
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     *
     * @param obstacleGrid: 给定包含障碍物的二维表格
     * @return 共有多少种不同路径
     */
    public int uniquePathsWithObstacles (int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        obstacleGrid[0][0] ^= 1;//起始位置 0
        //只要前一个元素是障碍物，后面的第一行全部是 0，因为不能从上面过来，左边又是障碍物
        for (int i = 1; i < m; i++) obstacleGrid[i][0] = (obstacleGrid[i][0] == 1) ? 0 : obstacleGrid[i - 1][0];
        for (int j = 1; j < n; j++) obstacleGrid[0][j] = (obstacleGrid[0][j] == 1) ? 0 : obstacleGrid[0][j - 1];
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                obstacleGrid[i][j] = (obstacleGrid[i][j] == 1) ? 0 : obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
        return obstacleGrid[m - 1][n - 1];
    }
}
