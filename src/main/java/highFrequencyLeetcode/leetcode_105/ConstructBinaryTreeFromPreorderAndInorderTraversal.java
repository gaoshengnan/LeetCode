package highFrequencyLeetcode.leetcode_105;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preOrder = [3, 9, 20, 15, 7]
 * 中序遍历 inOrder = [9, 3, 15, 20, 7]
 *
 * 返回如下的二叉树：
 *
 *      3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * </p>
 *
 * @author Seina
 * @version 2019-06-24 23:39:47
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {


    /**
     * 解法1 递归
     *
     * 前序便利的第一个元素一定是树的根，然后这个根将中序遍历分成左右两颗子树，再通过移动指针递归两个子树，不停给左右子节点赋值，最后完成树的构建
     *
     * @param preOrder: 前序遍历
     * @param inOrder: 中序遍历
     * @return 构建好树返回根节点
     */
    public TreeNode buildTree(int[] preOrder, int[] inOrder){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inOrder.length; i++)
            map.put(inOrder[i], i);
        return build(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, map);
    }

    /**
     * @param pre : 前序遍历 preOrder
     * @param ps  : preOrder start
     * @param pe  : preOrder end
     * @param in  : 中序遍历 inOrder
     * @param is  : inOrder start
     * @param ie  : inOrder end
     * @param map : inOrder map - key: 中序遍历数组元素 value: 元素数组下表
     * @return 构建完成返回根节点
     */
    private TreeNode build(int[] pre, int ps, int pe, int[] in, int is, int ie, Map<Integer, Integer> map) {
        if (ps > pe || is > ie) return null;
        //前序遍历的第一个元素一定是树的根
        TreeNode root = new TreeNode(pre[ps]);

        //找到这个根在中序遍历中的位置，它将中序遍历分成了左右两颗子树
        int rootIndex = map.get(root.val);

        //距离 = 根在中序遍历中的位置 - 左子节点的位置
        int distance = rootIndex - is;

        /**
         * ps + 1        : 前序遍历中 - 左子树的开始节点
         * ps + distance : 前序遍历中 - 左子树的结束节点
         * is            : 中序遍历中 - 左子树的开始节点
         * rootIndex - 1 : 中序遍历中 - 左子树的结束节点
         */
        root.left = build(pre, ps + 1, ps + distance, in, is, rootIndex - 1, map);
        /**
         * ps + distance + 1 : 前序遍历中 - 右子树的开始节点
         * pe                : 前序遍历中 - 右子树的结束节点
         * rootIndex + 1     : 中序遍历中 - 右子树的开始节点
         * ie                : 中序遍历中 - 右子树的结束节点
         */
        root.right = build(pre, ps + distance + 1, pe, in, rootIndex + 1, ie, map);
        return root;
    }
}
