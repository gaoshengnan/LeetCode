package highFrequencyLeetcode.leetcode_104;

/**
 * <p>
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回它的最大深度 3 。
 *
 * </p>
 *
 * @author Seina
 * @version 2019-06-19 14:40:54
 */
public class MaximumDepthOfBinaryTree {

    /**
     * 解法1 递归
     * 
     * 递归循环做的事情：先求左子树深度，再求右子树深度，然后取两者最大，再加上自身一层的深度
     * 
     * 时间复杂度: O(n)
     * 空间复杂度: 最坏时树完全不平衡 O(n)，最好时树完全平衡 O(logn)
     * @param root：根节点
     * @return 树的最大深度
     */
    public int maxDepth(TreeNode root) {
        //递归终止条件：叶子节点无左右子节点
        if (root == null) {
            return  0;
        }
        else {
            //左子树深度
            int leftHeight = maxDepth(root.left);
            //右子树深度
            int rightHeight = maxDepth(root.right);
            // + 1 表示每次递归结束，求深度的时候，要把自身所在一层深度加上
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
