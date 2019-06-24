package highFrequencyLeetcode.leetcode_429;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * <p>
 *
 *  给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 *  例如，给定一个 3叉树
 *
 *              【1】
 *             /  |  \
 *            /   |   \
 *         【3】 【2】 【4】
 *         /  \
 *        /    \
 *     【5】   【6】
 *
 *  返回其层序遍历:
 *
 *  [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 *  说明:
 *
 *  树的深度不会超过 1000。
 *  树的节点总数不会超过 5000。
 *
 * </p>
 * @author Seina
 * @version 2019-06-24 11:03:15
 */
public class NAryTreeLevelOrderTraversal {

    /**
     * 解法1 循环 + 递归
     *
     * 先一直递归调用到叶子节点，然后慢慢开始将节点塞入对应的层，有点类似回溯的思想，遍历节点的顺序也有点类似 dfs
     *
     * 时间复杂度：O(n)
     * 空降复杂度：O(n)
     *
     * @param root: 根节点
     */
    public List<List<Integer>> levelOrder(Node root) {
        return traverse(root, 0, new ArrayList<List<Integer>>());
    }

    private List<List<Integer>> traverse(Node node, int level, List<List<Integer>> res) {
        if (node == null) {
            return res;
        }
        //如果 res.size() > level 说明该节点所在的 level 在 res 中已经有位置
        List<Integer> levelList = res.size() > level ? res.get(level) : new ArrayList<Integer>();

        levelList.add(node.val);

        //如果 res.size() <= level 表示该节点所在的 level 在 res 中没有位置
        if (res.size() <= level)
            res.add(levelList);

        //循环开始递归进入下一层的孩子节点们
        for (Node n : node.children)
            traverse(n, level + 1, res);
        return res;
    }


}