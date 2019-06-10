package highFrequencyLeetcode.leetcode_1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * 解法1 暴力法
     * 遍历每个元素 x，并查找是否存在一个值与 target - x 相等的目标元素
     * 时间复杂度 O(n²)
     * 空间复杂度 O(1)
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++ ) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No Two sum solution");
    }

    /**
     * 解法2 一遍哈希表
     * 循环一次将元素插入到哈希表，如果发现哈希表中已经存在当前元素对应的目标元素，会立即返回
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int[] twoSum2(int[] nums, int target) {
        //key: 元素值  value: 元素索引下标
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for (int i =0; i < nums.length; i++){

            //进入第二轮循环的时候 map 里面才有值，存的是之前的元素
            int temp = target - nums[i];
            
            //判断 map 中是否包含当前元素的对应元素
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No Two sum solution");
    }
}