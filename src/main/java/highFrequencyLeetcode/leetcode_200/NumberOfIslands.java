package highFrequencyLeetcode.leetcode_200;

/**
 * <p>
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 *  示例 1:
 *
 *  输入:
 *  11110
 *  11010
 *  11000
 *  00000
 *
 *  输出: 1
 *
 *
 *  示例 2:
 *
 *  输入:
 *  11000
 *  11000
 *  00100
 *  00011
 *
 *  输出: 3
 *
 * </p>
 *
 * @author Seina
 * @version 2019-07-04 21:28:48
 */
public class NumberOfIslands {

    /**
     * 解法1 染色 DFS
     *
     * 遇到岛屿就递归将其上下左右都从 1 -> 0，并且累加 岛屿数量
     *
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(1)
     *
     * @param gird：二维网格
     * @return 岛屿数量
     */
    public  int numIdlands(char[][] gird) {
        int count = 0;
        for (int i = 0; i < gird.length; i++) {
            for (int j = 0; j < gird[0].length; j++) {
                if (gird[i][j] == '1') {
                    dfsFill(gird, i, j);
                    count ++;
                }
            }
        }
        return count;
    }

    private void dfsFill(char[][] gird, int i, int j) {
        //是 1 再继续染色，否则退出
        if (i >= 0 && j >= 0 && i < gird.length && j < gird[0].length && gird[i][j] == '1') {
            gird[i][j] = '0';//把陆地 1 染成水 0，表示这个岛屿已经累加过了
            dfsFill(gird, i + 1, j);//下
            dfsFill(gird, i - 1, j);//上
            dfsFill(gird, i, j + 1);//右
            dfsFill(gird, i, j - 1);//左
        }
    }
}
