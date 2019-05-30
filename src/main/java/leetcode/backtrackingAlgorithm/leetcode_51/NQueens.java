package leetcode.backtrackingAlgorithm.leetcode_51;

import java.util.List;

/**
 * @author Seina
 * @version 2019-05-30 17:08:35
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {

        //下标表示行，值表示 queen 存储在哪一列
        int[] result = new int[n];

        //一级递归
        calNQueens(0, result);
        return null;

    }

    private void calNQueens(int row, int[] result) {
        if ((row == 8)) {
            printQueens(result);
            return;
        }
        for (int column = 0; column < 8; ++column) {
            if (isOk(row, column, result)) {
                result[row] = column;
                calNQueens(row + 1, result);
            }
        }
    }

    private boolean isOk(int row, int column, int[] result) {
        int leftup = column - 1, rightup = column + 1;
        for (int i = row - 1; i >= 0; --i) {
            if (result[i] == column) return false;
            if (leftup >= 0) {
                if (result[i] == leftup) return false;
            }
            if (rightup < 8) {
                if (result[i] == rightup) return false;
            }
            --leftup;
            ++rightup;
        }
        return true;
    }

    //打印出一个二维矩阵
    private void printQueens(int[] result) {
        for (int row = 0; row < result.length; ++row) {
            for (int column = 0; column < result.length; ++column) {
                if (result[row] == column) System.out.println("Q ");
                else System.out.println("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
