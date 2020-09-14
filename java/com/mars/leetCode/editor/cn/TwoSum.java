package com.mars.leetCode.editor.cn;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        solution.twoSum(nums, target);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] index = new int[2];
            ConcurrentHashMap<Integer, Integer> hashMap = new ConcurrentHashMap<>();
            AtomicInteger integer = new AtomicInteger();
            for (int i = 0; i < nums.length; i++) {
                if (hashMap.contains(target - nums[i])) {
                }
                hashMap.put( nums[i],integer.incrementAndGet());
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
