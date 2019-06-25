package highFrequencyLeetcode.leetcode_98;

/**
 * <p>
 *
 *  给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 *  假设一个二叉搜索树具有如下特征：
 *
 *
 *  节点的左子树只包含小于当前节点的数。
 *  节点的右子树只包含大于当前节点的数。
 *  所有左子树和右子树自身必须也是二叉搜索树。
 *
 *
 *  示例 1:
 *
 *  输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 *
 *  示例 2:
 *
 *  输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 *
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4
 *
 * </p>
 *
 * @author Seina
 * @version 2019-06-25 21:44:46
 */
public class ValidateBinarySearchTree {

    /**
     * 解法1
     *
     * 正常二叉搜索树：【左子节点】 < 【根节点】 < 【右子节点】
     *
     * root.val >= max: 根节点比最大值还大，那么肯定大于右子节点，直接返回 false
     * root.val <= min: 根节点比最小值还小，那么肯定小于左子节点，直接返回 false
     *
     * 时间复杂度：O(n) 需要遍历到每个节点
     * 空间复杂度：最坏 O(n) 最好 O(logn)
     *
     * @param root: 根节点
     * @return 是否是二叉搜索树
     */
    public boolean isValidBST (TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValid(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        /**
         * 双与（&&）：只要有一个false 就返回 false，另外前者为 false 时，不去计算后者
         *
         * 比较左子节点时，根节点最大
         * 比较右子节点时，根节点做小
         */
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
