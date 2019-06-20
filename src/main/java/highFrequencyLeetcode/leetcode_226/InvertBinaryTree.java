package highFrequencyLeetcode.leetcode_226;

import highFrequencyLeetcode.leetcode_226.TreeNode;

/**
 * <p>
 *
 * 翻转一棵二叉树。
 *
 *  示例：
 *
 *  输入：
 *
 *       4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 *  输出：
 *
 *       4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *  备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 *  谷歌：我们 90％ 的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *
 * </p>
 *
 * @author Seina
 * @version 2019-06-19 18:05:30
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null || root.right == null && root.left == null) return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = invertTree(left);
        root.left = invertTree(right);
        return root;
    }


}


























