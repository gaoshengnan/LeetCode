package highFrequencyLeetcode.leetcode_49;

import java.util.*;

/**
 *
 * <p>
 *
 *  给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 *  示例:
 *
 *  输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 *  输出:
 *  [
 *       ["ate","eat","tea"],
 *       ["nat","tan"],
 *       ["bat"]
 *  ]
 *
 *  说明：
 *
 *
 *  所有输入均为小写字母。
 *  不考虑答案输出的顺序。
 *
 * </p>
 * @author Seina
 * @version 2019-06-16 12:57:00
 */
public class GroupAnagrams {

    /**
     * 解法1 排序数组分类
     * 
     * 将排好序的数组放在 map 集合里，并存储在结果集合里面的索引位置
     * 
     * @param strs: 字符出数组
     * @return 字母异位词的集合
     */
    public List<List<String>> groupAnagrams1(String[] strs){
        List<List<String>> resultList = new ArrayList<List<String>>();

        //key: 排序后的字符串  value：res 中的索引位置
        //按照题目给的例子，map 应该是 (ate, 0) (ant, 1) (abt, 3)
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String str : strs) {
            //先排序
            String sortedStr = sort(str);
            //去 map 里面找，看看有没有属于自己的索引位置
            Integer index = map.get(sortedStr);
            if (index == null) {
                //如果没有，新建一块属于自己的位置（字母异位词的集合）
                List<String> list = new ArrayList<String>();
                list.add(str);
                resultList.add(list);
                map.put(sortedStr, resultList.size() - 1);
            } else {
                //如果有，取出自己的索引位置，直接加入字母异位词的集合
                resultList.get(index).add(str);
            }
        }
        return resultList;
    }

    //字符串排序
    private String sort(String s) {
        //string -> array
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        //array -> string
        return new String(ca);
    }

    /**
     * 解法1 排序数组分类(力扣官方题解)
     *
     * 将排好序的数组放在 map 的 key 里，然后将字母异位词的集合放在 value 里
     *
     * @param strs: 字符出数组
     * @return 字母异位词的集合
     */
    public List<List<String>> groupAnagrams2(String[] strs){
        if (strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List> map = new HashMap<String,List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            //key: 排序后的数组  value：字母异位词的集合
            if (!map.containsKey(key)) map.put(key, new ArrayList<List<String>>());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }


}
