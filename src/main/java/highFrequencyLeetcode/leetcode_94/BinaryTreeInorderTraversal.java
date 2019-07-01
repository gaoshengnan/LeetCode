package highFrequencyLeetcode.leetcode_94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 *
 * 给定一个二叉树，返回它的中序 遍历。（左中右）
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
 * 输出: [1,3,2]
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * </p>
 *
 * @author Seina
 * @version 2019-06-17 19:38:32
 */
public class BinaryTreeInorderTraversal {

    /**
     * 
     * 解法1 递归
     * 
     * 一级递归传入根节点，然后分别递归遍历左子树和右子树
     * 递归就在做重复的事情：每次传入根节点，然后添加左节点->根->右节点
     * 
     * 时间复杂度: O(n) -> 二叉树的节点个数
     * 空间复杂度: 最坏 O(n), 平均 O(logn) -> 二叉树的深度
     * 
     * @param root: 根节点
     * @return 中序遍历结果
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traverse(root, res);
        return res;
    }

    private void traverse(TreeNode root, List<Integer> res) {
        //root 为空，就不用继续递归下去了
        if (root != null) {
            if (root.left != null) {
                traverse(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                traverse(root.right, res);
            }
        }
    }

    /**
     * 
     * 解法2 非递归 使用栈
     * 
     * 使用栈来记录节点，先左子树走到底，然后开始添加到结果 res 中，然后再右子树
     * 
     * 时间复杂度: O(n) 
     * 空间复杂度: O(n)
     * 
     * @param root: 根节点
     * @return 中序遍历结果
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        //!stack.empty()：表示栈中还有未添加到 res 的节点
        while(cur != null || !stack.empty()) {
            //将左节点走到底依次入栈
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            //向下一层循环传入右节点
            cur = cur.right;
        }
        return res;
    }
}
