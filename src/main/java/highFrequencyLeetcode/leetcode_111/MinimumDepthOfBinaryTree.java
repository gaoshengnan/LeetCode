package highFrequencyLeetcode.leetcode_111;

/**
 * <p>
 *
 *  给定一个二叉树，找出其最小深度。
 *
 *  最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 *  说明: 叶子节点是指没有子节点的节点。
 *
 *  示例:
 *
 *  给定二叉树 [3,9,20,null,null,15,7],
 *
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *  返回它的最小深度 2.
 *
 * </p>
 *
 * @author Seina
 * @version 2019-06-19 20:25:50
 */
public class MinimumDepthOfBinaryTree {

    /**
     * 解法1 递归
     * 
     * 取左子树的深度和右子树的深度两者最小为树的最小深度
     * 
     * 时间复杂度：O(n)
     * 空间复杂度：最坏 O(n)，最好 O(logn)
     * 
     * @param root: 根节点
     * @return 返回二叉树的最小深度
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;                   
        }
        if (root.left != null && root.right!= null) 
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        else 
            //如果左子节点为空或者右子节点为空，那么 root 有一个叶子节点也算是一层，所以取 max，再加上当前节点所在的一层
            //如果左右子节点都为空，那么返回节点所在的一层
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
