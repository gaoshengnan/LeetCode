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

    /**
     * 解法1 递归
     *
     * 递归重复做的事情就是：将返回的右节点赋值给 left，将返回的左节点赋值给 right 指针
     *
     * 时间复杂度: O(n)
     * 空间复杂度: 最坏 O(n)，平均 O(logn)
     *
     * @param root: 根节点
     * @return 翻转的二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null || root.right == null && root.left == null) return root;

        //临时变量记录左右节点地址
        TreeNode left = root.left;
        TreeNode right = root.right;

        //递归交换左右节点
        root.right = invertTree(left);
        root.left = invertTree(right);
        return root;
    }


}


























