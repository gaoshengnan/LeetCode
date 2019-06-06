package highFrequencyLeetcode.leetcode_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * (注解文档查看快捷键 选中类名或方法名 按ctrl + Q)
 * <p>
 * 思维全过程记录方案：<p>
 * 1 背基础结构和算法      | 记录在课程笔记<p>
 * 2 看题 -> 悟题 思考过程 | 记录在wiki<p>
 * 3 悟题 -> 写题 实现难点 | 记录在代码注解<p>
 * 4 写题 -> 优化 多种解法 | 记录在leetcode提交
 * <p>
 * 题解方案topics：
 * hash table、two pointers、string、sliding window
 *
 * @author li tong
 * @date 2019/6/6 9:41
 * @see Object
 * @since 1.0
 */
public class LongestSubstring3 {

    public static void main(String[] args) {
        System.out.println("LENGTH=" + slidingASCII("abcabcbb"));
        System.out.println("LENGTH=" + slidingASCII("au"));
        System.out.println("LENGTH=" + slidingASCII("dvcfdc"));
        System.out.println("LENGTH=" + slidingASCII("dvcfda"));
        System.out.println("LENGTH=" + slidingASCII("bbbbb"));
        System.out.println("LENGTH=" + slidingASCII("pwwkew"));
        System.out.println("LENGTH=" + slidingASCII("abbba"));
        System.out.println("LENGTH=" + slidingASCII("tmmzuxt"));
        System.out.println();
    }

    /**
     * 解法1 时间窗 双指针 hash<p>
     * 自己思考，主干思路：<p>
     * &nbsp;&nbsp;hash去重<p>
     * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
     * &nbsp;&nbsp;边界条件（注意字符串的结构 上一次出现重复的位置），反复提交了很多次才过
     *
     * @param s
     * @return
     */
    public static int hash(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>(s.length());
        Set<Integer> lengths = new HashSet<>();
        // 最近一次出现重复的位置
        int start = 0;
        for (int i = 0, l = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer pos = map.get(c);
            if (pos != null) {
                // Caution start > pos
                start = start > pos ? start : pos + 1;
                // 当前窗口跨度
                l = i - start;
            }
            l++;
            lengths.add(l);
            map.put(c, i);
        }
        return lengths.stream().max(Integer::compareTo).get();
    }

    /**
     * 解法2 时间窗 hash<p>
     * 看题解，主干思路：<p>
     * &nbsp;&nbsp;官方题解 和解法一思路差不多<p>
     * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
     * &nbsp;&nbsp;Math.max的运用
     * <p>
     * A sliding window is an abstract concept commonly used in array/string problems.
     * A window is a range of elements in the array/string which usually defined by the start and end indices,
     * i.e. [i, j)[i,j) (left-closed, right-open).
     *
     * @param s
     * @return
     */
    public static int sliding(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /**
     * 解法3 时间窗优化<p>
     * 看题解，主干思路：<p>
     * &nbsp;&nbsp;优化字符串取值范围<p>
     * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
     * &nbsp;&nbsp;不使用Map 利用字符编码特性
     *
     * @param s
     * @return
     */
    public static int slidingASCII(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

}
