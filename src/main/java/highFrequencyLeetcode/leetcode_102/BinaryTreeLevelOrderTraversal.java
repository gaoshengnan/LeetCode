package highFrequencyLeetcode.leetcode_102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *
 * 给定一个二叉树，返回其按层次遍历的节点值.（即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 *
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *  返回其层次遍历结果：
 *
 *  [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * </p>
 *
 * @author Seina
 * @version 2019-06-24 19:02:00
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 解法1 递归
     *
     * 广度优先搜索
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root: 根节点
     * @return 层次遍历
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        bfs(res, root, 0);
        return res;
    }

    private void bfs(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        //通过比较当前节点所在层次和当前最高层次的大小，如果前者更大，就像结果集中添加一个空列表
        if (height >= res.size()) res.add(new LinkedList<Integer>());
        //将当前节点加入到对应层次中
        res.get(height).add(root.val);

        //递归调用左子树 右子树
        bfs(res, root.left, height + 1);
        bfs(res, root.right, height + 1);
    }
}
