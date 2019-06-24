package highFrequencyLeetcode.leetcode_429;

import java.util.List;

/**
 * @author Seina
 * @version 2019-06-23 21:10:00
 */
public class Node {

    int val;
    List<Node> children;

    public Node() {}

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
