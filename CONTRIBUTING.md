### 题解提交说明

#### Setp1 题解位置

在 highFrequencyLeetcode 下面新建对应题目路径：leetcode_题号，例如：leetcode_1；然后在 leetcode_1 文件路径下新建题解类，类名：题目对应名称，例如：TwoSum.java。

如果此时 leetcode_1 下面已经有人写了题解，那么再新建一个 TwoSum2.java 来写自己的题解。

#### Setp2 题解类里面格式注意

提交题解按照如下格式：

```java
/**
 * <p>
 * 题目说明
 * </p>
 *
 * @author 作者名
 * @version 时间
 */
public class TwoSum {

    /**
     * 解法1 题解名称
     * 
     * 思路一句话简单明了说明
     * 
     * 时间复杂度 
     * 空间复杂度 
     */
    public int[] twoSum1(int[] nums, int target) {//方法名称对应 leetcode 中方法名，方便提交
     		//题解
    }

    /**
     * 解法2 题解名称
     * 
     * 思路一句话简单明了说明
     * 
     * 时间复杂度 
     * 空间复杂度 
     */
    public int[] twoSum2(int[] nums, int target) {//方法名称对应 leetcode 中方法名，方便提交
     		//题解
    }
```

示例题解如下：

```java
package highFrequencyLeetcode.leetcode_1;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 *  你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 *  示例:
 *
 *  给定 nums = [2, 7, 11, 15], target = 9
 *
 *  因为 nums[0] + nums[1] = 2 + 7 = 9
 *  所以返回 [0, 1]
 * </p>
 *
 * @author Seina
 * @version 2019-06-13 23:05:17
 */
public class TwoSum {

    /**
     * 解法1 暴力法
     * 
     * 遍历每个元素 x，并查找是否存在一个值与 target - x 相等的目标元素
     * 
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
     * 
     * 循环一次将元素插入到哈希表，如果发现哈希表中已经存在当前元素对应的目标元素，会立即返回
     * 
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
```

#### Setp3 注意事项

1. 所有提交的题解要求在 leetcode 上提交超过 80% 以上



如果针对以上 pr 规范有疑问或者补充，欢迎提 issues 或者直接联系我～
