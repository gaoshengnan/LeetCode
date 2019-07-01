package highFrequencyLeetcode.leetcode_144;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 *
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * </p>
 *
 * @author Seina
 * @version 2019-06-19 21:18:08
 */
public class BinaryTreePreorderTraversal {

    /**
     * 解法1 递归
     * 
     * 前序遍历，先遍历根节点，再遍历左子树，最后遍历右子树
     * 
     * 时间复杂度：O(n)
     * 空间复杂度：最坏 O(n) 平均 O(logn)
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traverse(root, res);
        return res;
    }
    private void traverse(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                traverse(root.left, res);
            }
            if (root.right != null) {
                traverse(root.right, res);
            } 
        }
    }
}
