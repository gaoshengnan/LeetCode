package highFrequencyLeetcode.leetcode_242;

import java.util.Arrays;

/**
 * <p>
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 *  示例 1:
 *
 *  输入: s = "anagram", t = "nagaram"
 *  输出: true
 *
 *
 *  示例 2:
 *
 *  输入: s = "rat", t = "car"
 *  输出: false
 *
 *  说明:
 *  你可以假设字符串只包含小写字母。
 *
 *  进阶:
 *  如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * </p>
 *
 * @author Seina
 * @version 2019-06-16 21:29:22
 */
public class ValidAnagram {

    /**
     * 解法1 排序后比较
     * 
     * 分别将两个字符串排序，然后比较
     * 
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     */
    public boolean isAnagram(String s, String t){
        if (s.length() != t.length())  return false;
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /**
     * 解法2 计数器
     * 
     * 用计数器统计每个字符出现的次数
     * 
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static boolean isAnagram2(String s, String t){
        if (s.length() != t.length()) return false;
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            //当前字符 - a，a = 97
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            table[t.charAt(i) - 'a']--;
            //减 1 之后出现次数小于就说明就在 s 中从未出现的字符
            if (table[t.charAt(i) - 'a'] < 0) return false;
        }
        return false;
    }
}
